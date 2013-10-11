package data_sources

import net.sf.jasperreports.engine.JRDataSource

/**
 * Interface of all the data sources. Used by the report generators.
 * @author Jorge Migueis
 *         Date: 11/10/2013
 */
trait ReportDataSource {

  def convertToJRDataSource():JRDataSource

}
