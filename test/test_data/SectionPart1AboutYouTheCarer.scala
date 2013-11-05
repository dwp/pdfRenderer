package test_data

import scala.xml.Elem


case class SectionPart1AboutYouTheCarer(xml: Elem) {

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Claimant"

  val title = rootPath \\ "Title"

  val firstName = rootPath  \\ "OtherNames"

  val lastName = rootPath  \\ "Surname"

  val address = (rootPath \\ "Address" \\ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString("\n")

  val postCode = rootPath \\ "Address" \\ "PostCode"


}
