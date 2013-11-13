package generators

import org.specs2.mutable._
import data_sources.XmlDataSource
import test_data.ClaimBuilder
import java.io.File
import java.io.{FileOutputStream, File}

import generators.Helper._
import net.sf.jasperreports.engine.JasperPrint


/**
 * Test PdfGenerator with the implicits defined in package object data_sources.
 * @author Jorge Migueis
 */
class PdfGeneratorCommonSpec extends Specification {
  "PdfGeneratorCommonSpec" should {

    "be reject xml that does not contain DWPCAClaim or DWPCACircs" in {
      val pdfFileLocation = "goodClaimReject.pdf"
      val xml = ClaimBuilder.badClaim
      val dataSource = new XmlDataSource(xml)
      val jasperPrint = PdfGenerator.generateFrom(dataSource)
      PdfGenerator.exportReportToStream(jasperPrint, new FileOutputStream(pdfFileLocation))

    }

    "be handle valid xml and return success" in {
      val pdfFileLocation = "goodClaimSuccess.pdf"
      val xml = ClaimBuilder.goodClaim
      val dataSource = new XmlDataSource(xml)
      val generatorResult = PdfGenerator.generateFrom(dataSource)
      generatorResult must beAnInstanceOf[GenerationSuccess]
      deletePdfFile(pdfFileLocation)
    }

    "create a PDF file" in {
      val pdfFileLocation = "goodClaimCreate.pdf"
      val xml = ClaimBuilder.goodClaim
      val dataSource = new XmlDataSource(xml)
      val print = PdfGenerator.generateFrom(dataSource)
      PdfGenerator.exportReportToStream(print, new FileOutputStream(pdfFileLocation))
      val pdfFile = new File(pdfFileLocation)
      pdfFile.exists() must beTrue
      deletePdfFile(pdfFileLocation)
    }

    "write files in parallel" in {
      val max = 10

      (1 to max).toArray.par.forall(x => {
        val pdfFileLocation = "parallelTestFile" + x + ".pdf"
        val xml = ClaimBuilder.functionalTestCase9
        val dataSource = new XmlDataSource(xml)
        PdfGenerator.generateFrom(dataSource)
        val pdfFile = new File(pdfFileLocation)
        pdfFile.exists()
      }) must beTrue

      (1 to max).foreach(x => {
        val pdfFileLocation = "parallelTestFile" + x + ".pdf"
        deletePdfFile(pdfFileLocation)
      })
    }
  }
}

