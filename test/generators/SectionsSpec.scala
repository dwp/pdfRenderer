package generators

import scala.xml.Elem
import generators.Helper._
import java.io.File
import org.specs2.mutable.Specification
import com.itextpdf.text.pdf.parser.{SimpleTextExtractionStrategy, PdfReaderContentParser}
import test_data.{XMLData, ClaimBuilder}


class SectionsSpec extends Specification  with PdfSpecification {

  "PdfContentMatching" should {


    def getPDFContentFromPage(pdfFileLocation: String, pageNumber:Int): String = {

      val reader = new com.itextpdf.text.pdf.PdfReader(pdfFileLocation)
      val parser = new PdfReaderContentParser(reader)

      println("***NumberOfpage :"+reader.getNumberOfPages)

      val content: Seq[String] = for (i <- pageNumber to reader.getNumberOfPages) yield {
        val strategy = parser.processContent(i, new SimpleTextExtractionStrategy())

        strategy.getResultantText
      }
      reader.close()

      content.mkString.toLowerCase.replaceAll("\n", " ")
    }

    def getPDFContentBetweenPage(pdfFileLocation: String, pageNumber:Int, endPageNumber:Int): String = {

      val reader = new com.itextpdf.text.pdf.PdfReader(pdfFileLocation)
      val parser = new PdfReaderContentParser(reader)

      println("***NumberOfpage :"+reader.getNumberOfPages)

      val content: Seq[String] = for (i <- pageNumber to endPageNumber) yield {
        val strategy = parser.processContent(i, new SimpleTextExtractionStrategy())

        strategy.getResultantText
      }
      reader.close()

      content.mkString.toLowerCase.replaceAll("\n", " ")
    }

    def foundMustBeTrue(testData: Seq[String], totalContent: String) = {
      testData map (s => println("TestDat "+s))
      testData.forall(x => {
        val found = totalContent.contains(x.toLowerCase)
        if (!found) {
          println("*** Cannot find: " + x.toLowerCase)
          println("*** End ***")
        }
        found
      })
    }

    def testContentMatchesFromPage(pdfFileLocation: String,
                                 testCaseXml: Elem,
                                 generateTestData: (Elem => Seq[String]),
                                 matchFunction: ((Seq[String], String) => Boolean), pageNumber:Int) = {
      testOutputFileExists(pdfFileLocation, testCaseXml)
      val totalContent = getPDFContentFromPage(pdfFileLocation, pageNumber)
      val testData = generateTestData(testCaseXml)

      println("TotalContent " + totalContent)

      matchFunction(testData, totalContent) must beTrue
      //deletePdfFile(pdfFileLocation)
    }

    def testContentMatchesBetweenPage(pdfFileLocation: String,
                                   testCaseXml: Elem,
                                   generateTestData: (Elem => Seq[String]),
                                   matchFunction: ((Seq[String], String) => Boolean), pageNumber:Int, endPageNumber:Int) = {
      testOutputFileExists(pdfFileLocation, testCaseXml)
      val totalContent = getPDFContentBetweenPage(pdfFileLocation, pageNumber, endPageNumber)
      val testData = generateTestData(testCaseXml)

      println("TotalContent " + totalContent)

      matchFunction(testData, totalContent) must beTrue
      //deletePdfFile(pdfFileLocation)
    }

  }
}
