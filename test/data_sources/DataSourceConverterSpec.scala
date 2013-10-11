package data_sources

import org.specs2.mutable._
import DataSourceConverter._

/**
 * TODO write description
 * @author Jorge Migueis
 *         Date: 11/10/2013
 */
class DataSourceConverterSpec extends Specification {

  "DataSourceConverter should convert XML to 1 implicitly"  should {
     val xml = <DWPCAClaim><DWPCATransaction>ER123DF</DWPCATransaction></DWPCAClaim>

    def needsInteger( one:ReportDataSource) = {
      true
    }

    needsInteger(xml) must beTrue
  }

}
