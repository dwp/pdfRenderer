package generators

import org.specs2.mutable._
import data_sources.XmlDataSource
import test_data.ClaimBuilder
import java.io.File
import scala.xml.Elem


/**
 * Test PdfGenerator with the implicits defined in package object data_sources.
 * @author Jorge Migueis
 */
class PdfGeneratorCommonSpec extends Specification {

  "PdfGeneratorCommonSpec" should {

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

    "be reject xml that does not contain DWPCAClaim or DWPCACircs" in {
      val pdfFileLocation = "goodClaimReject.pdf"
      before(pdfFileLocation)
      val xml = ClaimBuilder.badClaim
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource, pdfFileLocation)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationFailure]
    }

    "be handle valid xml and return success" in {
      val pdfFileLocation = "goodClaimSuccess.pdf"
      before(pdfFileLocation)
      val xml = ClaimBuilder.goodClaim
      val dataSource = new XmlDataSource(xml)
      val generator = PdfGenerator(dataSource, pdfFileLocation)
      val generatorResult = generator.generateFrom()
      generatorResult must beAnInstanceOf[GenerationSuccess]
    }

    "create a PDF file" in {
      val pdfFileLocation = "goodClaimCreate.pdf"
      before(pdfFileLocation)
      val xml = ClaimBuilder.goodClaim
      val dataSource = new XmlDataSource(xml)
      PdfGenerator(dataSource, pdfFileLocation).generateFrom()
      val pdfFile = new File(pdfFileLocation)
      pdfFile.exists() must beTrue
    }
  }
}

