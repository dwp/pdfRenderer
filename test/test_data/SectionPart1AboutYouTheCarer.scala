package test_data

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

  val otherSurnameOrMaidenName = rootPathClaimant  \\ "OtherSurnames"

  val nationalInsuranceNumber	= rootPathClaimant  \\ "NationalInsuranceNumber"

  val dateOfBirth = rootPathClaimant \\ "DateOfBirth"

  val maritalStatus =	rootPathClaimant \\ "MaritalStatus"

  val dateOfClaimQuestion = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "DateOfClaim" \\ "QuestionLabel"

  val dateOfClaimAnswer = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "DateOfClaim" \\ "Answer"

  val address = (rootPathClaimant \\ "Address" \\ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val postCode = rootPathClaimant \\ "Address" \\ "PostCode"

  val dayTimeTelephoneNumber	= rootPathClaimant \\ "DayTimePhoneNumber"

  val mobileNumber = rootPathClaimant \\ "MobileNumber"

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

  val periodAbroadDateFromQuestion = rootPathResidency \\ "PeriodAbroad" \\ "Period" \\ "DateFrom" \\ "QuestionLabel"

  val periodAbroadDateFromAnswer = rootPathResidency \\ "PeriodAbroad" \\ "Period" \\ "DateFrom" \\ "Answer"

  val periodAbroad1: Seq[String] = {
    (rootPathResidency \\ "PeriodAbroad"
      map (y =>
          (y \\ "Period").
            map(x => {
              Seq((x \\ "DateFrom" \\ "QuestionLabel").text+" "+(x \\ "DateFrom" \\ "Answer").text,
              (x \\ "DateTo" \\ "QuestionLabel").text+" "+(x \\ "DateTo" \\ "Answer").text)
          }).flatten ++
          (y \\ "Reason").
              map(x => {
                  Seq((x \\ "QuestionLabel").text+" "+
                    (x \\ "Answer").text match {
                      case "Other" => (x \\ "Other").text +" "+ (x \\ "Answer").text
                      case _ => (x \\ "Answer").text
                  })
          }).flatten ++
          (y \\ "Country").
            map(x => {
              Seq((x \\ "QuestionLabel").text+" "+(x \\ "Answer").text)
          }).flatten ++
          (y \\ "CareePresent").
            map(x => {
              Seq((x \\ "QuestionLabel").text+" "+(x \\ "Answer").text)
          }).flatten
        )
      ).flatten
  }

  val periodAbroad: Seq[String] = {
    (rootPathResidency \\ "PeriodAbroad"
      map (y =>
        (y \\ "Period").
          map(x => {
          Seq((x \\ "DateFrom" \\ "QuestionLabel").text+" "+(x \\ "DateFrom" \\ "Answer").text,
            (x \\ "DateTo" \\ "QuestionLabel").text+" "+(x \\ "DateTo" \\ "Answer").text)
        }).flatten ++
        (y \\ "Reason").map(x => {(x \\ "Answer").text match {
                                   //case "Other" => Seq((x \\ "QuestionLabel").text+" "+(x \\ "Other").text +" "+ (x \\ "Answer").text)
                                   case _ => Seq((x \\ "QuestionLabel").text+" "+(x \\ "Answer").text)
                                 }}).flatten ++
        (y \\ "Country").map(x => (x \\ "QuestionLabel").text+" "+(x \\ "Answer").text) ++
        (y \\ "CareePresent").map(x => (x \\ "QuestionLabel").text+" "+(x \\ "Answer").text)
      )
      ).flatten
  }

  val receiveEEAPensionsBenefitsQuestion = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAReceivePensionsBenefits" \\ "QuestionLabel"

  val receiveEEAPensionsBenefitsAnswer = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAReceivePensionsBenefits" \\ "Answer"

  val claimEEAPensionsBenefitsQuestion = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAClaimPensionsBenefits" \\ "QuestionLabel"

  val claimEEAPensionsBenefitsAnswer = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAClaimPensionsBenefits" \\ "Answer"

  val workingEEAInsuranceQuestion = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAWorkingInsurance" \\ "QuestionLabel"

  val workingEEAInsuranceAnswer = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAWorkingInsurance" \\ "Answer"

  val havePartnerQuestion = rootPath \\ "HavePartner" \\ "QuestionLabel"

  val havePartnerAnswer = rootPath \\ "HavePartner" \\ "Answer"

  val courseOfEducationQuestion = rootPath \\ "CourseOfEducation" \\ "QuestionLabel"

  val courseOfEducationAnswer = rootPath \\ "CourseOfEducation" \\ "Answer"

  val statePensionQuestion = rootPath \\ "OtherBenefits" \\ "ClaimantBenefits" \\ "StatePension" \\ "QuestionLabel"

  val statePensionAnswer = rootPath \\ "OtherBenefits" \\ "ClaimantBenefits" \\ "StatePension" \\ "Answer"

  val employedQuestion = rootPath \\ "Employed" \\ "QuestionLabel"

  val employedAnswer = rootPath \\ "Employed" \\ "Answer"

  val selfEmployedQuestion = rootPath \\ "SelfEmployed" \\ "QuestionLabel"

  val selfEmployedAnswer = rootPath \\ "SelfEmployed" \\ "Answer"
}