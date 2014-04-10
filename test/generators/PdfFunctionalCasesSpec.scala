package generators

import play.api.test.WithApplication
import scala.xml.XML


/**
 * Use output of C3 functional tests to test the PDF Generator.
 * @author Jorge Migueis
 */
class PdfFunctionalCasesSpec extends PdfSpecification {

  "The PDF generator should generate PDF from C3" should {
    "Claim Functional cases" in new WithApplication {
      for (i <- 1 to 10) {
        val pdfFileLocation = s"functionalTestCase${i}_testGeneratorResultIsSuccess.pdf"
        val source = getClass.getResource(s"/c3_functional$i.xml")
        testGeneratorResultIsSuccess(pdfFileLocation, XML.load(source))
      }
    }

    "Change of circumstances Functional cases" in new WithApplication {
      for (i <- 1 to 9) {
        val pdfFileLocation = s"functionalTestCase${i}_circs_testGeneratorResultIsSuccess.pdf"
        val source = getClass.getResource(s"/circs/c3_functional${i}_circs.xml")
        testGeneratorResultIsSuccess(pdfFileLocation, XML.load(source))
      }
    }
  }
}
