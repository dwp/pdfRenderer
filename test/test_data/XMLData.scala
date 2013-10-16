package test_data

import scala.xml.Elem


object XMLData {

  def functionalTestCase9(xml:Elem) = {
     Seq (
       "Transaction: "+(xml \\ "DWPCATransaction" \\ "TransactionId").text,
       (xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Claimant" \\ "Title").text + " "+(xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Claimant" \\ "Surname").text,
       "Last name "+(xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Claimant" \\ "Surname").text
     )
  }
}
