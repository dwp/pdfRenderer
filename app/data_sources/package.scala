import scala.xml.Elem

/**
 * TODO write description
 * @author Jorge Migueis
 *         Date: 11/10/2013
 */
package object data_sources {
  implicit def convertXMLToDataSource(xmlSource:Elem):ReportDataSource = XmlDataSource(xmlSource)

}
