package service

import scala.util.{Success, Try}
import play.api.Play
import generators.{HtmlGenerator, ReportGenerator}
import java.io.{ByteArrayOutputStream, FileOutputStream, OutputStream}
import java.text.SimpleDateFormat
import java.util.Date

/**
 * Created by jmi on 08/04/2014.
 */
trait HtmlServiceStringImpl extends RenderService {
    lazy val htmlLocation = Try(Play.current.configuration.getString("pdf.folder").getOrElse("./")) match {case Success(s) => s; case _ => "./"}

    protected def reportGenerator: ReportGenerator = HtmlGenerator

    override protected val outputStream = new ByteArrayOutputStream()

  protected def content: String = { outputStream.toString("UTF-8")}

}
