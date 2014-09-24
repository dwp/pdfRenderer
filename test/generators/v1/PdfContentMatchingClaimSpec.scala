package generators.v1

import test_data.XMLData
import scala.xml.XML
import play.api.test.WithApplication
import generators.PdfContentMatchingSpec


/**
 * Tests to verify the creation of pdf file for Circs from the Jasper Template based on the version
 * and match the content of the xml data with the data in the pdf file.
 *
 */
class PdfContentMatchingClaimSpec extends PdfContentMatchingSpec {

  val version = "/0.1"

  "PdfContentMatching" should {

    /*
    "extract PDF for badClaim fails to match contents" in {
      val pdfFileLocation = "badClaim_contentTestPDF.pdf"
      testContentMatches(pdfFileLocation, ClaimBuilder.functionalTestCase9, XMLData.madeUpField, foundMustBeFalse)
    }*/

    /**
     * Theses should be differnt test cases
     *
    "extract PDF for functionalTestCase and match contents" in new WithApplication{
      for (i <- 1 to 9) {
        val pdfFileLocation = s"functionalTestCase${i}_contentTestPDF.pdf"
        val source = getClass.getResource(s"/c3_functional$i.xml")
        val textCaseXml = XML.load(source)
        i match { // TODO : Needs refactoring
          case 1 => testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase1, foundMustBeTrue)
          case 2 => testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase2, foundMustBeTrue)
          case 3 => testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase3, foundMustBeTrue)
          case 4 => testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase4, foundMustBeTrue)
          case 5 => testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase5, foundMustBeTrue)
          case 6 => testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase6, foundMustBeTrue)
          case 7 => testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase7, foundMustBeTrue)
          case 8 => testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase8, foundMustBeTrue)
          case 9 => testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase9, foundMustBeTrue)
          case 10 => testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase10, foundMustBeTrue)
        }
      }

    } */


    "extract PDF for functionalTestCase1 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase1_contentTestPDF.pdf"
      val source = getClass.getResource(s"$version/claim/c3_functional1.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase1, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase2 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase2_contentTestPDF.pdf"
      val source = getClass.getResource(s"$version/claim/c3_functional2.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase2, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase3 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase3_contentTestPDF.pdf"
      val source = getClass.getResource(s"$version/claim/c3_functional3.xml")
      val textCaseXml = XML.load(source)

      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase3, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase4 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase4_contentTestPDF.pdf"
      val source = getClass.getResource(s"$version/claim/c3_functional4.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase4, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase5 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase5_contentTestPDF.pdf"
      val source = getClass.getResource(s"$version/claim/c3_functional5.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase5, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase6 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase6_contentTestPDF.pdf"
      val source = getClass.getResource(s"$version/claim/c3_functional6.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase6, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase7 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase7_contentTestPDF.pdf"
      val source = getClass.getResource(s"$version/claim/c3_functional7.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase7, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase8 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase8_contentTestPDF.pdf"
      val source = getClass.getResource(s"$version/claim/c3_functional8.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase8, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase9 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase9_contentTestPDF.pdf"
      val source = getClass.getResource(s"$version/claim/c3_functional9.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase9, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase10 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase10_contentTestPDF.pdf"
      val source = getClass.getResource(s"$version/claim/c3_functional10.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase10, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase11 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase11_contentTestPDF.pdf"
      val source = getClass.getResource(s"$version/claim/c3_functional11.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase11, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase12 and match contents" in new WithApplication{
      val pdfFileLocation = "functionalTestCase12_contentTestPDF.pdf"
      val source = getClass.getResource(s"$version/claim/c3_functional12.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase12, foundMustBeTrue)
    }
  }
}

