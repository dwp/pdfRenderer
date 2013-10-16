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
case class PdfGenerator(source: ReportDataSource, pdfFileLocation: String) extends ReportGenerator(source, pdfFileLocation) {
  override protected def exportReportToFormat(print: JasperPrint): SuccessOrFailure = {
    PdfGenerator.exportReportToFormat(print, pdfFileLocation)
  }
}

object PdfGenerator {

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
