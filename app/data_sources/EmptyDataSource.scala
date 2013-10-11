package data_sources

import net.sf.jasperreports.engine.JRDataSource

/**
 * To be used for testing reports with an empty data source.
 * @author Jorge Migueis
 *         Date: 11/10/2013
 */
class EmptyDataSource extends Object with ReportDataSource {
  def convertToJRDataSource(): JRDataSource = {
    null
  }
}
