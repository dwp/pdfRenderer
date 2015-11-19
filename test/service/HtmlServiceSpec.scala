package service

import org.specs2.mutable.Specification
import scala.concurrent.{ExecutionContext, Future}
import play.api.test.FakeRequest
import play.api.test.Helpers._
import java.io.ByteArrayOutputStream
import test_data.ClaimBuilder
import ExecutionContext.Implicits.global
import generators.{HtmlGenerator, ReportGenerator}


/**
 * Created by jmi on 07/04/2014.
 */
class HtmlServiceSpec  extends Specification {

  "HMTL Service" should {

    "accept XML and return BAD_REQUEST error if unknown XML type"  in {
      val service = new RenderService {
        protected def reportGenerator: ReportGenerator = HtmlGenerator
        override protected val outputStream = new ByteArrayOutputStream()
        protected def content = Left(outputStream.toString("UTF-8"))
      }
      val requestXml = <Invalid>type</Invalid>
      val response = Future(service.outputGeneration(FakeRequest().withXmlBody(requestXml)))
      status(response)  mustEqual BAD_REQUEST
    }

    "not accept non XML request" in {
      val service = new RenderService {
        protected def reportGenerator: ReportGenerator = HtmlGenerator
        override protected val outputStream = new ByteArrayOutputStream()
        protected def content = Left(outputStream.toString("UTF-8"))
      }
      val invalidRequest = "Hello"
      val response = Future(service.outputGeneration(FakeRequest().withTextBody(invalidRequest)))
      status(response)  mustEqual UNSUPPORTED_MEDIA_TYPE
    }

    "return Internal error code if could not generate HTML" in {
      pending ("Future throwing TimeoutException : Need to review")
      val service = new RenderService {
        protected def reportGenerator: ReportGenerator = HtmlGenerator
        override protected val outputStream = null
        protected def content = Left("")
      }
      val validRequest = ClaimBuilder.goodClaim
      val response = Future(service.outputGeneration(FakeRequest().withXmlBody(validRequest)))
      status(response)  mustEqual INTERNAL_SERVER_ERROR
    }

    "accept valid XML and generate a html" in {
      pending
      val service =new RenderService {
        protected def reportGenerator: ReportGenerator = HtmlGenerator
        override protected val outputStream = new ByteArrayOutputStream()
        protected def content = Left(outputStream.toString("UTF-8"))
      }
      val validRequest = ClaimBuilder.goodClaim
      val response = Future(service.outputGeneration(FakeRequest().withXmlBody(validRequest)))
      contentAsString(response) must contain("html")
      status(response)  mustEqual OK
    }
  }
  section("unit")

}
