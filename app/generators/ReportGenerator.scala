package generators

import java.io.OutputStream
import java.util

import app.ConfigProperties._
import data_sources.{InvalidSourceFormatException, ReportDataSource}
import net.sf.jasperreports.engine._
import play.api.Logger

import scala.language.postfixOps


/**
 * Interface of the report generators.
 * It support multiple versions of the reports (templates).
 */
trait ReportGenerator {
  lazy val yesImage = getProperty("images.yes", "./")
  lazy val noImage = getProperty("images.no", "./")

  def generateFrom(source: ReportDataSource, version: Option[String]): Option[JasperPrint] = {
    try {
      val realJasperLocation = JasperReportCompiler.fullJasperLocation(version)
      val reportName = source.jasperReportFilenameMatcher()
      val jasperFilename = s"$realJasperLocation$reportName.jasper"

      // If we do not have the compiled report templates, then we need to compile them
      // before we can generate a report. They are normally compiled at start-up. It is just in case.
      JasperReportCompiler.compileReport(reportName, version)
      val parameter: util.Map[String, Object] = new util.HashMap[String, Object]()
      parameter.put("SUBREPORT_DIR", realJasperLocation)
      parameter.put("TEMPLATE_DIR", JasperReportCompiler.fullJrxmlLocation(version))
      val jasperPrint = JasperFillManager.fillReport(jasperFilename, parameter, source.convertToJRDataSource())
      if (null != jasperPrint) Some(jasperPrint) else None
    }
    catch {
      case e: InvalidSourceFormatException =>
        Logger.error(e.getMessage, e)
        throw e
      case e: Throwable =>
        Logger.error(e.getMessage, e)
        throw e
    }
  }

  def exportReportToStream(print: Option[JasperPrint], stream: OutputStream): SuccessOrFailure = {
    GenerationSuccess()
  }
}