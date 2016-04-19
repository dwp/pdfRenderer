package test_data.v23

import scala.xml.Elem

case class SectionPart1AboutYouTheCarer(xml: Elem) {

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim"

  val rootPathClaimant = rootPath \\ "Claimant"

  val rootPathResidency = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Residency"

  val titleAnswer = rootPathClaimant \\ "Title" \\ "Answer"

  val titleQuestion = rootPathClaimant \\ "Title" \\ "QuestionLabel"

  val firstNameAnswer = rootPathClaimant  \\ "OtherNames" \\ "Answer"

  val firstNameQuestion = rootPathClaimant  \\ "OtherNames" \\ "QuestionLabel"

  val lastNameAnswer = rootPathClaimant  \\ "Surname" \\ "Answer"

  val lastNameQuestion = rootPathClaimant  \\ "Surname" \\ "QuestionLabel"

  val claimantMiddleNameAnswer = rootPathClaimant \\ "Claimant" \\ "MiddleNames" \\ "Answer"

  val claimantMiddleNamesQuestion = rootPathClaimant \\ "Claimant" \\ "MiddleNames" \\ "QuestionLabel"

  val otherSurnameOrMaidenName = rootPathClaimant  \\ "OtherSurnames"

  val nationalInsuranceNumberAnswer = rootPathClaimant \\ "Claimant" \\ "NationalInsuranceNumber" \\ "Answer"

  val nationalInsuranceNumberQuestion = rootPathClaimant \\ "Claimant" \\ "NationalInsuranceNumber" \\ "QuestionLabel"

  val dateOfBirthQuestion = rootPathClaimant \\ "DateOfBirth" \\ "QuestionLabel"

  val dateOfBirthAnswer = rootPathClaimant \\ "DateOfBirth" \\ "Answer"

  val maritalStatusQuestion =	rootPathClaimant \\ "MaritalStatus" \\ "QuestionLabel"

  val maritalStatusAnswer =	rootPathClaimant \\ "MaritalStatus" \\ "Answer"

  val dayTimeTelephoneNumberAnswer = rootPathClaimant \\ "DayTimePhoneNumber" \\ "Answer"

  val dayTimeTelephoneNumberQuestion	= rootPathClaimant \\ "DayTimePhoneNumber" \\ "QuestionLabel"

  val speechOrHearingDifficultyQuestion = rootPathClaimant \\ "TextPhoneContact" \\ "QuestionLabel"

  val speechOrHearingDifficultyAnswer = rootPathClaimant \\ "TextPhoneContact" \\ "Answer"

  val nationalityAnswer =  rootPathResidency \\ "Nationality" \\ "Answer"

  val nationalityQuestion =  rootPathResidency \\ "Nationality" \\ "QuestionLabel"

  val doYouLiveEnglandScotlandWalesQuestion = rootPathResidency \\ "NormallyLiveInGB" \\ "QuestionLabel"

  val doYouLiveEnglandScotlandWalesAnswer = rootPathResidency \\ "NormallyLiveInGB" \\ "Answer"

  val countryNormallyLiveInQuestion = rootPathResidency \\ "CountryNormallyLive" \\ "QuestionLabel"

  val countryNormallyLiveInAnswer = rootPathResidency \\ "CountryNormallyLive" \\ "Answer"

  val timeOutsideGBLast3YearsQuestion = rootPathResidency \\ "TimeOutsideGBLast3Years" \\ "QuestionLabel"

  val timeOutsideGBLast3YearsAnswer = rootPathResidency \\ "TimeOutsideGBLast3Years" \\ "Answer"

  val cared35HoursBeforeQuestion = rootPathClaimant \\ "Cared35HoursBefore" \\ "QuestionLabel"

  val cared35HoursBeforeAnswer = rootPathClaimant \\ "Cared35HoursBefore" \\ "Answer"

  val dateStartedCaringQuestion = rootPathClaimant \\ "DateStartCaring" \\ "QuestionLabel"

  val dateStartedCaringAnswer = rootPathClaimant \\ "DateStartCaring" \\ "Answer"

  val addressCarerAnswer = (rootPath \\ "Claimant" \\ "Address" \\ "Answer" \\ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val postCodeCarer = rootPath \\ "Claimant" \\ "Address" \\ "PostCode"

  val reasonTimeAbroadOther = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Residency" \\ "Reason" \\ "Other"

  val havePartnerQuestion = rootPath \\ "HavePartner" \\ "QuestionLabel"

  val havePartnerAnswer = rootPath \\ "HavePartner" \\ "Answer"

}
