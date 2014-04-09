package generators

import play.api.test.WithApplication
import scala.xml.XML
import test_data.circs.XMLCircsData


class PdfContentMatchingCircsSpec extends PdfContentMatchingSpec{

  "PdfCircsContentMatching" should {

    "extract PDF for functionalTestCase1 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase1_circs_contentTestPDF.pdf"
      val source = getClass.getResource("/c3_functional1_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestCase1, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase2 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase2_circs_contentTestPDF.pdf"
      val source = getClass.getResource("/c3_functional2_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestCase2, foundMustBeTrue)
    }

  }

}
