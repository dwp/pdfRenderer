package generators.v9

import generators.Helper._
import org.specs2.mutable.Specification
import play.api.test.WithApplication

import scala.xml.XML


/**
 * Tests to verify the generation of HTML
 *
 *
 */
class HtmlFunctionalCasesSpec extends Specification {

  val version = "/0.9"

  "The HTML generator should generate HTML from C3" should {
    "Claim Functional cases" in new WithApplication {
        for (i <- 1 to 15) {
          val fileLocation = s"functionalTestCase${i}_testGeneratorResultIsSuccess.html"
          val source = getClass.getResource(s"$version/claim/c3_functional$i.xml")
          deleteFile(fileLocation)
          generateHTML(fileLocation, XML.load(source))
        }
    }

    "Change of circumstances Functional cases" in new WithApplication {
      for (i <- 1 to 13) {
        val fileLocation = s"functionalTestCase${i}_circs_testGeneratorResultIsSuccess.html"
        val source = getClass.getResource(s"$version/circs/c3_functional${i}_circs.xml")
        deleteFile(fileLocation)
        generateHTML(fileLocation, XML.load(source))
      }

      for (i <- 20 to 28) {
        val fileLocation = s"functionalTestCase${i}_circs_testGeneratorResultIsSuccess.html"
        val source = getClass.getResource(s"$version/circs/c3_functional${i}_circs.xml")
        deleteFile(fileLocation)
        generateHTML(fileLocation, XML.load(source))
      }
    }
  }

}
