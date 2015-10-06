package test_data.v18

import scala.xml.Elem

case class SectionAboutOtherMoney(xml: Elem) {

  val rootPath = xml \ "DWPCATransaction" \ "DWPCAClaim"

  val otherMoneyQuestion = rootPath \ "OtherBenefits" \ "OtherMoney" \ "QuestionLabel"
  val otherMoneyAnswer = rootPath \ "OtherBenefits" \ "OtherMoney" \ "Answer"

  val otherMoneyPaymentQuestion = rootPath \ "OtherBenefits" \ "OtherMoneyDetails" \ "Payment" \ "QuestionLabel"
  val otherMoneyPaymentAnswer = rootPath \ "OtherBenefits" \ "OtherMoneyDetails" \ "Payment" \ "Answer"

  val otherMoneyPaymentNameQuestion = rootPath \ "OtherBenefits" \ "OtherMoneyDetails" \ "Name" \ "QuestionLabel"
  val otherMoneyPaymentNameAnswer = rootPath \ "OtherBenefits" \ "OtherMoneyDetails" \ "Name" \ "Answer"

  val otherMoneyPaymentAmountQuestion = rootPath \ "OtherBenefits" \ "OtherMoneyDetails" \ "Payment" \ "Payment" \ "QuestionLabel"
  val otherMoneyPaymentAmountAmount = rootPath \ "OtherBenefits" \ "OtherMoneyDetails" \ "Payment" \ "Payment" \ "Answer" \ "Amount"
  val otherMoneyPaymentAmountCurrency = rootPath \ "OtherBenefits" \ "OtherMoneyDetails" \ "Payment" \ "Payment" \ "Answer" \ "Currency"

  val otherMoneyPaymentFrequencyQuestion = rootPath \ "OtherBenefits" \ "OtherMoneyDetails" \ "Payment" \ "Frequency" \ "QuestionLabel"
  val otherMoneyPaymentFrequencyAnswer = rootPath \ "OtherBenefits" \ "OtherMoneyDetails" \ "Payment" \ "Frequency" \ "Answer"
  val otherMoneyPaymentFrequencyOther = rootPath \ "OtherBenefits" \ "OtherMoneyDetails" \ "Payment" \ "Frequency" \ "Other"

  val otherMoneySSPQuestion = rootPath \ "OtherBenefits" \ "OtherMoneySSP" \ "QuestionLabel"
  val otherMoneySSPAnswer = rootPath \ "OtherBenefits" \ "OtherMoneySSP" \ "Answer"

  val otherMoneySSPPaymentAmountQuestion = rootPath \ "OtherBenefits" \ "OtherMoneySSPDetails" \ "Payment" \ "Payment" \ "QuestionLabel"
  val otherMoneySSPPaymentAmountAmount = rootPath \ "OtherBenefits" \ "OtherMoneySSPDetails" \ "Payment" \"Payment" \ "Answer" \ "Amount"
  val otherMoneySSPPaymentAmountCurrency = rootPath \ "OtherBenefits" \ "OtherMoneySSPDetails" \ "Payment" \ "Payment" \ "Answer" \ "Currency"

  val otherMoneySSPPaymentFrequencyQuestion = rootPath \ "OtherBenefits" \ "OtherMoneySSPDetails" \ "Payment" \ "Frequency" \ "QuestionLabel"
  val otherMoneySSPPaymentFrequencyAnswer = rootPath \ "OtherBenefits" \ "OtherMoneySSPDetails" \ "Payment" \ "Frequency" \ "Answer"
  val otherMoneySSPPaymentFrequencyOther = rootPath \ "OtherBenefits" \ "OtherMoneySSPDetails" \ "Payment" \ "Frequency" \ "Other"

  val otherMoneySSPEmployerName = rootPath \ "OtherBenefits" \ "OtherMoneySSPDetails" \ "Name" \ "Answer"

  val otherMoneySSPEmployerAddress = (rootPath \ "OtherBenefits" \ "OtherMoneySSPDetails" \ "Address" \ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val otherMoneySSPEmployerPostcode = rootPath \ "OtherBenefits" \ "OtherMoneySSPDetails" \ "Payment" \ "Address" \ "Postcode"

  val otherMoneySPQuestion = rootPath \ "OtherBenefits" \ "OtherMoneySP" \ "QuestionLabel"
  val otherMoneySPAnswer = rootPath \ "OtherBenefits" \ "OtherMoneySP" \ "Answer"

  val otherMoneySPPaymentAmountQuestion = rootPath \ "OtherBenefits" \ "OtherMoneySPDetails" \ "Payment" \ "Payment" \ "QuestionLabel"
  val otherMoneySPPaymentAmountAmount = rootPath \ "OtherBenefits" \ "OtherMoneySPDetails" \ "Payment" \ "Payment" \ "Answer" \ "Amount"
  val otherMoneySPPaymentAmountCurrency = rootPath \ "OtherBenefits" \ "OtherMoneySPDetails" \ "Payment" \ "Payment" \ "Answer" \ "Currency"

  val otherMoneySPPaymentFrequencyQuestion = rootPath \ "OtherBenefits" \ "OtherMoneySPDetails" \ "Payment" \ "Frequency" \ "QuestionLabel"
  val otherMoneySPPaymentFrequencyAnswer = rootPath \ "OtherBenefits" \ "OtherMoneySPDetails" \ "Payment" \ "Frequency" \ "Answer"
  val otherMoneySPPaymentFrequencyOther = rootPath \ "OtherBenefits" \ "OtherMoneySPDetails" \ "Payment" \ "Frequency" \ "Other"

  val otherMoneySPEmployerName = rootPath \ "OtherBenefits" \ "OtherMoneySPDetails" \ "Name" \ "Answer"

  val otherMoneySPEmployerAddress = (rootPath \ "OtherBenefits" \ "OtherMoneySPDetails" \ "Address" \ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val otherMoneySPEmployerPostcode = rootPath \ "OtherBenefits" \ "OtherMoneySPDetails" \ "Payment" \ "Address" \ "Postcode"

  val eeaGuardQuestion = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAGuardQuestion" \\ "QuestionLabel"

  val eeaGuardAnswer = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAGuardQuestion" \\ "Answer"

  val receiveEEAPensionsBenefitsQuestion = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAReceivePensionsBenefits" \\ "QuestionLabel"

  val receiveEEAPensionsBenefitsAnswer = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAReceivePensionsBenefits" \\ "Answer"

  val receiveEEAPensionsBenefitsDetailsQuestion = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAReceivePensionsBenefitsDetails" \\ "QuestionLabel"

  val receiveEEAPensionsBenefitsDetailsAnswer = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAReceivePensionsBenefitsDetails" \\ "Answer"

  val workingEEAInsuranceQuestion = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAWorkingInsurance" \\ "QuestionLabel"

  val workingEEAInsuranceAnswer = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAWorkingInsurance" \\ "Answer"

  val workingEEAInsuranceDetailsQuestion = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAWorkingInsuranceDetails" \\ "QuestionLabel"

  val workingEEAInsuranceDetailsAnswer = rootPath \\ "OtherBenefits" \\ "EEA" \\ "EEAWorkingInsuranceDetails" \\ "Answer"

}
