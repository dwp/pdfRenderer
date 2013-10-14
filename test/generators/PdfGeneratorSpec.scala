package generators

import org.specs2.mutable._
import data_sources.{EmptyDataSource, ReportDataSource}


/**
 * Test PdfGenerator with the implicits defined in package object data_sources.
 * @author Jorge Migueis
 */
class PdfGeneratorSpec extends Specification {

  "PdfGenerator should be able to handle an empty data source and return None"  should {
    PdfGenerator.generateFrom(new EmptyDataSource) must beNone
  }
}
