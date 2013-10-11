package generators

import data_sources.ReportDataSource

/**
 * TODO write description
 * @author Jorge Migueis
 *         Date: 11/10/2013
 */
trait ReportGenerator {
  type GeneratorResult

  def generateFrom(source:ReportDataSource):GeneratorResult

}
