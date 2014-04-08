package service

import org.specs2.mutable.{Tags, Specification}
import scala.concurrent.{ExecutionContext, Future}
import play.api.test.FakeRequest
import play.api.test.Helpers._
import java.io.{ByteArrayOutputStream, OutputStream}
import test_data.ClaimBuilder
import ExecutionContext.Implicits.global


/**
 * Created by jmi on 07/04/2014.
 */
class HtmlServiceSpec  extends Specification with Tags {

  "HMTL Service" should {

    "accept XML and return BAD_REQUEST error if unknown XML type"  in {
      val service = new HtmlServiceFileImpl {}
      val requestXml = <Invalid>type</Invalid>
      val response = Future(service.outputGeneration(FakeRequest().withXmlBody(requestXml)))
      status(response)  mustEqual BAD_REQUEST
    }

    "not accept non XML request" in {
      val service = new HtmlServiceFileImpl {}
      val invalidRequest = "Hello"
      val response = Future(service.outputGeneration(FakeRequest().withTextBody(invalidRequest)))
      status(response)  mustEqual UNSUPPORTED_MEDIA_TYPE
    }

    "return Internal error code if could not generate HTML" in {
      val service = new HtmlServiceFileImpl {
        override protected val outputStream: OutputStream = null
      }
      val validRequest = ClaimBuilder.goodClaim
      val response = Future(service.outputGeneration(FakeRequest().withXmlBody(validRequest)))
      status(response)  mustEqual INTERNAL_SERVER_ERROR
    }

    "accept valid XML and generate a html" in {
      val output = new ByteArrayOutputStream()
      val service = new HtmlServiceFileImpl {
        override protected val outputStream: OutputStream = output
      }
      val validRequest = ClaimBuilder.goodClaim
      val response = Future(service.outputGeneration(FakeRequest().withXmlBody(validRequest)))
      status(response)  mustEqual OK
      output.size must be_>(0)
    }

    "accept valid XML and generate a string html" in {
      val service = new HtmlServiceStringImpl {}
      val validRequest = ClaimBuilder.goodClaim
      val response = Future(service.outputGeneration(FakeRequest().withXmlBody(validRequest)))
      contentAsString(response) must contain("html")
      status(response)  mustEqual OK
    }

  } section "unit"

}
