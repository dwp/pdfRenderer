package generators

import data_sources.ReportDataSource
import net.sf.jasperreports.engine.{JasperPrint, JasperFillManager}

/**
 * Generates a PDF from a DataSource.
 * It reads the compiled report template, generate a JasperPrint and returns a PDF (an array of bytes).
 *
 * @author Jorge Migueis
 */
object PdfGenerator  extends Object with ReportGenerator {

  type GeneratorResult = Option[Array[Byte]]

  protected def convertPrint(print:JasperPrint):GeneratorResult = {
    None
  }



}
