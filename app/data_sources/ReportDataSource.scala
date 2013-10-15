package data_sources

import net.sf.jasperreports.engine.JRDataSource

/**
 * Interface of all the data sources. Used by the report generators.
 * @author Jorge Migueis
 */
trait ReportDataSource {

  def convertToJRDataSource():JRDataSource

  def reportMatcher():String

}
