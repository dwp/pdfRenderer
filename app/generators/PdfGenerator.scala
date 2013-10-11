package generators

import data_sources.ReportDataSource

/**
 * TODO write description
 * @author Jorge Migueis
 *         Date: 11/10/2013
 */
object PdfGenerator extends ReportGenerator {

  type GeneratorResult = Option[Array[Byte]]

  def generateFrom(source:ReportDataSource) = {
   None
  }

}
