package generators

import java.io.File

import app.ConfigProperties._
import data_sources.InvalidSourceFormatException
import net.sf.jasperreports.engine.util.{JRElementsVisitor, JRSaver}
import net.sf.jasperreports.engine.{JRSubreport, JasperCompileManager, JasperReport}
import net.sf.jasperreports.engine.design.JasperDesign
import net.sf.jasperreports.engine.xml.JRXmlLoader
import play.api.Logger

/**
 * Compile the Jasper XML Templates (JRXML). The JRXML files are under <jrxml.folder>/<version> folders.
 * They are compiled to jasper files under <jasper.folder>/<version> folders.
 */
object JasperReportCompiler {

  /**
   * Compile all JRXML templates under jrxml.folder sub-folders.
   * Called by applicaiton at start-up.
   */
  def compileAllReports() = {
    try {
      Logger.info(s"jrxmlLocation = $jrxmlLocation - jasperLocation = $jasperLocation")
      val allFiles = new File(jrxmlLocation)
      if (allFiles != null && allFiles.listFiles != null) {
        allFiles.listFiles.filter(_.isDirectory).foreach { folder =>
            compileReportsInFolder(folder.getName)
        }
      }
    } catch {
      case e: InvalidSourceFormatException =>
        Logger.error(e.getMessage, e)
        throw e
      case e: Throwable =>
        Logger.error(e.getMessage, e)
        throw e
    }
  }

  /**
   * Compile a specific JRXML template and its sub-reports.
   * @param reportName JRXML report to compile.
   * @param version The version we want to compile, which defines its location under jrxml.foler.
   */
  def compileReport(reportName: String, version: Option[String]) {
    val realJasperLocation = fullJasperLocation(version)
    val jasperFilename = s"$realJasperLocation$reportName.jasper"
    if (!new File(jasperFilename).exists()) {
      Logger.info(s"No jasper file. Compiling from JRXML for $jasperFilename.")
      compileReportsRecursively(reportName, version)
      Logger.info(s"Completed compilation of JRXML files for $jasperFilename.")
    }
  }

  def fullJasperLocation(version: Option[String]) = s"$jasperLocation${
    version match {
      case Some(x) => s"$x/";
      case _ => ""
    }
  }"

  def fullJrxmlLocation(version: Option[String]) = s"$jrxmlLocation${
    version match {
      case Some(x) => s"$x/";
      case _ => ""
    }
  }"

  private def compileReportsInFolder(parentFolder: String): Unit = {
    Logger.info(s"Compiling JRXML reports in $parentFolder")
    val allFiles = new File(jrxmlLocation+parentFolder)
    if (allFiles != null && allFiles.listFiles != null)
      compileReports(allFiles.listFiles.filter(_.getName.endsWith(".jrxml")), Some(parentFolder))
  }

  private def compileReports(files: Array[File], path: Option[String]): Unit = {
    if (files != null) {
      Logger.info(s"Found ${files.size} Jasper templates")
      for ((file, index) <- files.zipWithIndex) {
        // process the file
        val reportNameArr = file.getName.split( """\.""")
        if (reportNameArr.size > 0) {
          Logger.info(s"[$index/${files.size}] Jasper template ${reportNameArr(0)}")
          JasperReportCompiler.compileReport(reportNameArr(0), path)
        }
        else Logger.error("Error reading from jrxml directory")
      }
    }

  }

  private def compileReportsRecursively(fileName: String, version: Option[String]): JasperReport = {
    val realJasperLocation = fullJasperLocation(version)
    val realJrxmlLocation = fullJrxmlLocation(version)
    val jasperFilename = s"$realJasperLocation$fileName.jasper"
    Logger.debug(s"jasperFileName is $jasperFilename")

    Logger.info(s"Loading jrxml for compilation: $realJrxmlLocation$fileName.jrxml")
    val jasperDesign: JasperDesign = JRXmlLoader.load(s"$realJrxmlLocation$fileName.jrxml")
    val jasperReport = JasperCompileManager.compileReport(jasperDesign)
    Logger.debug(s"Report $jasperFilename compiled")

    // If jasper folder does not exist then it creates it. So it can save compiles templates
    if (!new File(realJasperLocation).exists()) {
      new File(realJasperLocation).mkdir()
    }
    JRSaver.saveObject(jasperReport, jasperFilename)
    Logger.debug(s"Report $jasperFilename saved")

    //Compile sub reports
    JRElementsVisitor.visitReport(jasperReport, new ReportCompilerVisitor() {
      override def visitSubreport(subreport: JRSubreport): Unit = {
        val expression = subreport.getExpression.getText
        // expression looks like: $P{SUBREPORT_DIR} + "reportNewClaim_Summary.jasper"
        val subReportName = expression.substring(expression.indexOf('"') + 1, expression.length - 8)
        // Need to prepend jasperLocation to check existence of compiled template (to support version folders)
        if (!new File(realJasperLocation+subReportName).exists()) {
          Logger.info(s"No jasper file. Compiling subreport from JRXML for $subReportName.")
          compileReportsRecursively(subReportName, version)
        }
      }
    })
    Logger.debug(s"Successfully compiled and saved jasper report. $jasperFilename")
    jasperReport
  }

  private def jasperLocation = getProperty("jasper.folder", "./")

  private def jrxmlLocation = getProperty("jrxml.folder", "/conf")

}
