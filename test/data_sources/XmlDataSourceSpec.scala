package data_sources

import org.specs2.mutable.Specification
import net.sf.jasperreports.engine.data.JRXmlDataSource

/**
 * TODO write description
 * @author Jorge Migueis
 *         Date: 11/10/2013
 */
class XmlDataSourceSpec extends Specification {
  "XmlDataSourceSpec" should {
    "An XmlDataSource should convert XML to JRXmlDataSource" in {
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

    "jasperReportFilenameMatcher returns reportNewClaim for xml containing DWPCAClaim element" in {
      val xml = <DWPCAClaim>
        <DWPCATransaction>
          <DWPCAClaim></DWPCAClaim>
        </DWPCATransaction>
      </DWPCAClaim>
      val dataSource = new XmlDataSource(xml)
      dataSource.jasperReportFilenameMatcher() mustEqual "reportNewClaim"
    }

    "jasperReportFilenameMatcher throws for xml not containing DWPCAChangeOfCircumstances or DWPCAClaim element" in {
      val xml = <DWPCAClaim>
        <DWPCATransaction></DWPCATransaction>
      </DWPCAClaim>
      val dataSource = new XmlDataSource(xml)
      dataSource.jasperReportFilenameMatcher() must throwA[scala.RuntimeException]
    }
  }
}
