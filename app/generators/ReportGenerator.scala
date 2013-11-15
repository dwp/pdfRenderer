package generators

import data_sources.{InvalidSourceFormatException, ReportDataSource}
import net.sf.jasperreports.engine._
import net.sf.jasperreports.engine.xml.JRXmlLoader
import play.api.Logger
import net.sf.jasperreports.engine.design.JasperDesign
import net.sf.jasperreports.engine.util.{JRElementsVisitor, JRSaver}
import java.util.StringTokenizer
import java.io.{File, OutputStream}


/**
 * Interface of the report generators.
 */
trait ReportGenerator {


  def generateFrom(source: ReportDataSource): Option[JasperPrint] = {
    try {
      val reportName = source.jasperReportFilenameMatcher()
      val jasperFilename = s"conf/$reportName.jasper"

      // If we do not have the compiled report templates, then we need to compile them
      // before we can generate a report.
      if (! new File(jasperFilename).exists()) {
        Logger.info("No jasper files. Compiling them from JRXML files")
        compileReportsRecursively(reportName)
        Logger.info("Completed compilation of JRXML files.")
      }

      val dataSource = source.convertToJRDataSource()
      val jasperPrint = JasperFillManager.fillReport(jasperFilename, null, dataSource)
      if (null != jasperPrint) Some(jasperPrint) else None
    }
    catch {
      case e: InvalidSourceFormatException => throw e
      case e: Throwable => {
        Logger.error(e.getMessage)
        None
      }
    }
  }

  def exportReportToStream(print: Option[JasperPrint], stream: OutputStream): SuccessOrFailure

  private def compileReportsRecursively(fileName: String): JasperReport = {
    val jrxmlFilename = s"conf/$fileName.jrxml"
    val jasperFilename = s"conf/$fileName.jasper"

      val jasperDesign: JasperDesign = JRXmlLoader.load(jrxmlFilename)
      val jasperReport = JasperCompileManager.compileReport(jasperDesign)
      JRSaver.saveObject(jasperReport, jasperFilename)
    //Compile sub reports
    JRElementsVisitor.visitReport(jasperReport, new ReportCompiler() {
      override def visitSubreport(subreport: JRSubreport): Unit = {
        val expression = subreport.getExpression.getText.replace(".jasper", "")
        val st = new StringTokenizer(expression, "\"/")
        var subReportName: String = null
        while (st.hasMoreTokens) {
          subReportName = st.nextToken()
        }

        //Sometimes the same subreport can be used multiple times, but
        //there is no need to compile multiple times
        //if(completedSubReports.contains(subReportName)) return
        //completedSubReports.add(subReportName)
        compileReportsRecursively(subReportName)
      }
    })
    jasperReport
  }
}
