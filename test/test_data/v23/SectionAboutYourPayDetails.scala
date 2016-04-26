package test_data.v23

import scala.xml.Elem

case class SectionAboutYourPayDetails(xml: Elem) {

  val rootPath = xml \ "DWPCATransaction" \ "DWPCAClaim"

  val howToGetPaidQuestion = rootPath \ "Payment" \ "InitialAccountQuestion" \ "QuestionLabel"

  val howToGetPaidAnswer = rootPath \ "Payment" \ "InitialAccountQuestion" \ "Answer"

  val howOftenGetPaidQuestion = rootPath \ "Payment" \ "PaymentFrequency" \ "QuestionLabel"

  val howOftenGetPaidAnswer = rootPath \ "Payment" \ "PaymentFrequency" \ "Answer"

  val howOftenGetPaidOther = rootPath \ "Payment" \ "PaymentFrequency" \ "Other"

  val bankAccountHolderName = rootPath \ "Payment" \ "Account" \ "HolderName"

  val bankAccountHolderNameQuestion = rootPath \ "Payment" \ "Account" \ "HolderName" \ "QuestionLabel"

  val bankAccountHolderNameAnswer = rootPath \ "Payment" \ "Account" \ "HolderName" \ "Answer"

  val bankAccountBankName = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "Name"

  val bankAccountBankNameQuestion = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "Name" \ "QuestionLabel"

  val bankAccountBankNameAnswer = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "Name" \ "Answer"

  val bankAccountSortCode = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "Sortcode"

  val bankAccountSortCodeQuestion = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "Sortcode" \ "QuestionLabel"

  val bankAccountSortCodeAnswer = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "Sortcode" \ "Answer"

  val bankAccountNumber = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "AccountNumber"

  val bankAccountNumberQuestion = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "AccountNumber" \ "QuestionLabel"

  val bankAccountNumberAnswer = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "AccountNumber" \ "Answer"

  val bankAccountReferenceNumber = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "RollNumber"

  val bankAccountReferenceNumberQuestion = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "RollNumber" \ "QuestionLabel"

  val bankAccountReferenceNumberAnswer = rootPath \ "Payment" \ "Account" \ "BuildingSocietyDetails" \ "RollNumber" \ "Answer"

}
