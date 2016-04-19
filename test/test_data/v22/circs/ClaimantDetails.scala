package test_data.v22.circs

import scala.xml.{Elem, NodeSeq}


sealed abstract class CircsUtils(rootPath: NodeSeq){

  def pathQuestionLabel (element:String) = {
    rootPath \ element \ "QuestionLabel"
  }

  def pathAnswer (element:String) = {
    rootPath \ element \ "Answer"
  }

  def pathOther (element:String) = {
    rootPath \ element \ "Other"
  }

  def pathQuestionLabelAnswer(element:String):(NodeSeq,NodeSeq) = {
    (pathQuestionLabel(element), pathAnswer(element))
  }

  def pathQuestionLabelAnswerOther(element:String):(NodeSeq,NodeSeq,NodeSeq) = {
    (pathQuestionLabel(element), pathAnswer(element), pathOther(element))
  }

  def prepareTestData(elements:Seq[String]) = {
     elements.map(e => pathQuestionLabelAnswer(e))
  }

  def prepareTestDataOther(elements:Seq[String]) = {
    elements.map(e => pathQuestionLabelAnswerOther(e))
  }

}

case class ClaimantDetails(xml: Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "ClaimantDetails"){
  val claimantDetails = prepareTestData(Seq("FullName","DateOfBirth","NationalInsuranceNumber","ContactPreference"))
}

case class CareeDetails(xml: Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "CareeDetails"){
  val careeDetailsData = prepareTestData(Seq("FullName","RelationToClaimant"))
}

case class StoppedCaring(xml: Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "StoppedCaring"){
  val stoppedCaringData = prepareTestData(Seq("DateStoppedCaring", "OtherChanges"))
}

case class SelfEmployment(xml:Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "SelfEmployedChange"){
  val selfEmploymentData = prepareTestData(Seq("Caring35Hours", "BusinessStartDate", "BusinessType", "MoreThan100", "OtherChanges","DateStoppedCaring35Hours"))
}

case class PaymentBankDetailsPaidIntoAccount(xml:Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "PaymentChange" \ "PaidIntoAccountDetails"){
  val paidIntoAccountData = prepareTestData(Seq("PaidIntoAccount", "BankName", "MethodOfPayment"))
}

case class PaymentBankDetailsAccountDetails(xml:Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "PaymentChange" \ "AccountDetails"){
  val accountDetailsData = prepareTestData(Seq("AccountHolder", "HolderName"))
}

case class PaymentBankDetailsBuildingSocietyDetails(xml:Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "PaymentChange" \  "AccountDetails" \ "BuildingSocietyDetails"){
  val buildingSocietyDetailsData = prepareTestData(Seq("AccountNumber", "RollNumber", "SortCode", "Name"))
}

case class DeclarationDetails(xml:Elem) {
  val declarationTitleContentPath = xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "Declaration" \  "DeclarationStatement"
  val declarationQuestionContentPath = xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "Declaration" \ "DeclarationQuestion"
}

case class DeclarationQuestionContentPath (xml:Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "Declaration"){
  val declarationNameOrOrgPath = prepareTestData(Seq("DeclarationNameOrg"))
}

case class ConsentsQuestionPath(xml:Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "Consents"){
  val consentsQuestionPath = prepareTestData(Seq("Consent", "\\ Consent \\ Why"))
}

case class ConsentsWhyQuestionPath(xml:Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "Consents" \ "Consent"){
  val consentsWhyQuestionPath = prepareTestData(Seq("Why"))
}

case class ChangeAddressDetails(xml:Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "AddressChange"){
  val previousAddressQuestion = (xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "AddressChange" \ "PreviousAddress" \ "QuestionLabel")
  val previousAddressAnswer = (xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "AddressChange" \ "PreviousAddress" \ "Answer" \ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")
  val newAddressQuestion = (xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "AddressChange" \ "NewAddress" \ "QuestionLabel")
  val newAddressAnswer = (xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "AddressChange" \ "NewAddress" \ "Answer" \ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")
  val personYouCareForAddressQuestion = (xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "AddressChange" \ "CareeAddress" \ "QuestionLabel")
  val personYouCareForAddressAnswer = (xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "AddressChange" \ "CareeAddress" \ "Answer" \ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")
  val changeAddressData = prepareTestData(Seq("Caring35Hours", "DateStoppedCaring35Hours", "CareeChangedAddress", "CareeSameAddress", "OtherChanges"))
}

case class BreaksInCareDetails(xml:Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "BreakFromCaring"){
  val wherePersonYouCareSomeWhereElse = (xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "BreakFromCaring" \ "WherePersonYouCare" \ "Other")
  val whereWereYouSomeWhereElse = (xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "BreakFromCaring" \ "WhereWereYou" \ "Other")
  val breaksInCareData = prepareTestData(Seq("RecentBreakStartDate", "RecentBreakStartTime", "WherePersonYouCare","WhereWereYou","MedicalTreatmentDuringBreak", "MoreChanges", "AdditionalBreaksNotReported","AdditionalBreaksNotReportedDesc"))
}

case class BreaksFromCaringEnded(xml:Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "BreakFromCaring" \ "BreakFromCaringEnded"){
  val breaksFromCaringEndedData = prepareTestData(Seq("HasBreakFromCaringEnded", "EndDate", "EndTime", "ExpectStartCaringAgain", "ExpectStartCaringAgainDate", "PermanentBreakDate"))
}

case class OtherChangesDetails(xml: Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances"){
  val otherChangesData = prepareTestData(Seq("OtherChanges"))
}

case class EmploymentChangeBasicDetails(xml: Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "EmploymentChange"){
  val basicChangesData = prepareTestData(Seq("StillCaring", "HasWorkStartedYet", "DateWorkedStarted", "HasWorkFinishedYet",
    "DateWorkedFinished", "TypeOfWork"))
}


case class FinishedEmploymentBasicDetails(xml: Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "EmploymentChange"){
  val basicChangesData = EmploymentChangeBasicDetails(xml: Elem).basicChangesData
}

case class FinishedEmploymentFurtherDetails(xml: Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "EmploymentChange" \ "StartedEmploymentAndFinished"){
  val employerAddressQuestion = (xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "EmploymentChange" \ "StartedEmploymentAndFinished" \ "Address" \ "QuestionLabel")
  val employerAddressAnswer = (xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "EmploymentChange" \ "StartedEmploymentAndFinished" \ "Address" \ "Answer" \ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")
  val payFrequencyQuestion = (xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "EmploymentChange" \ "StartedEmploymentAndFinished" \ "PayFrequency" \ "Frequency" \ "QuestionLabel")
  val payFrequencyAnswer = (xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "EmploymentChange" \ "StartedEmploymentAndFinished" \ "PayFrequency" \ "Frequency" \ "Answer")
  val employerOwesMoneyInfoOther = prepareTestDataOther(Seq("EmployerOwesYouMoney"))


  val furtherChangesData = prepareTestData(Seq("BeenPaidYet", "HowMuchPaid", "PaymentDate", "WhatWasIncluded",
    "UsuallyPaidSameAmount", "PayIntoPension", "PayIntoPensionWhatFor","PaidForThingsToDoJob","PaidForThingsWhatFor","CareCostsForThisWork","CareCostsForThisWorkWhatCosts"))
}

case class StartedAndOngoingEmploymentBasicDetails(xml: Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "EmploymentChange"){
  val basicChangesData = EmploymentChangeBasicDetails(xml: Elem).basicChangesData
}

case class StartedAndOngoingEmploymentFurtherDetails(xml: Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "EmploymentChange" \ "StartedEmploymentAndOngoing"){
  val startedOngoing = xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "EmploymentChange" \ "StartedEmploymentAndOngoing"
  val employerAddressQuestion = (startedOngoing \ "Address" \ "QuestionLabel")
  val employerAddressAnswer = (startedOngoing \ "Address" \ "Answer" \ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")
  val payFrequencyQuestion = (startedOngoing \ "PayFrequency" \ "Frequency" \ "QuestionLabel")
  val payFrequencyAnswer = (startedOngoing \ "PayFrequency" \ "Frequency" \ "Answer")

  val furtherChangesData = prepareTestData(Seq("EmployerName","EmployerContactNumber","EmployerPayroll", "BeenPaidYet", "HowMuchPaid", "PaymentDate",
    "UsuallyPaidSameAmount", "PayIntoPension", "PayIntoPensionWhatFor","PaidForThingsToDoJob","PaidForThingsWhatFor","CareCostsForThisWork","CareCostsForThisWorkWhatCosts"))
}

case class FutureEmploymentBasicDetails(xml: Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "EmploymentChange"){
  val basicChangesData = EmploymentChangeBasicDetails(xml: Elem).basicChangesData
}

case class FutureEmploymentFurtherDetails(xml: Elem) extends CircsUtils(xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "EmploymentChange" \ "NotStartedEmployment"){
  val futureEmp = xml \ "DWPCATransaction" \ "DWPCAChangeOfCircumstances" \ "EmploymentChange" \ "NotStartedEmployment"
  val employerAddressQuestion = (futureEmp \ "Address" \ "QuestionLabel")
  val employerAddressAnswer = (futureEmp \ "Address" \ "Answer" \ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")
  val payFrequencyQuestion = (futureEmp \ "PayFrequency" \ "Frequency" \ "QuestionLabel")
  val payFrequencyAnswer = (futureEmp \ "PayFrequency" \ "Frequency" \ "Answer")

  val furtherChangesData = prepareTestData(Seq("EmployerName","EmployerContactNumber","EmployerPayroll", "BeenPaidYet", "HowMuchPaid", "PaymentDate",
    "UsuallyPaidSameAmount", "PayIntoPension", "PayIntoPensionWhatFor","PaidForThingsToDoJob","PaidForThingsWhatFor","CareCostsForThisWork","CareCostsForThisWorkWhatCosts"))
}


