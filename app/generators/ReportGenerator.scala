package generators

import data_sources.ReportDataSource

/**
 * Interface of the report generators.
 * @author Jorge Migueis
 *         Date: 11/10/2013
 */
trait ReportGenerator {
  type GeneratorResult

  def generateFrom(source:ReportDataSource):GeneratorResult

}
