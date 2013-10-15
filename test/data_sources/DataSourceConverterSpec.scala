package data_sources

import org.specs2.mutable._
import scala.xml.Elem

/**
 * TODO write description
 * @author Jorge Migueis
 *         Date: 11/10/2013
 */
class DataSourceConverterSpec extends Specification {

  "An XML should be converted to a XmlDataSource implicitly"  should {
     val xml:Elem = <DWPCAClaim><DWPCATransaction>ER123DF</DWPCATransaction></DWPCAClaim>

    def instanceOfXmlDataSource( reportDataSource:ReportDataSource) = {
       reportDataSource
    }
    instanceOfXmlDataSource(xml) must beAnInstanceOf[XmlDataSource]
  }
}
