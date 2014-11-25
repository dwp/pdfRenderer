package test_data.v5

import scala.xml.Elem


case class SectionPart2AboutYourPartner(xml: Elem) {

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Partner"

  val otherSurnameOrMaidenName = rootPath \\ "OtherSurnames"

  val dateOfBirth = rootPath \\ "DateOfBirth"

  val nationalityPartner = rootPath \\ "NationalityPartner"

  val seperatedFromPartnerQuestion = rootPath \\ "RelationshipStatus" \\ "SeparatedFromPartner" \\ "QuestionLabel"

  val seperatedFromPartnerAnswer = rootPath \\ "RelationshipStatus" \\ "SeparatedFromPartner" \\ "Answer"

  val isCareeQuestion = rootPath \\ "IsCaree" \\ "QuestionLabel"

  val isCareeAnswer = rootPath \\ "IsCaree" \\ "Answer"
}
