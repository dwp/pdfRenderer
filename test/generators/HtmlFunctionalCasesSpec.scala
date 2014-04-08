package generators

import play.api.test.WithApplication
import scala.xml.XML
import generators.Helper._
import org.specs2.mutable.Specification


/**
 * Created by jmi on 07/04/2014.
 */
class HtmlFunctionalCasesSpec extends Specification {

  "The HTML generator should generate HTML from C3" should {
    "Claim Functional cases" in new WithApplication {
      for (i <- 1 to 10) {
        val fileLocation = s"functionalTestCase${i}_testGeneratorResultIsSuccess.html"
        val source = getClass.getResource(s"/c3_functional$i.xml")
        deleteFile(fileLocation)
        generateHTML(fileLocation, XML.load(source))
      }
    }

    "Change of circumstances Functional cases" in new WithApplication {
      for (i <- 1 to 1) {
        val fileLocation = s"functionalTestCase${i}_circs_testGeneratorResultIsSuccess.html"
        val source = getClass.getResource(s"/c3_functional${i}_circs.xml")
        deleteFile(fileLocation)
        generateHTML(fileLocation, XML.load(source))
      }
    }
  }

}
