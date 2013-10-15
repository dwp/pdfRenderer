package data_sources

import net.sf.jasperreports.engine.JRDataSource
import scala.xml.Elem
import java.io.ByteArrayInputStream
import net.sf.jasperreports.engine.data.JRXmlDataSource

case class XmlDataSource(val source:Elem) extends ReportDataSource {

  def convertToJRDataSource(): JRDataSource = {
    new JRXmlDataSource(new ByteArrayInputStream(source.toString().getBytes("UTF-8")))
  }

  def jasperReportFilenameMatcher(): String = {
    (source \\ "DWPCATransaction" \\ "DWPCAChangeOfCircumstances").length match {
      case 0 => {
        (source \\ "DWPCATransaction" \\ "DWPCAClaim").length match {
          case 0 => throw new scala.RuntimeException("XmlDataSource could not match a report template")
          case _ => "reportNewClaim.jrxml"
        }
      }
      case _ => "reportNewCircs.jrxml"
    }
  }
}