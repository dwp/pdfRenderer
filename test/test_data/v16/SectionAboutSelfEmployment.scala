package test_data.v16

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

  val pensionExpensesQuestion = rootPath  \\ "SelfEmployment" \\"PensionExpenses" \\ "Expense" \\ "QuestionLabel"
  val pensionExpensesAnswer = rootPath \\ "SelfEmployment" \\"PensionExpenses" \\ "Expense" \\ "Answer"

  val paidForJobExpensesQuestion = rootPath  \\ "SelfEmployment" \\ "PaidForJobExpenses" \\ "QuestionLabel"
  val paidForJobExpensesAnswer = rootPath  \\ "SelfEmployment" \\ "PaidForJobExpenses" \\ "Answer"

  val jobExpensesQuestion = rootPath  \\ "SelfEmployment" \\"JobExpenses" \\ "Expense" \\ "QuestionLabel"
  val jobExpensesAnswer = rootPath \\ "SelfEmployment" \\"JobExpenses" \\ "Expense" \\ "Answer"

}
