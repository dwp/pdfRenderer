package generators

import data_sources.ReportDataSource
import net.sf.jasperreports.engine.{JasperExportManager, JasperPrint, JasperFillManager}
import java.io.{File, OutputStream, FileOutputStream}
import play.api.Logger

/**
 * Generates a PDF from a DataSource.
 * It reads the compiled report template, generate a JasperPrint and returns a PDF (an array of bytes).
 *
 * @author Jorge Migueis
 */
object PdfGenerator extends ReportGenerator {


  protected def exportReportToFormat(print: JasperPrint): SuccessOrFailure = {
    try {
      JasperExportManager.exportReportToPdfFile(print, "/Users/valtechuk/test.pdf")
      GenerationSuccess()
    } catch {
      case e: Exception => {
        Logger.error(e.getMessage)
        GenerationFailure()
      }
    }
  }
}
