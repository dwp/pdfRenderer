package controllers

import java.io.{ByteArrayOutputStream, FileOutputStream, OutputStream}
import java.text.SimpleDateFormat
import java.util.Date

import app.ConfigProperties._
import generators.{HtmlGenerator, PdfGenerator, ReportGenerator}
import play.api.Logger
import play.api.mvc._
import service.RenderService
import scala.language.higherKinds


object Application extends Controller {

  def generatePDF = Action { request =>
    val service = new RenderService{
      lazy val pdfLocation = getProperty("pdf.folder","./")
      protected def reportGenerator: ReportGenerator = PdfGenerator
      protected def content: Right[String,Array[Byte]] = Right(outputStream.asInstanceOf[ByteArrayOutputStream].toByteArray)
      protected val outputStream: OutputStream = new ByteArrayOutputStream()//(s"${pdfLocation}PDFGenerated_${new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())}.pdf")
    }
    service.outputGeneration(request)
  }

  def generateHTML = Action {request =>
    Logger.info("Serving generateHtml")
    val service = new RenderService{
      protected def reportGenerator: ReportGenerator = HtmlGenerator
      override protected val outputStream = new ByteArrayOutputStream()
      protected def content: Left[String,Array[Byte]] = Left(outputStream.toString("UTF-8"))
    }
    service.outputGeneration(request)
  }

}