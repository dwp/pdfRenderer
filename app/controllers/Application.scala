package controllers

import play.api.mvc._
import service.RenderService
import scala.util.{Success, Try}
import play.api.Play
import generators.{HtmlGenerator, PdfGenerator, ReportGenerator}
import java.io.{ByteArrayOutputStream, FileOutputStream, OutputStream}
import java.text.SimpleDateFormat
import java.util.Date


object Application extends Controller {

  def generatePDF = Action { request =>
    val service = new RenderService {
      lazy val pdfLocation = Try(Play.current.configuration.getString("pdf.folder").getOrElse("./")) match {case Success(s) => s; case _ => "./"}
      protected def reportGenerator: ReportGenerator = PdfGenerator
      protected def content: String = ""
      protected val outputStream: OutputStream = new FileOutputStream(s"${pdfLocation}PDFGenerated_${new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())}.pdf")
    }
    service.outputGeneration(request)
  }

  def generateHTML = Action {request =>
    val service = new RenderService {
      protected def reportGenerator: ReportGenerator = HtmlGenerator
      override protected val outputStream = new ByteArrayOutputStream()
      protected def content: String = { outputStream.toString("UTF-8")}
    }
    service.outputGeneration(request)
  }

}