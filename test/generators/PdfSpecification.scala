package generators

import scala.xml.Elem
import generators.Helper._
import java.io.File
import org.specs2.mutable.Specification

/**
 * Some helpers functions.
 * @author Jorge Migueis
 */
trait PdfSpecification extends Specification {
  def deleteAndGeneratePDF(pdfFileLocation: String, xml: Elem) = {
    deleteFile(pdfFileLocation)
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

}
