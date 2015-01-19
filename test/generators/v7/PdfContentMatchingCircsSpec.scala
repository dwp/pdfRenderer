package generators.v7

import generators.PdfContentMatchingSpec
import play.api.test.WithApplication
import test_data.v7.circs.XMLCircsData

import scala.xml.XML

/**
 * Tests to verify the creation of pdf file for Circs from the Jasper Template based on the version
 * and match the content of the xml data with the data in the pdf file.
 */

class PdfContentMatchingCircsSpec extends PdfContentMatchingSpec{

  val version = "0.7"

  "PdfCircsContentMatching" should {

    "extract PDF for functionalTestCase1 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase1_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional1_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestCase1, foundMustBeTrue)
    }

    // Stopped Caring
    "extract PDF for functionalTestCase2 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase2_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional2_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestCase2, foundMustBeTrue)
    }

    // Stopped Caring without Other changes
    "extract PDF for functionalTestCase3 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase3_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional3_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestCase2, foundMustBeTrue)
    }

    // Self employed section
    "extract PDF for functionalTestCase4 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase4_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional4_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataSelfEmployed, foundMustBeTrue)
    }

    // Self employed section with Caring35Hours 'Yes' without Other Changes
    "extract PDF for functionalTestCase5 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase5_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional5_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataSelfEmployed, foundMustBeTrue)
    }

    // Self employed section with DateStoppedCaring35Hours
    "extract PDF for functionalTestCase6 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase6_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional6_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataSelfEmployed, foundMustBeTrue)
    }

    // Self employed section with Caring35Hours 'No' and without Other Changes
    "extract PDF for functionalTestCase7 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase7_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional7_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataSelfEmployed, foundMustBeTrue)
    }

    // Self employed section with 'more than £100 a week' answered 'No'
    "extract PDF for functionalTestCase8 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase8_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional8_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataSelfEmployed, foundMustBeTrue)
    }

    // Self employed section with 'more than £100 a week' answered 'dontKnow'
    "extract PDF for functionalTestCase9 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase9_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional9_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataSelfEmployed, foundMustBeTrue)
    }

    // Payment Details section
    "extract PDF for functionalTestCase10 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase10_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional10_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataPaymentBankDetails, foundMustBeTrue)
    }

    /**
     * The following tests with different values for 'Whose Name Account In' would have made sense if we had enumeration for
     * that field. Please delete the different versions if it becomes a problem with maintainance
     */

    // Payment Details section with 'Whose Name Account In' = 'Your partner's name'
    "extract PDF for functionalTestCase11 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase11_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional11_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataPaymentBankDetails, foundMustBeTrue)
    }

    // Payment Details section with 'Whose Name Account In' = 'Both you and your partner'
    "extract PDF for functionalTestCase12 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase12_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional12_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataPaymentBankDetails, foundMustBeTrue)
    }

    // Payment Details section with 'Whose Name Account In' = 'Person acting on your behalf'
    "extract PDF for functionalTestCase13 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase13_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional13_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataPaymentBankDetails, foundMustBeTrue)
    }

    // Payment Details section with 'Roll number' and 'more about your changes'
    "extract PDF for functionalTestCase20 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase20_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional20_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataPaymentBankDetails, foundMustBeTrue)
    }

    // Payment Details section with 'Are you currently paid into a bank or building society' answered 'yes'
    "extract PDF for functionalTestCase21 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase21_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional21_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataPaymentBankDetails, foundMustBeTrue)
    }

    // Payment Details section with 'Are you currently paid into a bank or building society' answered 'no'
    "extract PDF for functionalTestCase28 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase28_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional28_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataPaymentBankDetails, foundMustBeTrue)
    }

    // Breaks in care section without 'Somewhere else'
    "extract PDF for functionalTestCase22 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase22_BreaksInCare_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional22_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataBreaksInCareChangeDetails, foundMustBeTrue)
    }

    // Breaks in care section with 'Somewhere else'
    "extract PDF for functionalTestCase23 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase23_BreaksInCare_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional23_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataBreaksInCareChangeDetails, foundMustBeTrue)
    }

    // Breaks in care section with 'permanent break date'
    "extract PDF for functionalTestCase24 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase24_BreaksInCare_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional24_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataBreaksInCareChangeDetails, foundMustBeTrue)
    }

    // Address Details section with 'is Same Address' 'no'
    "extract PDF for functionalTestCase25 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase25_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional25_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataAddressChangeDetails, foundMustBeTrue)
    }

    // Address Details section with 'is Same Address' 'yes'
    "extract PDF for functionalTestCase26 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase26_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional26_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataAddressChangeDetails, foundMustBeTrue)
    }

    // Address Details section with 'Tell us more about your changes' answered
    "extract PDF for functionalTestCase27 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase27_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional27_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataAddressChangeDetails, foundMustBeTrue)
    }

    // Other changes
    "extract PDF for functionalTestCase29 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase30_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional30_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.functionalTestDataOtherDetails, foundMustBeTrue)
    }

    // Employment : Finished employment : Have you received your last pay - yes
    "extract PDF for functionalTestCase31 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase31_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional31_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.finishedEmployment, foundMustBeTrue)
    }

    // Employment : Finished employment : Have you received your last pay - no
    "extract PDF for functionalTestCase32 and match contents" in new WithApplication{
      val pdfFileLocation = s"${version}_functionalTestCase32_circs_contentTestPDF.pdf"
      val source = getClass.getResource(s"/${version}/circs/c3_functional32_circs.xml")
      val textCaseXml = XML.load(source)
      testContentMatches(pdfFileLocation, textCaseXml, XMLCircsData.finishedEmployment, foundMustBeTrue)
    }

  }
}
