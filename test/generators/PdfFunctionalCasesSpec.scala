package generators

import utils.WithApplication
import test_data.XMLData
import scala.xml.XML


/**
 * Use output of C3 functional tests to test the PDF Generator.
 *
 */
class PdfFunctionalCasesSpec extends PdfSpecification {

  val version = XMLData.LATEST_VERSION // change this to the next version when you remove 0.1 example to 0.2

  "The PDF generator should generate PDF from C3" should {
    "Claim Functional cases" in new WithApplication {
      for (i <- 1 to 15) {
        val pdfFileLocation = s"functionalTestCase${i}_testGeneratorResultIsSuccess.pdf"
        val source = getClass.getResource(s"/$version/claim/c3_functional$i.xml")
        testGeneratorResultIsSuccess(pdfFileLocation, XML.load(source))
      }
    }

    "Change of circumstances Functional cases" in new WithApplication {
      for (i <- 1 to 9) {
        val pdfFileLocation = s"functionalTestCase${i}_circs_testGeneratorResultIsSuccess.pdf"
        val source = getClass.getResource(s"/$version/circs/c3_functional${i}_circs.xml")
        testGeneratorResultIsSuccess(pdfFileLocation, XML.load(source))
      }
    }
  }
}
