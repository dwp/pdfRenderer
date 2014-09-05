package helpers

import org.specs2.mutable.{Tags, Specification}

import scala.xml.XML

/**
 * Created by jmi on 04/09/2014.
 */
class VersionExtractorSpec extends Specification with Tags {

  "The helper" should {
    "Extract version from valid XML" in {
      val xml = XML.load(getClass getResource "/c3_functional1.xml")
      VersionExtractor.extractVersionFrom(xml).get mustEqual "0.1"
    }
    "Not extract invalid version" in {
      var xml = <DWPBody><Version>3ksdjfalk</Version></DWPBody>
      VersionExtractor.extractVersionFrom(xml) mustEqual  None
      xml = <DWPBody><TransactionId>"1212ASAS12D"</TransactionId></DWPBody>
      VersionExtractor.extractVersionFrom(xml) mustEqual  None
      xml = <DWPBody><Version>1.2a</Version></DWPBody>
      VersionExtractor.extractVersionFrom(xml) mustEqual  None
    }
  } section "unit"

}