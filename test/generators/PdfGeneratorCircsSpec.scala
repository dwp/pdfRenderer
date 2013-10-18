package generators

import org.specs2.mutable._
import data_sources.XmlDataSource
import test_data.CircsBuilder
import java.io.File
import scala.xml.Elem


/**
 * Test PdfGenerator with the implicits defined in package object data_sources.
 * @author Jorge Migueis
 */
class PdfGeneratorCircsSpec extends Specification {

  "PdfGeneratorCircsSpec" should {

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

    "be handle functionalTestCase1 and return success" in {
      val pdfFileLocation = "circs_functionalTestCase1_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, CircsBuilder.functionalTestCase1)
    }.pendingUntilFixed("Need to implement .jrxml for circs")

    "create functionalTestCase1 PDF file" in {
      val pdfFileLocation = "circs_functionalTestCase1_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, CircsBuilder.functionalTestCase1)
    }.pendingUntilFixed("Need to implement .jrxml for circs")
  }
}

