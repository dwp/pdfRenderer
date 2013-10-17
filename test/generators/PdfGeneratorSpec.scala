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
class PdfGeneratorSpec extends Specification {

  "PdfGenerator" should {

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

    def testGeneratorResultIsSuccess(pdfFileLocation: String, xml: Elem) = {
      val generator = getPdfGenerator(pdfFileLocation, xml)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationSuccess]
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


      val content: Seq[String] = for (i <- 1 to reader.getNumberOfPages()) yield {
        val strategy = parser.processContent(i, new SimpleTextExtractionStrategy())

        strategy.getResultantText()
      }
      reader.close()

      val totalContent = content.mkString("\n").toLowerCase
      totalContent
    }

    "PdfGenerator should be reject xml that does not contain DWPCAClaim or DWPCACircs" in {
      val pdfFileLocation = "/Users/valtechuk/goodClaim.pdf"
      before(pdfFileLocation)
      val xml = ClaimBuilder.buildBadClaim
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource, pdfFileLocation)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationFailure]
    }

    "PdfGenerator should be handle valid xml and return success" in {
      val pdfFileLocation = "/Users/valtechuk/goodClaim.pdf"
      before(pdfFileLocation)
      val xml = ClaimBuilder.buildGoodClaim
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource, pdfFileLocation)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationSuccess]
    }


    "PdfGenerator should create a PDF file" in {
      val pdfFileLocation = "/Users/valtechuk/badClaim.pdf"
      before(pdfFileLocation)
      val xml = ClaimBuilder.buildGoodClaim
      val dataSource = new XmlDataSource(xml)
      PdfGenerator(dataSource, pdfFileLocation).generateFrom()
      val pdfFile = new File(pdfFileLocation)
      pdfFile.exists() must beTrue
    }

    "PdfGenerator should be handle functionalTestCase1 and return success" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase1_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase1)
    }

    "PdfGenerator should create functionalTestCase1 PDF file" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase1_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase1)
    }

    "PdfGenerator should be handle functionalTestCase2 and return success" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase2_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase2)
    }

    "PdfGenerator should create functionalTestCase2 PDF file" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase2_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase2)
    }

    "PdfGenerator should be handle functionalTestCase3 and return success" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase3_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase3)
    }

    "PdfGenerator should create functionalTestCase3 PDF file" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase3_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase3)
    }

    "PdfGenerator should be handle functionalTestCase4 and return success" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase4_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase4)
    }

    "PdfGenerator should create functionalTestCase4 PDF file" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase4_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase4)
    }

    "PdfGenerator should be handle functionalTestCase5 and return success" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase5_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase5)
    }

    "PdfGenerator should create functionalTestCase5 PDF file" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase5_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase5)
    }

    "PdfGenerator should be handle functionalTestCase6 and return success" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase6_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase6)
    }

    "PdfGenerator should create functionalTestCase6 PDF file" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase6_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase6)
    }

    "PdfGenerator should be handle functionalTestCase7 and return success" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase7_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase7)
    }

    "PdfGenerator should create functionalTestCase7 PDF file" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase7_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase7)
    }

    "PdfGenerator should be handle functionalTestCase8 and return success" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase8_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase8)
    }

    "PdfGenerator should create functionalTestCase8 PDF file" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase8_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase8)
    }

    "PdfGenerator should be handle functionalTestCase9 and return success" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase9_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase9)
    }

    "PdfGenerator should create functionalTestCase9 PDF file" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase9_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase9)
    }

    "Extract PDF for functionalTestCase9" in {
      val pdfFileLocation = "/Users/valtechuk/functionalTestCase9_contentTestPDF.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase9)

      val totalContent = getPDFContent(pdfFileLocation)
      val xmlData = XMLData.functionalTestCase9(ClaimBuilder.functionalTestCase9)

      println("TotalContent " + totalContent)

      xmlData.forall(x => {
        val found = totalContent.contains(x.toLowerCase)
        if (!found) {
          println("Cannot find: " + x.toLowerCase)
        }
        found must beTrue
      })
    }
  }
}

