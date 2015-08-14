package controllers

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, FileOutputStream, OutputStream}
import java.text.SimpleDateFormat
import java.util.Date

import app.ConfigProperties._
import generators.{HtmlGenerator, PdfGenerator, ReportGenerator}
import org.apache.commons.io.IOUtils
import play.api.{Play, Logger}
import play.api.mvc._
import service.RenderService
import scala.language.higherKinds


object Application extends Controller {

  def generatePDF = Action { request =>
    val output = new ByteArrayOutputStream()
    val service = new RenderService {
      protected def reportGenerator: ReportGenerator = PdfGenerator

      protected def content: Right[String, Array[Byte]] = Right(outputStream.asInstanceOf[ByteArrayOutputStream].toByteArray)

      protected val outputStream: OutputStream = output
    }

    //save both to file and to response
    val result = service.outputGeneration(request)


    if (Play.isTest(Play.current)) {
      //todo - refactor this
      result match {
        case Result(ResponseHeader(200, _), _, _) =>
          IOUtils.copy(new ByteArrayInputStream(output.toByteArray), new FileOutputStream(s"${getProperty("pdf.folder", "./")}PDFGenerated_${new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())}.pdf"))
        case _ => //do nothing
      }
    }

    result
  }

  def generateHTML = Action { request =>
    Logger.info("Serving generateHtml")
    val service = new RenderService {
      protected def reportGenerator: ReportGenerator = HtmlGenerator

      override protected val outputStream = new ByteArrayOutputStream()

      protected def content: Left[String, Array[Byte]] = Left(outputStream.toString("UTF-8"))
    }
    service.outputGeneration(request)
  }

}