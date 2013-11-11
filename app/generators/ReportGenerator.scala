package generators

import data_sources.ReportDataSource
import net.sf.jasperreports.engine._
import net.sf.jasperreports.engine.xml.JRXmlLoader
import play.api.Logger
import net.sf.jasperreports.engine.design.JasperDesign
import net.sf.jasperreports.engine.util.{JRElementsVisitor, JRSaver}
import java.util.StringTokenizer
import java.io.OutputStream


/**
 * Interface of the report generators.
 */
trait ReportGenerator {


  def generateFrom(source: ReportDataSource):Option[JasperPrint] = {
    try {
      val jasperReportFilename = source.jasperReportFilenameMatcher()

      // Needed so compiles sub-reports
      val jasperReport = compileReportsRecursively(jasperReportFilename)

      val dataSource = source.convertToJRDataSource()
      val jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource)
      if (null != jasperPrint) Some(jasperPrint) else None
    }
    catch {
      case e: Throwable => {
        Logger.error(e.getMessage)
        None
      }
    }
  }

  def exportReportToStream(print: Option[JasperPrint], stream: OutputStream): SuccessOrFailure

  private def compileReportsRecursively(fileName: String): JasperReport = {
    val jrxmlFilename = "conf/" + fileName + ".jrxml"
    val jasperFilename = "conf/" + fileName + ".jasper"

    val jasperDesign: JasperDesign = JRXmlLoader.load(jrxmlFilename)
    val jasperReport = JasperCompileManager.compileReport(jasperDesign)
    //if (!new java.io.File(jasperFilename).exists) {
      JRSaver.saveObject(jasperReport, jasperFilename)
    //}
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
