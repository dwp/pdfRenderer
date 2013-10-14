package generators

import data_sources.ReportDataSource
import net.sf.jasperreports.engine.{JasperFillManager, JasperPrint}

/**
 * Interface of the report generators.
 * @author Jorge Migueis
 */
trait ReportGenerator {
  type GeneratorResult

  def generateFrom(source:ReportDataSource)(implicit template:(ReportDataSource) => String):GeneratorResult   = {
    //     Report= getResource(template(source))
//    JasperFillManager.fillReport(Report , ".", source.convertToJRDataSource());
    convertPrint(null)
  }

  protected def convertPrint(print:JasperPrint):GeneratorResult

}
