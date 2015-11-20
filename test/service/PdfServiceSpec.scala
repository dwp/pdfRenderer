package service

import org.specs2.mutable.Specification
import play.api.test.FakeRequest
import play.api.test.Helpers._
import test_data.ClaimBuilder
import java.io.{FileOutputStream, ByteArrayOutputStream, OutputStream}
import utils.WithApplication

import scala.concurrent.{ExecutionContext, Future}
import ExecutionContext.Implicits.global
import scala.util.{Success, Try}
import play.api.Play
import generators.{PdfGenerator, ReportGenerator}
import java.text.SimpleDateFormat
import java.util.Date

/**
 * Test RESTful interface
 * @author Jorge Migueis
 */
class PdfServiceSpec extends Specification {

  "PDF Service" should {

    "accept XML and return BAD_REQUEST error if unknown XML type"  in new WithApplication {
      val service = new RenderService {
        lazy val pdfLocation = Try(Play.current.configuration.getString("pdf.folder").getOrElse("./")) match {case Success(s) => s; case _ => "./"}
        protected def reportGenerator: ReportGenerator = PdfGenerator
        protected def content = Left("")
        protected val outputStream: OutputStream = new ByteArrayOutputStream()//new FileOutputStream(s"${pdfLocation}PDFGenerated_${new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())}.pdf")
      }
      val requestXml = <Invalid>type</Invalid>
      val response = Future(service.outputGeneration(FakeRequest().withXmlBody(requestXml)))
      status(response)  mustEqual BAD_REQUEST
    }
    
    "not accept non XML request" in new WithApplication {
      val service = new RenderService {
        lazy val pdfLocation = Try(Play.current.configuration.getString("pdf.folder").getOrElse("./")) match {case Success(s) => s; case _ => "./"}
        protected def reportGenerator: ReportGenerator = PdfGenerator
        protected def content = Left("")
        protected val outputStream: OutputStream =  new ByteArrayOutputStream() //new FileOutputStream(s"${pdfLocation}PDFGenerated_${new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())}.pdf")
      }
      val invalidRequest = "Hello"
      val response = Future(service.outputGeneration(FakeRequest().withTextBody(invalidRequest)))
      status(response)  mustEqual UNSUPPORTED_MEDIA_TYPE
    }

    "return Internal error code if could not generate PDF" in new WithApplication {
      val service = new RenderService {
        protected def reportGenerator: ReportGenerator = PdfGenerator
        protected def content = Left("")
        protected val outputStream: OutputStream = null
      }
      val validRequest = ClaimBuilder.goodClaim
      val response = Future(service.outputGeneration(FakeRequest().withXmlBody(validRequest)))
      status(response)  mustEqual INTERNAL_SERVER_ERROR
    }

    "accept valid XML and generate a pdf" in new WithApplication {
      val output = new ByteArrayOutputStream()
      val service =new RenderService {
        lazy val pdfLocation = Try(Play.current.configuration.getString("pdf.folder").getOrElse("./")) match {case Success(s) => s; case _ => "./"}
        protected def reportGenerator: ReportGenerator = PdfGenerator
        protected def content = Left("")
        protected val outputStream: OutputStream = output
      }
      val validRequest = ClaimBuilder.goodClaim
      val response = Future(service.outputGeneration(FakeRequest().withXmlBody(validRequest)))
      status(response)  mustEqual OK
      output.size must be_>(0)
    }

  }
  section("unit")

}
