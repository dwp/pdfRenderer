package generators

import scala.util.{Success, Try}
import data_sources.{InvalidSourceFormatException, ReportDataSource}
import net.sf.jasperreports.engine._
import net.sf.jasperreports.engine.xml.JRXmlLoader
import play.api.{Play, Logger}
import net.sf.jasperreports.engine.design.JasperDesign
import net.sf.jasperreports.engine.util.{JRElementsVisitor, JRSaver}
import java.io.{File, OutputStream}
import java.util
import scala.language.postfixOps


/**
 * Interface of the report generators.
 */
trait ReportGenerator {
  lazy val jasperLocation = Try(Play.current.configuration.getString("jasper.folder").getOrElse("./")) match {case Success(s) => s; case _ => "./"}
  lazy val jrxmlLocation = Try(Play.current.configuration.getString("jrxml.folder").getOrElse("/conf")) match {case Success(s) => s; case _ => "/conf"}
  lazy val yesImage = Play.current.configuration.getString("images.yes").getOrElse("./")
  lazy val noImage = Play.current.configuration.getString("images.no").getOrElse("./")

  def compileAllReports() = {
    try {
      Logger.info(s"jrxmlLocation = $jrxmlLocation")
      Logger.info(s"jasperLocation = $jasperLocation")

      val allFiles = new File(jrxmlLocation)

      if(allFiles!= null) {
        if(allFiles.listFiles != null && allFiles.listFiles.size > 0) {
          val files = allFiles.listFiles.filter(_.getName.endsWith(".jrxml"))
          if(files!=null) {
            Logger.info(s"Getting jrxml files from $jrxmlLocation. Files size is "+files.size)
            for(file <- files){
              // process the file
              val reportNameArr = file.getName.split("""\.""")
              if(reportNameArr.size>0) compileReport(reportNameArr(0))
              else Logger.error("Error reading from jrxml directory")
            }
          }
        }
      }
    } catch {
      case e: InvalidSourceFormatException =>
        Logger.error(e.getMessage,e)
        throw e
      case e: Throwable =>
        Logger.error(e.getMessage,e)
        throw e
    }
  }

  def generateFrom(source: ReportDataSource): Option[JasperPrint] = {
    try {
      val reportName = source.jasperReportFilenameMatcher()
      val jasperFilename = s"$jasperLocation$reportName.jasper"

      // If we do not have the compiled report templates, then we need to compile them
      // before we can generate a report.
      compileReport(reportName)
      val parameter:util.Map[String,Object] = new util.HashMap[String,Object]()

      parameter.put("SUBREPORT_DIR",jasperLocation)

      val jasperPrint = JasperFillManager.fillReport(jasperFilename, parameter, source.convertToJRDataSource())
      if (null != jasperPrint) Some(jasperPrint) else None
    }
    catch {
      case e: InvalidSourceFormatException =>
        Logger.error(e.getMessage,e)
        throw e
      case e: Throwable =>
        Logger.error(e.getMessage,e)
        throw e
    }
  }

  def compileReport(reportName: String) {
    val jasperFilename = s"$jasperLocation$reportName.jasper"
    if (!new File(jasperFilename).exists()) {
      Logger.info(s"No jasper file. Compiling from JRXML for $jasperFilename.")
      compileReportsRecursively(reportName)
      Logger.info(s"Completed compilation of JRXML files for $jasperFilename.")
    }
  }

  private def compileReportsRecursively(fileName: String): JasperReport = {
    val jasperFilename = s"$jasperLocation$fileName.jasper"
    Logger.debug(s"jasperFileName is $jasperFilename")

    val jasperDesign: JasperDesign = JRXmlLoader.load(getClass getResourceAsStream s"/$fileName.jrxml")
    Logger.debug(s"jasperDesign loaded: $jasperDesign")

    val jasperReport = JasperCompileManager.compileReport(jasperDesign)
    Logger.debug("Report compiled")

    JRSaver.saveObject(jasperReport, jasperFilename)
    Logger.debug("Report saved")
    //Compile sub reports
    JRElementsVisitor.visitReport(jasperReport, new ReportCompiler() {
      override def visitSubreport(subreport: JRSubreport): Unit = {
        val expression = subreport.getExpression.getText
        // expression looks like: $P{SUBREPORT_DIR} + "reportNewClaim_Summary.jasper"
        val subReportName = expression.substring(expression.indexOf('"') + 1, expression.length - 8)
        compileReportsRecursively(subReportName)
      }
    })
    Logger.debug("Successfully compiled and saved jasper report ")
    jasperReport
  }

  def exportReportToStream(print: Option[JasperPrint], stream: OutputStream): SuccessOrFailure = {GenerationSuccess()}
}