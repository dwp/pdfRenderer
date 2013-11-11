package data_sources

import net.sf.jasperreports.engine.JRDataSource
import scala.xml.{NodeSeq, Elem}
import java.io.ByteArrayInputStream
import net.sf.jasperreports.engine.data.JRXmlDataSource

/**
 * Receives XML and converts to JRXmlDataSource so it can be used by the Jasper generator engine.
 * @param source XML to convert to a Jasper ReportDataSource.
 */
case class XmlDataSource(source: NodeSeq) extends ReportDataSource {
  val claimElement = source \\ "DWPCATransaction" \\ "DWPCAClaim"
  val claimJasperTemplate = "reportNewClaim"
  val circsElement = source \\ "DWPCATransaction" \\ "DWPCAChangeOfCircumstances"
  val circsJasperTemplate = "reportNewCircs"


  // Warning: Return value should be created once for each pdf, do not re-use.
  def convertToJRDataSource(): JRDataSource = {
    new JRXmlDataSource(new ByteArrayInputStream(source.toString().getBytes("UTF-8")))
  }

  def jasperReportFilenameMatcher(): String = {
    circsElement.isEmpty match {
      case true => {
        claimElement.isEmpty match {
          case true => throw new scala.RuntimeException("XmlDataSource did not contain an XML element that matches a jasper template")
          case false => claimJasperTemplate
        }
      }
      case false => circsJasperTemplate
    }
  }
}
