package test_data

import scala.xml.Elem


case class SectionAboutTheCareYouProvide(xml: Elem) {

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Caree"

  val nationalInsuranceNumber = rootPath \\ "NationalInsuranceNumber"

  val dateOfBirth = rootPath \\ "DateOfBirth"

  val liveSameAddressQuestion = rootPath \\ "LiveSameAddress" \\ "QuestionLabel"

  val liveSameAddressAnswer = rootPath \\ "LiveSameAddress" \\ "Answer"

}
