package test_data

import scala.xml.Elem


object XMLData {

  def functionalTestCase9(xml:Elem) = {
     Seq (
       "Last name "+(xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Claimant" \\ "Surname").text
     )
  }
}
