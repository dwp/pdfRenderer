package data_sources

import net.sf.jasperreports.engine.data.JRXmlDataSource
import org.specs2.mutable.Specification
import utils.WithApplication

import scala.xml.XML

/**
 * TODO write description
 * @author Jorge Migueis
 *         Date: 11/10/2013
 */
class XmlDataSourceSpec extends Specification {
  "XmlDataSource" should {
    "convert XML to JRXmlDataSource" in {
      val xml = <DWPCAClaim>
        <DWPCATransaction>ER123DF</DWPCATransaction>
      </DWPCAClaim>
      val dataSource = new XmlDataSource(xml)
      dataSource.convertToJRDataSource() must beAnInstanceOf[JRXmlDataSource]
    }

    "jasperReportFilenameMatcher returns reportNewCircs for xml containing DWPCAChangeOfCircumstances element" in {
      val xml = <DWPCAClaim>
        <DWPCATransaction>
          <DWPCAChangeOfCircumstances></DWPCAChangeOfCircumstances>
        </DWPCATransaction>
      </DWPCAClaim>
      val dataSource = new XmlDataSource(xml)
      dataSource.jasperReportFilenameMatcher() mustEqual "reportNewCircs"
    }

    "jasperReportFilenameMatcher returns reportNewClaim for xml containing DWPCAClaim element" in new WithApplication {
      val xml = <DWPCAClaim>
        <DWPCATransaction>
          <DWPCAClaim></DWPCAClaim>
        </DWPCATransaction>
      </DWPCAClaim>
      val dataSource = new XmlDataSource(xml)
      dataSource.jasperReportFilenameMatcher() mustEqual "reportClaimWithSummary"
    }

    "jasperReportFilenameMatcher throws for xml not containing DWPCAChangeOfCircumstances or DWPCAClaim element" in {
      val xml = <DWPCAClaim>
        <DWPCATransaction></DWPCATransaction>
      </DWPCAClaim>
      val dataSource = new XmlDataSource(xml)
      dataSource.jasperReportFilenameMatcher() must throwA[scala.RuntimeException]
    }

    "Decrypt encrypted claim" in {
      val xml = XML.load(getClass getResourceAsStream "/EncryptedSensitiveDataClaim.xml")
      val dataSource = new XmlDataSource(xml)
      val jrDataSource: JRXmlDataSource = dataSource.convertToJRDataSource.asInstanceOf[JRXmlDataSource]
      jrDataSource.next
      val textDecrypted = jrDataSource.subDocument.getDocumentElement.getTextContent
      textDecrypted must contain("nameDoe")
      textDecrypted must contain("National Insurance numberAA000001A")
      textDecrypted must contain("PR2 2HP")
      textDecrypted must contain("National Insurance numberAA000002A")
      textDecrypted must contain("FY14 4AJ")
      textDecrypted must contain("Name of account holderMe")
      textDecrypted must contain("Account number12345678")
      textDecrypted must contain("Sort code222222")
    }

    "Decrypt encrypted change bank details" in {
      val xml = XML.load(getClass getResourceAsStream "/EncryptedSensitiveDataChangeBankDetails.xml")
      val dataSource = new XmlDataSource(xml)
      val jrDataSource: JRXmlDataSource = dataSource.convertToJRDataSource.asInstanceOf[JRXmlDataSource]
      jrDataSource.next
      val textDecrypted = jrDataSource.subDocument.getDocumentElement.getTextContent
      textDecrypted must contain("George Mason")
      textDecrypted must contain("Jeanne Mason")
      textDecrypted must contain("Name of account holderMe")
      textDecrypted must contain("Account number87654321")
      textDecrypted must contain("Sort code333333")
    }

    "Decrypt encrypted change address" in {
      val xml = XML.load(getClass getResourceAsStream "/EncryptedSensitiveDataChangeAddress.xml")
      val dataSource = new XmlDataSource(xml)
      val jrDataSource: JRXmlDataSource = dataSource.convertToJRDataSource.asInstanceOf[JRXmlDataSource]
      jrDataSource.next
      val textDecrypted = jrDataSource.subDocument.getDocumentElement.getTextContent
      textDecrypted must contain("David Doe")
      textDecrypted must contain("George Doe")
      textDecrypted must contain("M5 3EJ")
      textDecrypted must contain("FY1 1RW")
      textDecrypted must contain("PR2 2HP")
    }
  }
}
