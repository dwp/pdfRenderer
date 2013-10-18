package generators

import org.specs2.mutable._
import data_sources.XmlDataSource
import test_data.{XMLData, ClaimBuilder}
import java.io.File
import scala.xml.Elem
import com.itextpdf.text.pdf.parser.{PdfReaderContentParser, SimpleTextExtractionStrategy}


/**
 * Test PdfGenerator with the implicits defined in package object data_sources.
 * @author Jorge Migueis
 */
class PdfContentMatchingSpec extends Specification {

  "PdfContentMatching" should {

    def before(pdfFileLocation: String) = {
      val pdfFile = new File(pdfFileLocation)
      if (pdfFile.exists()) {
        pdfFile.delete()
      }
    }

    def getPdfGenerator(pdfFileLocation: String, xml: Elem) = {
      before(pdfFileLocation)
      val dataSource = new XmlDataSource(xml)
      PdfGenerator(dataSource, pdfFileLocation)
    }

    def testOutputFileExists(pdfFileLocation: String, xml: Elem) = {
      val generator = getPdfGenerator(pdfFileLocation, xml)
      generator.generateFrom()
      val pdfFile = new File(pdfFileLocation)
      pdfFile.exists() must beTrue
    }

    def getPDFContent(pdfFileLocation: String): String = {

      val reader = new com.itextpdf.text.pdf.PdfReader(pdfFileLocation)
      val parser = new PdfReaderContentParser(reader)


      val content: Seq[String] = for (i <- 1 to reader.getNumberOfPages) yield {
        val strategy = parser.processContent(i, new SimpleTextExtractionStrategy())

        strategy.getResultantText
      }
      reader.close()

      val totalContent = content.mkString("\n").toLowerCase
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

    def foundMustBeFalse(testData: Seq[String], totalContent: String) = {
      testData.forall(x => {
        val found = totalContent.contains(x.toLowerCase)
        if (found) {
          println("Should not have found: " + x.toLowerCase)
        }
        !found
      })
    }

    def testContentMatches(pdfFileLocation: String,
                           testCaseXml: Elem,
                           generateTestData: (Elem => Seq[String]),
                           matchFunction: ((Seq[String], String) => Boolean)) = {
      testOutputFileExists(pdfFileLocation, testCaseXml)
      val totalContent = getPDFContent(pdfFileLocation)
      val testData = generateTestData(testCaseXml)

      println("TotalContent " + totalContent)

      matchFunction(testData, totalContent) must beTrue
    }

    "extract PDF for badClaim fails to match contents" in {
      val pdfFileLocation = "badClaim_contentTestPDF.pdf"
      testContentMatches(pdfFileLocation, ClaimBuilder.functionalTestCase9, XMLData.madeUpField, foundMustBeFalse)
    }

    "extract PDF for functionalTestCase1 and match contents" in {
      val pdfFileLocation = "functionalTestCase1_contentTestPDF.pdf"
      testContentMatches(pdfFileLocation, ClaimBuilder.functionalTestCase1, XMLData.functionalTestCase1, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase2 and match contents" in {
      val pdfFileLocation = "functionalTestCase2_contentTestPDF.pdf"
      testContentMatches(pdfFileLocation, ClaimBuilder.functionalTestCase2, XMLData.functionalTestCase2, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase3 and match contents" in {
      val pdfFileLocation = "functionalTestCase3_contentTestPDF.pdf"
      testContentMatches(pdfFileLocation, ClaimBuilder.functionalTestCase3, XMLData.functionalTestCase3, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase4 and match contents" in {
      val pdfFileLocation = "functionalTestCase4_contentTestPDF.pdf"
      testContentMatches(pdfFileLocation, ClaimBuilder.functionalTestCase4, XMLData.functionalTestCase4, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase5 and match contents" in {
      val pdfFileLocation = "functionalTestCase5_contentTestPDF.pdf"
      testContentMatches(pdfFileLocation, ClaimBuilder.functionalTestCase5, XMLData.functionalTestCase5, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase6 and match contents" in {
      val pdfFileLocation = "functionalTestCase6_contentTestPDF.pdf"
      testContentMatches(pdfFileLocation, ClaimBuilder.functionalTestCase6, XMLData.functionalTestCase6, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase7 and match contents" in {
      val pdfFileLocation = "functionalTestCase7_contentTestPDF.pdf"
      testContentMatches(pdfFileLocation, ClaimBuilder.functionalTestCase7, XMLData.functionalTestCase7, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase8 and match contents" in {
      val pdfFileLocation = "functionalTestCase8_contentTestPDF.pdf"
      testContentMatches(pdfFileLocation, ClaimBuilder.functionalTestCase8, XMLData.functionalTestCase8, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase9 and match contents" in {
      val pdfFileLocation = "functionalTestCase9_contentTestPDF.pdf"
      testContentMatches(pdfFileLocation, ClaimBuilder.functionalTestCase9, XMLData.functionalTestCase9, foundMustBeTrue)
    }
  }
}

