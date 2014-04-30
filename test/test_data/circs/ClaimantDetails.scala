package test_data.circs

import scala.xml.{NodeSeq, Elem}


sealed abstract class CircsUtils(rootPath: NodeSeq){

  def pathQuestionLabel (element:String) = {
    rootPath \ element \ "QuestionLabel"
  }

  def pathAnswer (element:String) = {
    rootPath \ element \ "Answer"
  }

  def pathQuestionLabelAnswer(element:String):(NodeSeq,NodeSeq) = {
    (pathQuestionLabel(element), pathAnswer(element))
  }

  def prepareTestData(elements:Seq[String]) = {
     elements.map(e => pathQuestionLabelAnswer(e))
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
