package generators

import data_sources.ReportDataSource
import net.sf.jasperreports.engine.{JasperExportManager, JasperPrint}
import play.api.Logger

/**
 * Generates a PDF from a DataSource.
 * It reads the compiled report template, generate a JasperPrint and writes to a file.
 *
 * @author Jorge Migueis
 */
object PdfGenerator extends ReportGenerator{

  protected def exportReportToFormat(print: JasperPrint, pdfFileLocation: String): SuccessOrFailure = {
    try {
      JasperExportManager.exportReportToPdfFile(print, pdfFileLocation)
      GenerationSuccess()
    } catch {
      case e: Exception => {
        Logger.error(e.getMessage)
        GenerationFailure()
      }
    }
  }
}
