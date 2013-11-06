package test_data

import scala.xml.Elem


case class SectionPart2AboutYourPartner(xml: Elem) {

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Partner"

  val title = rootPath \\ "Title"

  val firstName = rootPath \\ "OtherNames"

  val lastName = rootPath \\ "Surname"

  val otherSurnameOrMaidenName = rootPath \\ "OtherSurnames"

  val nationalInsuranceNumber = rootPath \\ "NationalInsuranceNumber"

  val dateOfBirth = rootPath \\ "DateofBirth"

  val nationalityPartner = rootPath \\ "NationalityPartner"

  val seperatedFromPartnerQuestion = rootPath \\ "RelationshipStatus" \\ "SeperatedFromPartner" \\ "QuestionLabel"

  val seperatedFromPartnerAnswer = rootPath \\ "RelationshipStatus" \\ "SeperatedFromPartner" \\ "Answer"

  val isCareeQuestion = rootPath \\ "IsCaree" \\ "QuestionLabel"

  val isCareeAnswer = rootPath \\ "IsCaree" \\ "Answer"
}
