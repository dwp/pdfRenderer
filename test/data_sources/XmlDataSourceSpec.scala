package data_sources

import org.specs2.mutable.Specification
import net.sf.jasperreports.engine.data.JRXmlDataSource

/**
 * TODO write description
 * @author Jorge Migueis
 *         Date: 11/10/2013
 */
class XmlDataSourceSpec  extends Specification {

  "An XmlDataSource should convert XML to JRXmlDataSource"  should {
    val xml = <DWPCAClaim><DWPCATransaction>ER123DF</DWPCATransaction></DWPCAClaim>
    val dataSource = new XmlDataSource(xml)
    dataSource.convertToJRDataSource() must beAnInstanceOf[JRXmlDataSource]
  }
}
