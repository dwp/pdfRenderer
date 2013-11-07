package test_data

import scala.xml.Elem

case class SectionAboutSelfEmployment(xml: Elem) {

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim"

  val haveBeenSelfEmployedQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployed" \\ "QuestionLabel"
  val haveBeenSelfEmployedAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployed" \\ "Answer"

  val selfEmployedNowQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "SelfEmployedNow" \\ "QuestionLabel"
  val selfEmployedNowAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "SelfEmployedNow" \\ "Answer"

  val selfEmployedStartedQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "DateStarted" \\ "QuestionLabel"
  val selfEmployedStartedAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "DateStarted" \\ "Answer"

  val selfEmployedEndedQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "DateEnded" \\ "QuestionLabel"
  val selfEmployedEndedAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "DateEnded" \\ "Answer"

  val ceasedTradingQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "TradingCeased" \\ "QuestionLabel"
  val ceasedTradingAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "TradingCeased" \\ "Answer"

  val natureOfBusinessQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "NatureBusiness" \\ "QuestionLabel"
  val natureOfBusinessAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "NatureBusiness" \\ "Answer"

  val tradingYearStartedQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "TradingYear" \\ "DateFrom" \\ "QuestionLabel"
  val tradingYearStartedAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "TradingYear" \\ "DateFrom" \\ "Answer"

  val tradingYearEndedQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "TradingYear" \\ "DateTo" \\ "QuestionLabel"
  val tradingYearEndedAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "TradingYear" \\ "DateTo" \\ "Answer"

  val sameIncomeOutgoingLevelsQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "SameIncomeOutgoingLevels" \\ "QuestionLabel"
  val sameIncomeOutgoingLevelsAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "SameIncomeOutgoingLevels"

  val whyWhenChangeQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "WhyWhenChange" \\ "QuestionLabel"
  val whyWhenChangeAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "RecentJobDetails" \\ "WhyWhenChange" \\ "Answer"

  val paidForPensionQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "PaidForPension" \\ "QuestionLabel"
  val paidForPensionAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "PaidForPension" \\ "Answer"

  val pensionSchemeQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "PensionScheme" \\ "Amount" \\ "QuestionLabel"
  val pensionSchemeAnswerAmount = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "PensionScheme" \\ "Answer" \\ "Amount"
  val pensionSchemeAnswerCurrency = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "PensionScheme" \\ "Answer" \\ "Currency"

  val pensionSchemeFrequencyQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "PensionScheme" \\ "Frequency" \\ "QuestionLabel"
  val pensionSchemeFrequencyAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "PensionScheme" \\ "Frequency" \\ "Answer"
  val pensionSchemeFrequencyOther = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "PensionScheme" \\ "Frequency" \\ "Answer"

  val careExpensesChildrenQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpensesChildren" \\ "QuestionLabel"
  val careExpensesChildrenAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpensesChildren" \\ "Answer"

  val careExpensesChildrenCarerNameQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "CarerName" \\ "QuestionLabel"
  val careExpensesChildrenCarerNameAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "CarerName" \\ "Answer"

  val careExpensesChildrenPaymentQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "Payment" \\ "Amount" \\ "QuestionLabel"
  val careExpensesChildrenPaymentAnswerAmount = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "Payment" \\ "Answer" \\ "Amount"
  val careExpensesChildrenPaymentAnswerCurrency = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "Payment" \\ "Answer" \\ "Currency"

  val careExpensesChildrenPaymentFrequencyQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "Frequency" \\ "QuestionLabel"
  val careExpensesChildrenPaymentFrequencyAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "Frequency" \\ "Answer"
  val careExpensesChildrenPaymentFrequencyOther = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "Frequency" \\ "Answer"

  val careExpensesChildrenRelationshipToCarerQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "RelationshipCarerToClaimant" \\ "QuestionLabel"
  val careExpensesChildrenRelationshipToCarerAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "RelationshipCarerToClaimant" \\ "Answer"

  val careExpensesChildrenRelationshipToPartnerQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "RelationshipCarerToPartner" \\ "QuestionLabel"
  val careExpensesChildrenRelationshipToPartnerAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "RelationshipCarerToPartner" \\ "Answer"

  val careExpensesChildrenRelationshipToChildQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "RelationshipCarerToChild" \\ "QuestionLabel"
  val careExpensesChildrenRelationshipToChildAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "RelationshipCarerToChild" \\ "Answer"

  val careExpensesCareeQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpensesCaree" \\ "QuestionLabel"
  val careExpensesCareeAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpensesCaree" \\ "Answer"

  val careExpensesCareeCarerNameQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpenses" \\ "CarerName" \\ "QuestionLabel"
  val careExpensesCareeCarerNameAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpenses" \\ "CarerName" \\ "Answer"

  val careExpensesCareePaymentQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpenses" \\ "Payment" \\ "Amount" \\ "QuestionLabel"
  val careExpensesCareePaymentAnswerAmount = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpenses" \\ "Payment" \\ "Answer" \\ "Amount"
  val careExpensesCareePaymentAnswerCurrency = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpenses" \\ "Payment" \\ "Answer" \\ "Currency"

  val careExpensesCareePaymentFrequencyQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpenses" \\ "Payment" \\ "Frequency" \\ "QuestionLabel"
  val careExpensesCareePaymentFrequencyAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpenses" \\ "Payment" \\ "Frequency" \\ "Answer"
  val careExpensesCareePaymentFrequencyOther = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpenses" \\ "Payment" \\ "Frequency" \\ "Answer"

  val careExpensesRelationshipCarerToClaimantQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpenses" \\ "RelationshipCarerToClaimant" \\ "QuestionLabel"
  val careExpensesRelationshipCarerToClaimantAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpenses" \\ "RelationshipCarerToClaimant" \\ "Answer"

  val careExpensesRelationshipCarerToPartnerQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpenses" \\ "RelationshipCarerToPartner" \\ "QuestionLabel"
  val careExpensesRelationshipCarerToPartnerAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpenses" \\ "RelationshipCarerToPartner" \\ "Answer"

  val careExpensesRelationshipCarerToCareeQuestion = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpenses" \\ "RelationToCaree" \\ "QuestionLabel"
  val careExpensesRelationshipCarerToCareeAnswer = rootPath \\ "DWPCAClaim" \\ "SelfEmployment" \\ "CareExpenses" \\ "RelationToCaree" \\ "Answer"
}
