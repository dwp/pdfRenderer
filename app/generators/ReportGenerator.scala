package generators

import data_sources.ReportDataSource
import net.sf.jasperreports.engine.{JasperCompileManager, JasperFillManager, JasperPrint}
import net.sf.jasperreports.engine.xml.JRXmlLoader

/**
 * Interface of the report generators.
 * @author Jorge Migueis
 */
trait ReportGenerator {
  case class GeneratorResult(convertedData: Array[Byte])

  def generateFrom(source:ReportDataSource)(implicit template:(ReportDataSource) => String): GeneratorResult   = {
    //val report= Play.application().getFile("reportNewClaim_Address.jrxml")  //template(source)
    val jasperTemplate = getClass.getClassLoader.getResourceAsStream("reportNewClaim.jrxml")
    val jasperDesign = JRXmlLoader.load(jasperTemplate)
    val jasperReport = JasperCompileManager.compileReport(jasperDesign)
    val dataSource = source.convertToJRDataSource()
    val jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource)

    exportReportToFormat(jasperPrint)
  }

  protected def exportReportToFormat(print:JasperPrint):GeneratorResult

}
