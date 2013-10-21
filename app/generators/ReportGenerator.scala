package generators

import data_sources.ReportDataSource
import net.sf.jasperreports.engine._
import net.sf.jasperreports.engine.xml.JRXmlLoader
import play.api.Logger
import net.sf.jasperreports.engine.design.JasperDesign
import net.sf.jasperreports.engine.util.{JRElementsVisitor, JRSaver}
import java.util.StringTokenizer


/**
 * Interface of the report generators.
 */
trait ReportGenerator {


  def generateFrom(source: ReportDataSource, fileLocation: String): SuccessOrFailure = {

    try {
      val jasperReportFilename = source.jasperReportFilenameMatcher()

      compileReportsRecursively(jasperReportFilename)

      val jasperReport = createJasperReport(jasperReportFilename)
      val dataSource = source.convertToJRDataSource()
      val jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource)
      exportReportToFormat(jasperPrint, fileLocation)
      GenerationSuccess()
    }
    catch {
      case e: Throwable => {
        //e.printStackTrace()
        Logger.error(e.getMessage)
        GenerationFailure()
      }
    }
  }

  private def createJasperReport(fileName: String): JasperReport = {
    val jasperTemplate = getClass.getClassLoader.getResourceAsStream(fileName + ".jrxml")
    val jasperDesign = JRXmlLoader.load(jasperTemplate)
    val jasperReport = JasperCompileManager.compileReport(jasperDesign)
    jasperReport
  }

  protected def exportReportToFormat(print: JasperPrint, fileLocation:String): SuccessOrFailure


  def compileReportsRecursively(fileName: String): Unit = {
    val jrxmlFilename = "conf/" + fileName + ".jrxml"
    val jasperFilename = "conf/" + fileName + ".jasper"

    val jasperDesign: JasperDesign = JRXmlLoader.load(jrxmlFilename)
    val jasperReport = JasperCompileManager.compileReport(jasperDesign)
    if (!new java.io.File(jasperFilename).exists) {
    JRSaver.saveObject(jasperReport, jasperFilename)
    }
    //Compile sub reports
    JRElementsVisitor.visitReport(jasperReport, new ReportCompilerVisitor() {
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
  }
}
