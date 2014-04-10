package generators

import play.api.test.WithApplication
import scala.xml.XML
import test_data.circs.XMLCircsData


class PdfContentMatchingCircsSpec extends PdfContentMatchingSpec{

  "PdfCircsContentMatching" should {

    "extract PDF for functionalTestCase1 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase1_circs_contentTestPDF.pdf"
      val source = getClass.getResource("/circs/c3_functional1_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestCase1, foundMustBeTrue)
    }

    // Stopped Caring
    "extract PDF for functionalTestCase2 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase2_circs_contentTestPDF.pdf"
      val source = getClass.getResource("/circs/c3_functional2_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestCase2, foundMustBeTrue)
    }

    // Stopped Caring without Other changes
    "extract PDF for functionalTestCase3 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase3_circs_contentTestPDF.pdf"
      val source = getClass.getResource("/circs/c3_functional3_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestCase2, foundMustBeTrue)
    }

    // Self employed section
    "extract PDF for functionalTestCase4 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase4_circs_contentTestPDF.pdf"
      val source = getClass.getResource("/circs/c3_functional4_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataSelfEmployed, foundMustBeTrue)
    }

    // Self employed section with Caring35Hours 'Yes' without Other Changes
    "extract PDF for functionalTestCase5 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase5_circs_contentTestPDF.pdf"
      val source = getClass.getResource("/circs/c3_functional5_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataSelfEmployed, foundMustBeTrue)
    }

    // Self employed section with DateStoppedCaring35Hours
    "extract PDF for functionalTestCase6 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase6_circs_contentTestPDF.pdf"
      val source = getClass.getResource("/circs/c3_functional6_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataSelfEmployed, foundMustBeTrue)
    }

    // Self employed section with Caring35Hours 'No' and without Other Changes
    "extract PDF for functionalTestCase7 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase7_circs_contentTestPDF.pdf"
      val source = getClass.getResource("/circs/c3_functional7_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataSelfEmployed, foundMustBeTrue)
    }

    // Self employed section with 'more than £100 a week' answered 'No'
    "extract PDF for functionalTestCase8 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase8_circs_contentTestPDF.pdf"
      val source = getClass.getResource("/circs/c3_functional8_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataSelfEmployed, foundMustBeTrue)
    }

    // Self employed section with 'more than £100 a week' answered 'dontKnow'
    "extract PDF for functionalTestCase9 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase9_circs_contentTestPDF.pdf"
      val source = getClass.getResource("/circs/c3_functional9_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataSelfEmployed, foundMustBeTrue)
    }
  }

}
