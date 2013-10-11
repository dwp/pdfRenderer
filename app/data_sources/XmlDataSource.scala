package data_sources

import net.sf.jasperreports.engine.JRDataSource
import scala.xml.Elem
import java.io.ByteArrayInputStream
import net.sf.jasperreports.engine.data.JRXmlDataSource

/**
 * A data source that is an XML document.
 * Converts an XML into a JRXmlDataSource.
 * @author Jorge Migueis
 *         Date: 11/10/2013
 */
class XmlDataSource(val source:Elem) extends Object with ReportDataSource {

  def convertToJRDataSource(): JRDataSource = {
    new JRXmlDataSource(new ByteArrayInputStream(source.toString().getBytes("UTF-8")))
  }
}

object XmlDataSource {
  def apply(xmlSource:Elem) = new XmlDataSource(xmlSource)
}