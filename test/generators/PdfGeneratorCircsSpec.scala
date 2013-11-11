package generators

import org.specs2.mutable._
import test_data.CircsBuilder
import java.io.File
import scala.xml.Elem
import generators.Helper._


/**
 * Test PdfGenerator with the implicits defined in package object data_sources.
 * @author Jorge Migueis
 */
class PdfGeneratorCircsSpec extends Specification {

  "PdfGeneratorCircsSpec" should {
    def deleteAndGeneratePDF(pdfFileLocation: String, xml: Elem) = {
      deletePdfFile(pdfFileLocation)
      generatePDF(pdfFileLocation, xml)
    }

    def testGeneratorResultIsSuccess(pdfFileLocation: String, xml: Elem) = {
      val generatorResult = deleteAndGeneratePDF(pdfFileLocation, xml)
      generatorResult must beAnInstanceOf[GenerationSuccess]
    }

    def testOutputFileExists(pdfFileLocation: String, xml: Elem) = {
      deleteAndGeneratePDF(pdfFileLocation, xml)
      val pdfFile = new File(pdfFileLocation)
      pdfFile.exists() must beTrue
    }

    "be handle functionalTestCase1 and return success" in {
      pending
      val pdfFileLocation = "circs_functionalTestCase1_testGeneratorResultIsSuccess.pdf"
      testGeneratorResultIsSuccess(pdfFileLocation, CircsBuilder.functionalTestCase1)
    }//.pendingUntilFixed("Need to implement .jrxml for circs")

    "create functionalTestCase1 PDF file" in {
      pending
      val pdfFileLocation = "circs_functionalTestCase1_testOutputFileExists.pdf"
      testOutputFileExists(pdfFileLocation, CircsBuilder.functionalTestCase1)
    } //.pendingUntilFixed("Need to implement .jrxml for circs")
  }
}

