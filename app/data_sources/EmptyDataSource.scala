package data_sources

import net.sf.jasperreports.engine.JRDataSource

/**
 * To be used for testing reports with an empty data source.
 * @author Jorge Migueis
 */
case class EmptyDataSource() extends ReportDataSource {
  def convertToJRDataSource(): JRDataSource = {
    null
  }

  def reportMatcher(source: ReportDataSource): String = ""
}
