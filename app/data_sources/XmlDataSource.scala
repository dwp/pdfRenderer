package data_sources

import java.io.ByteArrayInputStream

import helpers.XmlNodeDecryptor
import net.sf.jasperreports.engine.JRDataSource
import net.sf.jasperreports.engine.data.JRXmlDataSource
import play.api.Logger

import scala.xml.NodeSeq

/**
 * Receives XML and converts to JRXmlDataSource so it can be used by the Jasper generator engine.
 * @param source XML to convert to a Jasper ReportDataSource.
 */
case class XmlDataSource(source: NodeSeq) extends ReportDataSource {
  val claimElement = source \\ "DWPCATransaction" \\ "DWPCAClaim"
  val claimJasperTemplate = "reportClaimWithSummary"
  val circsElement = source \\ "DWPCATransaction" \\ "DWPCAChangeOfCircumstances"
  val circsJasperTemplate = "reportNewCircs"


  // Warning: Return value should be created once for each pdf, do not re-use.
  def convertToJRDataSource(): JRDataSource = {
    val decryptedSource = decryptSource
    new JRXmlDataSource(new ByteArrayInputStream(decryptedSource.toString().getBytes("UTF-8")))
  }

  def jasperReportFilenameMatcher(): String = {
    circsElement.isEmpty match {
      case true => {
        claimElement.isEmpty match {
          case true => throw new InvalidSourceFormatException("XmlDataSource did not contain an XML element that matches a jasper template.")
          case false => claimJasperTemplate
        }
      }
      case false => circsJasperTemplate
    }
  }

  private def decryptSource(): NodeSeq = {
    try {
      if (!(claimElement.isEmpty)) {
        // New claim
        var xml = XmlNodeDecryptor.decryptValueForOptionalNode(source(0), List("DWPCATransaction", "DWPCAClaim", "Claimant", "Surname", "Answer"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAClaim", "Claimant", "NationalInsuranceNumber", "Answer"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAClaim", "Claimant", "Address", "Answer", "PostCode"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAClaim", "Caree", "Surname", "Answer"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAClaim", "Caree", "NationalInsuranceNumber", "Answer"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAClaim", "Caree", "Address", "Answer", "PostCode"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAClaim", "Partner", "Surname", "Answer"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAClaim", "Partner", "NationalInsuranceNumber", "Answer"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAClaim", "Partner", "Address", "Answer", "PostCode"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAClaim", "Payment", "Account", "HolderName", "Answer"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAClaim", "Payment", "Account", "BuildingSocietyDetails", "AccountNumber", "Answer"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAClaim", "Payment", "Account", "BuildingSocietyDetails", "SortCode", "Answer"))
        xml
      } else {
        //Change Of Circumstances
        var xml = XmlNodeDecryptor.decryptValueForOptionalNode(source(0), List("DWPCATransaction", "DWPCAChangeOfCircumstances", "ClaimantDetails", "FullName", "Answer"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAChangeOfCircumstances", "ClaimantDetails", "NationalInsuranceNumber", "Answer"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAChangeOfCircumstances", "CareeDetails", "FullName", "Answer"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAChangeOfCircumstances", "PaymentChange", "AccountDetails", "HolderName", "Answer"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAChangeOfCircumstances", "PaymentChange", "AccountDetails", "BuildingSocietyDetails", "AccountNumber", "Answer"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAChangeOfCircumstances", "PaymentChange", "AccountDetails", "BuildingSocietyDetails", "SortCode", "Answer"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAChangeOfCircumstances", "AddressChange", "PreviousAddress", "Answer", "PostCode"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAChangeOfCircumstances", "AddressChange", "NewAddress", "Answer", "PostCode"))
        xml = XmlNodeDecryptor.decryptValueForOptionalNode(xml, List("DWPCATransaction", "DWPCAChangeOfCircumstances", "AddressChange", "CareeAddress", "Answer", "PostCode"))
        xml
      }
    } catch {
      case e: RuntimeException =>
        Logger.error(s"Sensitive data decryption failed. ${e.getMessage}")
        throw e
    }

  }
}
