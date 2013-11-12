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

    def getPDFContentBetweenPage(pdfFileLocation: String, pageNumber:Int, endPageNumber:Int): String = {

      val reader = new com.itextpdf.text.pdf.PdfReader(pdfFileLocation)
      val parser = new PdfReaderContentParser(reader)

      println("***NumberOfpage :"+reader.getNumberOfPages)

      val content: Seq[String] = for (i <- pageNumber to endPageNumber) yield {
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

    def testContentMatchesBetweenPage(pdfFileLocation: String,
                                   testCaseXml: Elem,
                                   generateTestData: (Elem => Seq[String]),
                                   matchFunction: ((Seq[String], String) => Boolean), pageNumber:Int, endPageNumber:Int) = {
      testOutputFileExists(pdfFileLocation, testCaseXml)
      val totalContent = getPDFContentBetweenPage(pdfFileLocation, pageNumber, endPageNumber)
      val testData = generateTestData(testCaseXml)

      println("TotalContent " + totalContent)

      matchFunction(testData, totalContent) must beTrue
      //deletePdfFile(pdfFileLocation)
    }


/*
    "extract PDF for SectionPart1AbouYouTheCarer and match contents" in {
      val pdfFileLocation = "goodClaim_contentTestPDF.pdf"
      testContentMatchesFromPage(pdfFileLocation, ClaimBuilder.goodClaim, XMLData.sectionAboutYouTheCarer, foundMustBeTrue, 3)
    }
*/

    /*
    "extract PDF for SectionPart2AboutYourPartner and match contents" in {
      val pdfFileLocation = "goodClaim_contentTestPDF.pdf"
      testContentMatchesFromPage(pdfFileLocation, ClaimBuilder.goodClaim, XMLData.sectionAboutYourPartner, foundMustBeTrue, 5)
    }

    "extract PDF for SectionAboutEmployment and match contents" in {
      val pdfFileLocation = "goodClaim_contentTestPDF.pdf"
      testContentMatchesBetweenPage(pdfFileLocation, ClaimBuilder.goodClaim, XMLData.sectionAboutEmployment, foundMustBeTrue, 5, 7)
    }*/

    /*
    "extract PDF for SectionAboutSelfEmployment and match contents" in {
      val pdfFileLocation = "goodClaim_contentTestPDF.pdf"
      testContentMatchesFromPage(pdfFileLocation, ClaimBuilder.goodClaim, XMLData.sectionAboutSelfEmployment, foundMustBeTrue, 6)
    }*/

    "extract PDF for SectionAboutTheCareYouProvide and match contents" in {
      val pdfFileLocation = "goodClaim_contentTestPDF.pdf"
      testContentMatchesBetweenPage(pdfFileLocation, ClaimBuilder.goodClaim, XMLData.sectionAboutTheCareYouProvide, foundMustBeTrue, 4, 8)
    }

    "extract PDF for SectionAboutOtherMoney and match contents" in {
      val pdfFileLocation = "goodClaim_contentTestPDF.pdf"
      testContentMatchesFromPage(pdfFileLocation, ClaimBuilder.goodClaim, XMLData.sectionAboutOtherMoney, foundMustBeTrue, 6)
    }
  }
}
