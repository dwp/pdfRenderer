package test_data.v20

import scala.xml.Elem


case class SectionPart2AboutYourPartner(xml: Elem) {

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Partner"

  val otherSurnameOrMaidenName = rootPath \\ "OtherSurnames"

  val dateOfBirthQuestion = rootPath \ "DateOfBirth" \ "QuestionLabel"

  val dateOfBirthAnswer = rootPath \ "DateOfBirth" \ "Answer"

  val nationalityPartnerQuestion = rootPath \"NationalityPartner" \ "QuestionLabel"

  val nationalityPartnerAnswer = rootPath \ "NationalityPartner" \ "Answer"

  val seperatedFromPartnerQuestion = rootPath \\ "RelationshipStatus" \\ "SeparatedFromPartner" \\ "QuestionLabel"

  val seperatedFromPartnerAnswer = rootPath \\ "RelationshipStatus" \\ "SeparatedFromPartner" \\ "Answer"

  val isCareeQuestion = rootPath \\ "IsCaree" \\ "QuestionLabel"

  val isCareeAnswer = rootPath \\ "IsCaree" \\ "Answer"

  val parnerNINOAnswer = rootPath \\ "Partner" \\ "NationalInsuranceNumber" \\ "Answer"

  val parnerNINOQuestion = rootPath \\ "Partner" \\ "NationalInsuranceNumber" \\ "QuestionLabel"

  val partnerSurnameAnswer = rootPath \\ "Partner" \\ "Surname" \\ "Answer"

  val partnerSurnameQuestion = rootPath \\ "Partner" \\ "Surname" \\ "QuestionLabel"

  val partnerOtherNamesAnswer = rootPath \\ "Partner" \\ "OtherNames" \\ "Answer"

  val partnerOtherNamesQuestion = rootPath \\ "Partner" \\ "OtherNames" \\ "QuestionLabel"

  val partnerMiddleNamesAnswer = rootPath \\ "Partner" \\ "MiddleNames" \\ "Answer"

  val partnerMiddleNamesQuestion = rootPath \\ "Partner" \\ "MiddleNames" \\ "QuestionLabel"

  val partnerTitleAnswer = rootPath \\ "Partner" \\ "Title" \\ "Answer"

  val partnerTitleQuestion = rootPath \\ "Partner" \\ "Title" \\ "QuestionLabel"

  val partnerOtherSurnamesAnswer = rootPath \\ "Partner" \\ "OtherSurnames" \\ "Answer"

  val partnerOtherSurnamesQuestion = rootPath \\ "Partner" \\ "OtherSurnames" \\ "QuestionLabel"


}
