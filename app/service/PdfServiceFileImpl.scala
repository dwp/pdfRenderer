package service

import generators.{PdfGenerator, ReportGenerator}
import java.io.{FileOutputStream, OutputStream}
import java.util.Date
import java.text.SimpleDateFormat
import scala.util.{Success, Try}
import play.api.Play

/**
 * This is the class that generates the PDF to a file. 
 * The file generated is stored under 'pdf.folder' and named 'PDFGenerated_timestamp.pdf'.
 *@author Jorge Migueis
 */
trait PdfServiceFileImpl extends PdfService {

  lazy val pdfLocation = Try(Play.current.configuration.getString("pdf.folder").getOrElse("./")) match {case Success(s) => s; case _ => "./"}

  protected def reportGenerator: ReportGenerator = PdfGenerator

  protected def outputStream: OutputStream = {
    new FileOutputStream(s"${pdfLocation}PDFGenerated_${new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())}.pdf")
  }
}
