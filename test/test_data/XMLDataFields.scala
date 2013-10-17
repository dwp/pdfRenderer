package test_data

import scala.xml.Elem


case class XMLDataFields(xml:Elem) {

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim"

  val transactionPath = (xml \\ "DWPCATransaction" \\ "TransactionId")

  val title = (rootPath \\ "Claimant" \\ "Title")

  val surName = (rootPath \\ "Claimant" \\ "Surname")

  val nationalInsuranceNumber = (rootPath \\ "Claimant" \\ "NationalInsuranceNumber")

  val firstName = (rootPath \\ "Claimant" \\ "OtherNames")

  val careeLastName = (rootPath \\ "Caree" \\ "Surname")

  val careeFirstName = (rootPath \\ "Caree" \\ "OtherNames")

  val careeTitle = (rootPath \\ "Caree" \\ "Title")

  val dateClaimReceived = (xml \\ "DWPCATransaction" \\ "DateTimeGenerated")

  val addressCarer = (rootPath \\ "Claimant" \\ "Address" \\ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString("\n")

  val postCodeCarer = (rootPath \\ "Claimant" \\ "Address" \\ "PostCode")

  val addressCaree = (rootPath \\ "Caree" \\ "Address" \\ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString("\n")

  val postCodeCaree = (rootPath \\ "Caree" \\ "Address" \\ "PostCode")

}
