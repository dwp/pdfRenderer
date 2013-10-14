package generators

import data_sources.ReportDataSource

/**
 * Interface of the report generators.
 * @author Jorge Migueis
 */
trait ReportGenerator {
  type GeneratorResult

  def generateFrom(source:ReportDataSource)(implicit template:(ReportDataSource) => String):GeneratorResult

}
