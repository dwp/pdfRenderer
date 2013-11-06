package generators

import scala.xml.Elem
import generators.Helper._
import java.io.File
import org.specs2.mutable.Specification
import com.itextpdf.text.pdf.parser.{SimpleTextExtractionStrategy, PdfReaderContentParser}
import test_data.{XMLData, ClaimBuilder}


class SectionsSpec extends Specification {

  "PdfContentMatching" should {

    def deletAndGeneratePDF(pdfFileLocation: String, xml: Elem) = {
      deletePdfFile(pdfFileLocation)
      generatePDF(pdfFileLocation, xml)
    }

    def testOutputFileExists(pdfFileLocation: String, xml: Elem) = {
      deletAndGeneratePDF(pdfFileLocation, xml)
      val pdfFile = new File(pdfFileLocation)
      pdfFile.exists() must beTrue
    }

    def getPDFContentFromPage(pdfFileLocation: String, pageNumber:Int): String = {

      val reader = new com.itextpdf.text.pdf.PdfReader(pdfFileLocation)
      val parser = new PdfReaderContentParser(reader)

      println("***NumberOfpage :"+reader.getNumberOfPages)

      val content: Seq[String] = for (i <- pageNumber to reader.getNumberOfPages) yield {
        val strategy = parser.processContent(i, new SimpleTextExtractionStrategy())

        strategy.getResultantText
      }
      reader.close()

      content.mkString.toLowerCase.replaceAll("\n", " ")
    }

    def foundMustBeTrue(testData: Seq[String], totalContent: String) = {
      testData map (s => println("TestDat "+s))
      testData.forall(x => {
        val found = totalContent.contains(x.toLowerCase)
        if (!found) {
          println("*** Cannot find: " + x.toLowerCase)
          println("*** End ***")
        }
        found
      })
    }

    def testContentMatchesFromPage(pdfFileLocation: String,
                                 testCaseXml: Elem,
                                 generateTestData: (Elem => Seq[String]),
                                 matchFunction: ((Seq[String], String) => Boolean), pageNumber:Int) = {
      testOutputFileExists(pdfFileLocation, testCaseXml)
      val totalContent = getPDFContentFromPage(pdfFileLocation, pageNumber)
      val testData = generateTestData(testCaseXml)

      println("TotalContent " + totalContent)

      matchFunction(testData, totalContent) must beTrue
      //deletePdfFile(pdfFileLocation)
    }

    /*
    "extract PDF for SectionPart1AbouYouTheCarer and match contents" in {
      val pdfFileLocation = "goodClaim_contentTestPDF.pdf"
      testContentMatchesFromPage(pdfFileLocation, ClaimBuilder.goodClaim, XMLData.sectionPart1AboutYouTheCarer, foundMustBeTrue, 3)
    }*/

    "extract PDF for SectionPart2AboutYourPartner and match contents" in {
      val pdfFileLocation = "goodClaim_contentTestPDF.pdf"
      testContentMatchesFromPage(pdfFileLocation, ClaimBuilder.goodClaim, XMLData.sectionPart2AboutYourPartner, foundMustBeTrue, 5)
    }
  }
}
