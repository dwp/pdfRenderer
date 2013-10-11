package generators

import org.specs2.mutable._
import data_sources.ReportDataSource


/**
 * TODO write description
 * @author Jorge Migueis
 *         Date: 11/10/2013
 */
class PdfGeneratorSpec extends Specification {

  "PdfGenerator should be able to handle an empty data source and return None"  should {
    PdfGenerator.generateFrom(new ReportDataSource{}) must beNone
  }
}
