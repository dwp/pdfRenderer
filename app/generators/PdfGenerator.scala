package generators

import data_sources.ReportDataSource

/**
 * Generates a PDF from a DataSource.
 * It reads the compiled report template, generate a JasperPrint and returns a PDF (an array of bytes).
 *
 * @author Jorge Migueis
 *         Date: 11/10/2013
 */
object PdfGenerator  extends Object with ReportGenerator {

  type GeneratorResult = Option[Array[Byte]]

  def generateFrom(source:ReportDataSource) = {
   None
  }

}
