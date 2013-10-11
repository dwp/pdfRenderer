package data_sources

import scala.xml.Elem

/**
 * TODO write description
 * @author Jorge Migueis
 *         Date: 11/10/2013
 */
object DataSourceConverter {

  implicit def convertXMLToDataSource(xmlSource:Elem):ReportDataSource =  {
     new ReportDataSource {}
  }

}
