package test_data

import scala.xml.Elem

case class SectionAboutSelfEmployment(xml: Elem) {

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim"

  val haveBeenSelfEmployedQuestion = rootPath \\ "SelfEmployed" \\ "QuestionLabel"
  val haveBeenSelfEmployedAnswer = rootPath \\ "SelfEmployed" \\ "Answer"

  val selfEmployedNowQuestion = rootPath  \\ "SelfEmployment" \\ "SelfEmployedNow" \\ "QuestionLabel"
  val selfEmployedNowAnswer = rootPath  \\ "SelfEmployment" \\ "SelfEmployedNow" \\ "Answer"

  val selfEmployedStartedQuestion = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "DateStarted" \\ "QuestionLabel"
  val selfEmployedStartedAnswer = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "DateStarted" \\ "Answer"

  val selfEmployedEndedQuestion = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "DateEnded" \\ "QuestionLabel"
  val selfEmployedEndedAnswer = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "DateEnded" \\ "Answer"

  val ceasedTradingQuestion = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "TradingCeased" \\ "QuestionLabel"
  val ceasedTradingAnswer = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "TradingCeased" \\ "Answer"

  val natureOfBusinessQuestion = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "NatureBusiness" \\ "QuestionLabel"
  val natureOfBusinessAnswer = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "NatureBusiness" \\ "Answer"

  val tradingYearStartedQuestion = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "TradingYear" \\ "DateFrom" \\ "QuestionLabel"
  val tradingYearStartedAnswer = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "TradingYear" \\ "DateFrom" \\ "Answer"

  val tradingYearEndedQuestion = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "TradingYear" \\ "DateTo" \\ "QuestionLabel"
  val tradingYearEndedAnswer = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "TradingYear" \\ "DateTo" \\ "Answer"

  val sameIncomeOutgoingLevelsQuestion = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "SameIncomeOutgoingLevels" \\ "QuestionLabel"
  val sameIncomeOutgoingLevelsAnswer = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "SameIncomeOutgoingLevels" \\ "Answer"

  val whyWhenChangeQuestion = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "WhyWhenChange" \\ "QuestionLabel"
  val whyWhenChangeAnswer = rootPath  \\ "SelfEmployment" \\ "RecentJobDetails" \\ "WhyWhenChange" \\ "Answer"

  val paidForPensionQuestion = rootPath  \\ "SelfEmployment" \\ "PaidForPension" \\ "QuestionLabel"
  val paidForPensionAnswer = rootPath  \\ "SelfEmployment" \\ "PaidForPension" \\ "Answer"

  val pensionSchemeAmountQuestion = rootPath  \\ "SelfEmployment" \\ "PensionScheme" \\ "Payment" \\ "QuestionLabel"
  val pensionSchemeAmountAnswerAmount = rootPath  \\ "SelfEmployment" \\ "PensionScheme" \\ "Payment" \\ "Answer" \\ "Amount"
  val pensionSchemeAmountAnswerCurrency = rootPath  \\ "SelfEmployment" \\ "PensionScheme" \\ "Payment" \\ "Answer" \\ "Currency"

  val pensionSchemeFrequencyQuestion = rootPath  \\ "SelfEmployment" \\ "PensionScheme" \\ "Frequency" \\ "QuestionLabel"
  val pensionSchemeFrequencyAnswer = rootPath  \\ "SelfEmployment" \\ "PensionScheme" \\ "Frequency" \\ "Answer"
  val pensionSchemeFrequencyOther = rootPath  \\ "SelfEmployment" \\ "PensionScheme" \\ "Frequency" \\ "Other"

  val careExpensesChildrenQuestion = rootPath  \\ "SelfEmployment" \\ "CareExpensesChildren" \\ "QuestionLabel"
  val careExpensesChildrenAnswer = rootPath  \\ "SelfEmployment" \\ "CareExpensesChildren" \\ "Answer"

  val careExpensesChildrenCarerNameQuestion = rootPath  \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "CarerName" \\ "QuestionLabel"
  val careExpensesChildrenCarerNameAnswer = rootPath  \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "CarerName" \\ "Answer"

  val careExpensesChildrenPaymentQuestion = rootPath  \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "Expense" \\ "Payment" \\ "Amount" \\ "QuestionLabel"
  val careExpensesChildrenPaymentAnswerAmount = rootPath  \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "Expense" \\ "Payment" \\ "Answer" \\ "Amount"
  val careExpensesChildrenPaymentAnswerCurrency = rootPath  \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "Expense" \\ "Payment" \\ "Answer" \\ "Currency"

  val careExpensesChildrenPaymentFrequencyQuestion = rootPath  \\ "SelfEmployment" \\ "ChildCareExpenses"  \\ "Expense" \\ "Frequency" \\ "QuestionLabel"
  val careExpensesChildrenPaymentFrequencyAnswer = rootPath  \\ "SelfEmployment" \\ "ChildCareExpenses"  \\ "Expense" \\ "Frequency" \\ "Answer"
  val careExpensesChildrenPaymentFrequencyOther = rootPath  \\ "SelfEmployment" \\ "ChildCareExpenses"  \\ "Expense" \\ "Frequency" \\ "Other"

  val careExpensesChildrenRelationshipToCarerQuestion = rootPath  \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "RelationshipCarerToClaimant" \\ "QuestionLabel"
  val careExpensesChildrenRelationshipToCarerAnswer = rootPath  \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "RelationshipCarerToClaimant" \\ "Answer"

  val careExpensesChildrenRelationshipToPartnerQuestion = rootPath  \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "RelationshipCarerToPartner" \\ "QuestionLabel"
  val careExpensesChildrenRelationshipToPartnerAnswer = rootPath  \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "RelationshipCarerToPartner" \\ "Answer"

  val careExpensesChildrenRelationshipToChildQuestion = rootPath  \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "RelationshipCarerToChild" \\ "QuestionLabel"
  val careExpensesChildrenRelationshipToChildAnswer = rootPath  \\ "SelfEmployment" \\ "ChildCareExpenses" \\ "RelationshipCarerToChild" \\ "Answer"

  val careExpensesCareeQuestion = rootPath  \\ "SelfEmployment" \\ "CareExpensesCaree" \\ "QuestionLabel"
  val careExpensesCareeAnswer = rootPath  \\ "SelfEmployment" \\ "CareExpensesCaree" \\ "Answer"

  val careExpensesCareeCarerNameQuestion = rootPath  \\ "SelfEmployment" \\ "CareExpenses" \\ "CarerName" \\ "QuestionLabel"
  val careExpensesCareeCarerNameAnswer = rootPath  \\ "SelfEmployment" \\ "CareExpenses" \\ "CarerName" \\ "Answer"

  val careExpensesCareePaymentQuestion = rootPath  \\ "SelfEmployment" \\ "CareExpenses"  \\ "Expense" \\ "Payment" \\ "Amount" \\ "QuestionLabel"
  val careExpensesCareePaymentAnswerAmount = rootPath  \\ "SelfEmployment" \\ "CareExpenses"  \\ "Expense" \\ "Payment" \\ "Answer" \\ "Amount"
  val careExpensesCareePaymentAnswerCurrency = rootPath  \\ "SelfEmployment" \\ "CareExpenses"  \\ "Expense" \\ "Payment" \\ "Answer" \\ "Currency"

  val careExpensesCareePaymentFrequencyQuestion = rootPath  \\ "SelfEmployment" \\ "CareExpenses"  \\ "Expense" \\ "Payment" \\ "Frequency" \\ "QuestionLabel"
  val careExpensesCareePaymentFrequencyAnswer = rootPath  \\ "SelfEmployment" \\ "CareExpenses"  \\ "Expense" \\ "Payment" \\ "Frequency" \\ "Answer"
  val careExpensesCareePaymentFrequencyOther = rootPath  \\ "SelfEmployment" \\ "CareExpenses"  \\ "Expense" \\ "Payment" \\ "Frequency" \\ "Other"

  val careExpensesRelationshipCarerToClaimantQuestion = rootPath  \\ "SelfEmployment" \\ "CareExpenses" \\ "RelationshipCarerToClaimant" \\ "QuestionLabel"
  val careExpensesRelationshipCarerToClaimantAnswer = rootPath  \\ "SelfEmployment" \\ "CareExpenses" \\ "RelationshipCarerToClaimant" \\ "Answer"

  val careExpensesRelationshipCarerToPartnerQuestion = rootPath  \\ "SelfEmployment" \\ "CareExpenses" \\ "RelationshipCarerToPartner" \\ "QuestionLabel"
  val careExpensesRelationshipCarerToPartnerAnswer = rootPath  \\ "SelfEmployment" \\ "CareExpenses" \\ "RelationshipCarerToPartner" \\ "Answer"

  val careExpensesRelationshipCarerToCareeQuestion = rootPath  \\ "SelfEmployment" \\ "CareExpenses" \\ "RelationToCaree" \\ "QuestionLabel"
  val careExpensesRelationshipCarerToCareeAnswer = rootPath  \\ "SelfEmployment" \\ "CareExpenses" \\ "RelationToCaree" \\ "Answer"
}
