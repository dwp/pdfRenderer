package test_data.v13

import scala.xml.Elem

case class SectionAboutYourPayDetails(xml: Elem) {

  val rootPath = xml \ "DWPCATransaction" \ "DWPCAClaim"

  val howToGetPaidQuestion = rootPath \ "Payment" \ "InitialAccountQuestion" \ "QuestionLabel"
  val howToGetPaidAnswer = rootPath \ "Payment" \ "InitialAccountQuestion" \ "Answer"

  val howOftenGetPaidQuestion = rootPath \ "Payment" \ "PaymentFrequency" \ "QuestionLabel"
  val howOftenGetPaidAnswer = rootPath \ "Payment" \ "PaymentFrequency" \ "Answer"
  val howOftenGetPaidOther = rootPath \ "Payment" \ "PaymentFrequency" \ "Other"

  val bankAccountHolderName = rootPath \ "Payment" \ "Account" \ "HolderName"

  val bankAccountBankName = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "Name"

  val bankAccountSortCode = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "Sortcode"

  val bankAccountNumber = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "AccountNumber"

  val bankAccountReferenceNumber = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "RollNumber"

}
