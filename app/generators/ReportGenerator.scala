package generators

import data_sources.{ReportDataSource}
import net.sf.jasperreports.engine.{JasperReport, JasperCompileManager, JasperFillManager, JasperPrint}
import net.sf.jasperreports.engine.xml.JRXmlLoader
import play.api.Logger


/**
 * Interface of the report generators.
 * @author Jorge Migueis
 */
trait ReportGenerator {


  def generateFrom(source: ReportDataSource): SuccessOrFailure = {

    try {
      val filename = source.reportMatcher()
      val jasperReport = createJasperReport(filename)
      val dataSource = source.convertToJRDataSource()
      val jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource)
      exportReportToFormat(jasperPrint)
      GenerationSuccess()
    }
    catch {
      case e: Throwable => {
        Logger.error(e.getMessage)
        GenerationFailure()
      }
    }
  }

  private def createJasperReport(fileName: String): JasperReport = {
    println("ReportGenerator:createJasperReport:fileName "+fileName)
    val jasperTemplate = getClass.getClassLoader.getResourceAsStream(fileName)
    val jasperDesign = JRXmlLoader.load(jasperTemplate)
    val jasperReport = JasperCompileManager.compileReport(jasperDesign)
    jasperReport
  }

  protected def exportReportToFormat(print: JasperPrint): SuccessOrFailure

}
