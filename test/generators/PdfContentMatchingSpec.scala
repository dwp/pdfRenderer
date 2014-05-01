package generators

import scala.xml.Elem
import generators.Helper._
import java.io.File
import com.itextpdf.text.pdf.parser.{SimpleTextExtractionStrategy, PdfReaderContentParser}
import org.specs2.mutable.Specification
import play.Logger

trait PdfContentMatchingSpec extends Specification{

  def deletAndGeneratePDF(pdfFileLocation: String, xml: Elem) = {
    deleteFile(pdfFileLocation)
    generatePDF(pdfFileLocation, xml)
  }

  def testOutputFileExists(pdfFileLocation: String, xml: Elem) = {
    deletAndGeneratePDF(pdfFileLocation, xml)
    val pdfFile = new File(pdfFileLocation)
    pdfFile.exists() must beTrue
  }

  def getPDFContent(pdfFileLocation: String): String = {

    val reader = new com.itextpdf.text.pdf.PdfReader(pdfFileLocation)

    val parser = new PdfReaderContentParser(reader)

    val content: Seq[String] = for (i <- 1 to reader.getNumberOfPages) yield {
      val strategy = parser.processContent(i, new SimpleTextExtractionStrategy())

      strategy.getResultantText
    }
    reader.close()

    content.mkString.toLowerCase.replaceAll("\n", " ")
  }

  def foundMustBeTrue(testData: Seq[String], totalContent: String) = {
    testData.forall(x => {
      Logger.trace(s"x : $x")
      val found = totalContent.toLowerCase.contains(x.toLowerCase)
      if (!found) {
        Logger.debug("TotalContent " + totalContent)
        Logger.debug("*** Cannot find: " + x.toLowerCase)
        Logger.debug("*** End ***")
      }
      found
    })
  }

  def testContentMatches(pdfFileLocation: String,
                         testCaseXml: Elem,
                         generateTestData: (Elem => Seq[String]),
                         matchFunction: ((Seq[String], String) => Boolean)) = {
    testOutputFileExists(pdfFileLocation, testCaseXml)
    val totalContent = getPDFContent(pdfFileLocation)
    val testData = generateTestData(testCaseXml)
    matchFunction(testData, totalContent) must beTrue
    //deleteFile(pdfFileLocation)
  }
}
