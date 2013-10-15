package generators

import data_sources.ReportDataSource
import net.sf.jasperreports.engine.{JasperExportManager, JasperPrint, JasperFillManager}
import java.io.{File, OutputStream, FileOutputStream}

/**
 * Generates a PDF from a DataSource.
 * It reads the compiled report template, generate a JasperPrint and returns a PDF (an array of bytes).
 *
 * @author Jorge Migueis
 */
object PdfGenerator  extends Object with ReportGenerator {


  protected def exportReportToFormat(print:JasperPrint):GeneratorResult = {
    val pdfData = JasperExportManager.exportReportToPdf(print)
    JasperExportManager.exportReportToPdfFile(print, "/Users/valtechuk/test.pdf")
    GeneratorResult(pdfData)
  }
}
