package service

import scala.util.{Success, Try}
import play.api.Play
import generators.{HtmlGenerator, ReportGenerator}
import java.io.{FileOutputStream, OutputStream}
import java.text.SimpleDateFormat
import java.util.Date

/**
 * Created by jmi on 07/04/2014.
 */
trait HtmlServiceFileImpl extends RenderService {
  lazy val htmlLocation = Try(Play.current.configuration.getString("pdf.folder").getOrElse("./")) match {case Success(s) => s; case _ => "./"}

  protected def reportGenerator: ReportGenerator = HtmlGenerator

  protected val outputStream: OutputStream =
    new FileOutputStream(s"${htmlLocation}HTMLGenerated_${new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())}.html")


  protected def content: String = ""
}
