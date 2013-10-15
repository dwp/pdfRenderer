package data_sources

import net.sf.jasperreports.engine.JRDataSource
import scala.xml.Elem
import java.io.ByteArrayInputStream
import net.sf.jasperreports.engine.data.JRXmlDataSource

/**
 * A data source that is an XML document.
 * Converts an XML into a JRXmlDataSource.
 * @author Jorge Migueis
 */
case class XmlDataSource(val source:Elem) extends ReportDataSource {

  def convertToJRDataSource(): JRDataSource = {
    new JRXmlDataSource(new ByteArrayInputStream(source.toString().getBytes("UTF-8")))
  }

  def reportMatcher(): String = {
    /*
      new String(source.getBytes).contains("DWPCAClaim") match {
        case true => "reportNewClaim.jrxml"
        case false => ""
      }*/

    println("XmlDataSource:reportMatcher")
    "reportNewClaim.jrxml"
  }
}