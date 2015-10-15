package generators.v19

import generators.PdfContentMatchingSpec
import play.api.test.WithApplication
import test_data.v19.XMLData

import scala.xml.XML


/**
 * Tests to verify the creation of pdf file for Circs from the Jasper Template based on the version
 * and match the content of the xml data with the data in the pdf file.
 *
 */

class PdfContentMatchingClaimSpec extends PdfContentMatchingSpec {

  val version = "0.19"

  "PdfContentMatching" should {

    "extract PDF for functionalTestCase1 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase1_contentTestPDF.pdf"
      val source = getClass.getResource(s"/$version/claim/c3_functional1.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase1, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase2 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase2_contentTestPDF.pdf"
      val source = getClass.getResource(s"/$version/claim/c3_functional2.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase2, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase3 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase3_contentTestPDF.pdf"
      val source = getClass.getResource(s"/$version/claim/c3_functional3.xml")
      val textCaseXml = XML.load(source)

      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase3, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase4 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase4_contentTestPDF.pdf"
      val source = getClass.getResource(s"/$version/claim/c3_functional4.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase4, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase5 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase5_contentTestPDF.pdf"
      val source = getClass.getResource(s"/$version/claim/c3_functional5.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase5, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase6 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase6_contentTestPDF.pdf"
      val source = getClass.getResource(s"/$version/claim/c3_functional6.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase6, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase7 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase7_contentTestPDF.pdf"
      val source = getClass.getResource(s"/$version/claim/c3_functional7.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase7, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase8 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase8_contentTestPDF.pdf"
      val source = getClass.getResource(s"/$version/claim/c3_functional8.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase8, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase9 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase9_contentTestPDF.pdf"
      val source = getClass.getResource(s"/$version/claim/c3_functional9.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase9, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase10 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase10_contentTestPDF.pdf"
      val source = getClass.getResource(s"/$version/claim/c3_functional10.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase10, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase11 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase11_contentTestPDF.pdf"
      val source = getClass.getResource(s"/$version/claim/c3_functional11.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase11, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase12 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase12_contentTestPDF.pdf"
      val source = getClass.getResource(s"/$version/claim/c3_functional12.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase12, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase13 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase13_contentTestPDF.pdf"
      val source = getClass.getResource(s"/$version/claim/c3_functional13.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase13, foundMustBeTrue)
    }

   "extract PDF for functionalTestCase14 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase14_contentTestPDF.pdf"
      val source = getClass.getResource(s"/$version/claim/c3_functional14.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase14, foundMustBeTrue)
    }

    "extract PDF for functionalTestCase15 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase15_contentTestPDF.pdf"
      val source = getClass.getResource(s"/$version/claim/c3_functional15.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLData.functionalTestCase15, foundMustBeTrue)
    }
  }
}

