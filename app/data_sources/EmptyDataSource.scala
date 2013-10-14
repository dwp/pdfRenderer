package data_sources

import net.sf.jasperreports.engine.JRDataSource

/**
 * To be used for testing reports with an empty data source.
 * @author Jorge Migueis
 */
class EmptyDataSource extends Object with ReportDataSource {
  def convertToJRDataSource(): JRDataSource = {
    null
  }
}
