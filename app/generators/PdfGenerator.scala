package generators

import data_sources.ReportDataSource

/**
 * Generates a PDF from a DataSource.
 * It reads the compiled report template, generate a JasperPrint and returns a PDF (an array of bytes).
 *
 * @author Jorge Migueis
 */
object PdfGenerator  extends Object with ReportGenerator {

  type GeneratorResult = Option[Array[Byte]]

  def generateFrom(source:ReportDataSource)(implicit template:(ReportDataSource) => String) = {
   None
  }

}
