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

        val result = strategy.getResultantText()
        println()
        println(result )
        result
      }
      reader.close()

      val totalContent = content.mkString("\n").toLowerCase
      totalContent
    }

    "be reject xml that does not contain DWPCAClaim or DWPCACircs" in {
      val pdfFileLocation = "goodClaimReject.pdf"
      before(pdfFileLocation)
      val xml = ClaimBuilder.buildBadClaim
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource, pdfFileLocation)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationFailure]
    }

    "be handle valid xml and return success" in {
      val pdfFileLocation = "goodClaimSuccess.pdf"
      before(pdfFileLocation)
      val xml = ClaimBuilder.buildGoodClaim
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource, pdfFileLocation)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationSuccess]
    }


    "create a PDF file" in {
      val pdfFileLocation = "goodClaimCreate.pdf"
      before(pdfFileLocation)
      val xml = ClaimBuilder.buildGoodClaim
      val dataSource = new XmlDataSource(xml)
      PdfGenerator(dataSource, pdfFileLocation).generateFrom()
      val pdfFile = new File(pdfFileLocation)
      pdfFile.exists() must beTrue
    }

    "be handle functionalTestCase1 and return success" in {
      val pdfFileLocation = "functionalTestCase1_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase1)
    }

    "create functionalTestCase1 PDF file" in {
      val pdfFileLocation = "functionalTestCase1_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase1)
    }

    "be handle functionalTestCase2 and return success" in {
      val pdfFileLocation = "functionalTestCase2_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase2)
    }

    "create functionalTestCase2 PDF file" in {
      val pdfFileLocation = "functionalTestCase2_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase2)
    }

    "be handle functionalTestCase3 and return success" in {
      val pdfFileLocation = "functionalTestCase3_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase3)
    }

    "create functionalTestCase3 PDF file" in {
      val pdfFileLocation = "functionalTestCase3_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase3)
    }

    "be handle functionalTestCase4 and return success" in {
      val pdfFileLocation = "functionalTestCase4_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase4)
    }

    "create functionalTestCase4 PDF file" in {
      val pdfFileLocation = "functionalTestCase4_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase4)
    }

    "be handle functionalTestCase5 and return success" in {
      val pdfFileLocation = "functionalTestCase5_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase5)
    }

    "create functionalTestCase5 PDF file" in {
      val pdfFileLocation = "functionalTestCase5_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase5)
    }

    "be handle functionalTestCase6 and return success" in {
      val pdfFileLocation = "functionalTestCase6_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase6)
    }

    "create functionalTestCase6 PDF file" in {
      val pdfFileLocation = "functionalTestCase6_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase6)
    }

    "be handle functionalTestCase7 and return success" in {
      val pdfFileLocation = "functionalTestCase7_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase7)
    }

    "create functionalTestCase7 PDF file" in {
      val pdfFileLocation = "functionalTestCase7_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase7)
    }

    "be handle functionalTestCase8 and return success" in {
      val pdfFileLocation = "functionalTestCase8_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase8)
    }

    "create functionalTestCase8 PDF file" in {
      val pdfFileLocation = "functionalTestCase8_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase8)
    }

    "be handle functionalTestCase9 and return success" in {
      val pdfFileLocation = "functionalTestCase9_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, ClaimBuilder.functionalTestCase9)
    }

    "create functionalTestCase9 PDF file" in {
      val pdfFileLocation = "functionalTestCase9_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, ClaimBuilder.functionalTestCase9)
    }
  }
}

