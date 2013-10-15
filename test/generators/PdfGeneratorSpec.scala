package generators

import org.specs2.mutable._
import data_sources.{EmptyDataSource, XmlDataSource}
import test_data.ClaimBuilder

/**
 * Test PdfGenerator with the implicits defined in package object data_sources.
 * @author Jorge Migueis
 */
class PdfGeneratorSpec extends Specification {

  "PdfGenerator should fail with no data source"  should {
    val dataSource = new EmptyDataSource
    val generatorResult = PdfGenerator.generateFrom(dataSource)
    generatorResult must beAnInstanceOf[GenerationFailure]
  }

  "PdfGenerator should be handle valid xml and return success"  should {
    val xml = ClaimBuilder.buildGoodClaim
    val dataSource = new XmlDataSource(xml)
    val generatorResult = PdfGenerator.generateFrom(dataSource)
    generatorResult must beAnInstanceOf[GenerationSuccess]
  }
}
