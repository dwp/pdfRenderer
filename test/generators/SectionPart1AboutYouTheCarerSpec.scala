package generators

import scala.xml.Elem
import generators.Helper._
import java.io.File
import org.specs2.mutable.Specification
import com.itextpdf.text.pdf.parser.{SimpleTextExtractionStrategy, PdfReaderContentParser}
import test_data.{XMLData, ClaimBuilder}


class SectionPart1AboutYouTheCarerSpec extends Specification {

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

    def getPDFContentByPage(pdfFileLocation: String, pageNumber:Int): String = {

      val reader = new com.itextpdf.text.pdf.PdfReader(pdfFileLocation)
      val parser = new PdfReaderContentParser(reader)

      println("***NumberOfpage :"+reader.getNumberOfPages)

      val strategy = parser.processContent(pageNumber, new SimpleTextExtractionStrategy())
      val content: String = strategy.getResultantText

      reader.close()

      val totalContent = content.toLowerCase
      totalContent
    }

    def foundMustBeTrue(testData: Seq[String], totalContent: String) = {
      testData.forall(x => {
        val found = totalContent.contains(x.toLowerCase)
        if (!found) {
          println("*** Cannot find: " + x.toLowerCase)
          println("*** End ***")
        }
        found
      })
    }

    def testContentMatchesByPage(pdfFileLocation: String,
                                 testCaseXml: Elem,
                                 generateTestData: (Elem => Seq[String]),
                                 matchFunction: ((Seq[String], String) => Boolean), pageNumber:Int) = {
      testOutputFileExists(pdfFileLocation, testCaseXml)
      val totalContent = getPDFContentByPage(pdfFileLocation, pageNumber)
      val testData = generateTestData(testCaseXml)

      println("TotalContent " + totalContent)

      matchFunction(testData, totalContent) must beTrue
      deletePdfFile(pdfFileLocation)
    }

    "extract PDF for SectionPart1AbouYouTheCarer and match contents" in {
      val pdfFileLocation = "functionalTestCase1_contentTestPDF.pdf"
      testContentMatchesByPage(pdfFileLocation, ClaimBuilder.functionalTestCase1, XMLData.sectionPart1AboutYouTheCarer, foundMustBeTrue, 2)
    }
  }
}
