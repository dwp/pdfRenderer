package generators

import helpers.VersionExtractor
import org.specs2.mutable._
import data_sources.{InvalidSourceFormatException, XmlDataSource}
import test_data.ClaimBuilder
import java.io.{FileOutputStream, File}

import generators.Helper._
import play.api.test.WithApplication
import scala.xml.XML


/**
 * Test PdfGenerator with the implicits defined in package object data_sources.
 *
 */
class PdfGeneratorCommonSpec extends Specification {
  "PdfGeneratorCommonSpec" should {
    "be reject xml that does not contain DWPCAClaim or DWPCACircs" in new WithApplication{
      val pdfFileLocation = "goodClaimReject.pdf"
      val xml = ClaimBuilder.badClaim
      val generatorResult = None
      try{
        val dataSource = new XmlDataSource(xml)
        val jasperPrint = PdfGenerator.generateFrom(dataSource, VersionExtractor.extractVersionFrom(xml))
        PdfGenerator.exportReportToStream(jasperPrint, new FileOutputStream(pdfFileLocation))
      }catch {
        case ise:InvalidSourceFormatException => success
        case e:Exception => failure
      }
      generatorResult must beNone
    }

    "be handle valid xml and return success" in new WithApplication{
      val pdfFileLocation = "goodClaimSuccess.pdf"
      val xml = ClaimBuilder.goodClaim
      val dataSource = new XmlDataSource(xml)
      val print = PdfGenerator.generateFrom(dataSource, VersionExtractor.extractVersionFrom(xml))
      val generatorResult = PdfGenerator.exportReportToStream(print, new FileOutputStream(pdfFileLocation))
      generatorResult must beAnInstanceOf[GenerationSuccess]
      deleteFile(pdfFileLocation)
    }

    "create a PDF file" in new WithApplication{
      val pdfFileLocation = "goodClaimCreate.pdf"
      val xml = ClaimBuilder.goodClaim
      val dataSource = new XmlDataSource(xml)
      val print = PdfGenerator.generateFrom(dataSource, VersionExtractor.extractVersionFrom(xml))
      PdfGenerator.exportReportToStream(print, new FileOutputStream(pdfFileLocation))
      val pdfFile = new File(pdfFileLocation)
      pdfFile.exists() must beTrue
      deleteFile(pdfFileLocation)
    }


    "write files in parallel" in new WithApplication{
      val max = 10

      (1 to max).toArray.par.forall(x => {
        val pdfFileLocation = "parallelTestFile" + x + ".pdf"
        val xml =  XML.load(getClass.getResource("/c3_functional9.xml"))
        val dataSource = new XmlDataSource(xml)
        val print = PdfGenerator.generateFrom(dataSource, VersionExtractor.extractVersionFrom(xml))
        PdfGenerator.exportReportToStream(print, new FileOutputStream(pdfFileLocation))
        val pdfFile = new File(pdfFileLocation)
        pdfFile.exists()
      }) must beTrue

      (1 to max).foreach(x => {
        val pdfFileLocation = "parallelTestFile" + x + ".pdf"
        deleteFile(pdfFileLocation)
      })
    }
  }
}

