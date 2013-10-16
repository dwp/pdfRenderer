package generators

import org.specs2.mutable._
import data_sources.{XmlDataSource}
import test_data.ClaimBuilder

import java.io.{File, FileOutputStream, PrintWriter}


import com.itextpdf.text.pdf.PdfReader
import com.itextpdf.text.pdf.parser.PdfReaderContentParser
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy
import com.itextpdf.text.pdf.parser.TextExtractionStrategy
import org.specs2.specification.BeforeExample


/**
 * Test PdfGenerator with the implicits defined in package object data_sources.
 * @author Jorge Migueis
 */
class PdfGeneratorSpec extends Specification with Before{


  override def before  = {
    val pdfFile = new File(PdfGenerator.pdfFileLocation)
    if (pdfFile.exists()){
      pdfFile.delete()
    }
  }

  "PdfGenerator should be reject xml that does not contain DWPCAClaim or DWPCACircs"  should {
    val xml = ClaimBuilder.buildBadClaim
    val dataSource = new XmlDataSource(xml)
    val generator = PdfGenerator(dataSource)
    val generatorResult = generator.generateFrom()
    generatorResult must beAnInstanceOf[GenerationFailure]
  }

  "PdfGenerator should be handle valid xml and return success"  should {
    val xml = ClaimBuilder.buildGoodClaim
    val dataSource = new XmlDataSource(xml)
    val generator = PdfGenerator(dataSource)
    val generatorResult = generator.generateFrom()
    generatorResult must beAnInstanceOf[GenerationSuccess]
  }

  "PdfGenerator should create a PDF file" should {
    val xml = ClaimBuilder.buildGoodClaim
    val dataSource = new XmlDataSource(xml)
    PdfGenerator(dataSource).generateFrom()
    val pdfFile = new File(PdfGenerator.pdfFileLocation)
    pdfFile.exists() must beTrue
  }

  "PdfGenerator should be handle functionalTestCase1 and return success"  should {
    val xml = ClaimBuilder.functionalTestCase1
    val dataSource = new XmlDataSource(xml)
    val generator = PdfGenerator(dataSource)
    val generatorResult = generator.generateFrom()
    generatorResult must beAnInstanceOf[GenerationSuccess]
  }

  "PdfGenerator should create functionalTestCase1 PDF file" should {
    val xml = ClaimBuilder.functionalTestCase1
    val dataSource = new XmlDataSource(xml)
    PdfGenerator(dataSource).generateFrom()
    val pdfFile = new File(PdfGenerator.pdfFileLocation)
    pdfFile.exists() must beTrue
  }

  "PdfGenerator should be handle functionalTestCase2 and return success"  should {
    val xml = ClaimBuilder.functionalTestCase2
    val dataSource = new XmlDataSource(xml)
    val generator = PdfGenerator(dataSource)
    val generatorResult = generator.generateFrom()
    generatorResult must beAnInstanceOf[GenerationSuccess]
  }

  "PdfGenerator should create functionalTestCase2 PDF file" should {
    val xml = ClaimBuilder.functionalTestCase2
    val dataSource = new XmlDataSource(xml)
    PdfGenerator(dataSource).generateFrom()
    val pdfFile = new File(PdfGenerator.pdfFileLocation)
    pdfFile.exists() must beTrue
  }

  "PdfGenerator should be handle functionalTestCase3 and return success"  should {
    val xml = ClaimBuilder.functionalTestCase3
    val dataSource = new XmlDataSource(xml)
    val generator = PdfGenerator(dataSource)
    val generatorResult = generator.generateFrom()
    generatorResult must beAnInstanceOf[GenerationSuccess]
  }

  "PdfGenerator should create functionalTestCase3 PDF file" should {
    val xml = ClaimBuilder.functionalTestCase3
    val dataSource = new XmlDataSource(xml)
    PdfGenerator(dataSource).generateFrom()
    val pdfFile = new File(PdfGenerator.pdfFileLocation)
    pdfFile.exists() must beTrue
  }

       /*
  "Extract PDF" should {
    val reader = new com.itextpdf.text.pdf.PdfReader("/Users/valtechuk/test.pdf")
    val parser = new PdfReaderContentParser(reader)

    for (i  <- 1 until reader.getNumberOfPages()) {
      val strategy = parser.processContent(i, new SimpleTextExtractionStrategy())
      println(strategy.getResultantText());
    }
    reader.close()
    success
    }*/

}

