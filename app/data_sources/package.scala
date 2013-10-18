import scala.xml.Elem
import scala.language.implicitConversions

/**
 * TODO write description
 * @author Jorge Migueis
 */
package object data_sources {
  implicit def convertXMLToDataSource(xmlSource:Elem):ReportDataSource = XmlDataSource(xmlSource)

  implicit def reportMatcher(source:ReportDataSource):String = ""

}
