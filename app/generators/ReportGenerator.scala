package generators

import data_sources.{EmptyDataSource, ReportDataSource}
import net.sf.jasperreports.engine.{JasperCompileManager, JasperFillManager, JasperPrint}
import net.sf.jasperreports.engine.xml.JRXmlLoader
import play.api.Logger


/**
 * Interface of the report generators.
 * @author Jorge Migueis
 */
trait ReportGenerator {


  def generateFrom(source: ReportDataSource)(implicit template: (ReportDataSource) => String): SuccessOrFailure = {

    try {

      source match {
        case _: EmptyDataSource => throw new scala.Exception("No data source type found")
        case _ => // Do not do any
      }
      //val report= Play.application().getFile("reportNewClaim_Address.jrxml")  //template(source)
      val jasperTemplate = getClass.getClassLoader.getResourceAsStream("reportNewClaim.jrxml")
      val jasperDesign = JRXmlLoader.load(jasperTemplate)
      val jasperReport = JasperCompileManager.compileReport(jasperDesign)

      val dataSource = source.convertToJRDataSource()
      val jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource)
      exportReportToFormat(jasperPrint)
      GenerationSuccess()
    }
    catch {
      case e: Throwable => {
        e.printStackTrace()
        Logger.error(e.getMessage)
        GenerationFailure()
      }
    }
  }

  protected def exportReportToFormat(print: JasperPrint): SuccessOrFailure

}
