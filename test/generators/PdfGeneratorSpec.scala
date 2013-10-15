package generators

import org.specs2.mutable._
import data_sources.{XmlDataSource, EmptyDataSource, ReportDataSource}
import generators.PdfGenerator.GeneratorResult
import play.api.Play.current
import play.api.libs.concurrent.Execution.Implicits.defaultContext

/**
 * Test PdfGenerator with the implicits defined in package object data_sources.
 * @author Jorge Migueis
 */
class PdfGeneratorSpec extends Specification {

  /*
  "PdfGenerator should be able to handle an empty data source and return None"  should {
    PdfGenerator.generateFrom(new EmptyDataSource) must beNone
  }*/

  "PdfGenerator should be able to handle an xml data source and return pdf"  should {
    val xml = <DWPCAClaim><DWPCATransaction>ER123DF</DWPCATransaction></DWPCAClaim>
    val dataSource = new XmlDataSource(xml)
    val generatorResult = PdfGenerator.generateFrom(dataSource)
    generatorResult must beAnInstanceOf[GeneratorResult]
    generatorResult.convertedData.length mustNotEqual 0
  }
}
