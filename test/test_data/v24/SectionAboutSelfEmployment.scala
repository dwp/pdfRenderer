package test_data.v24

import scala.xml.Elem

case class SectionAboutSelfEmployment(xml: Elem) {

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim"

  val selfEmployedNowQuestion = rootPath  \\ "SelfEmployment" \\ "SelfEmployedNow" \\ "QuestionLabel"
  val selfEmployedNowAnswer = rootPath  \\ "SelfEmployment" \\ "SelfEmployedNow" \\ "Answer"

  val selfEmployedMoreThanYearAgoQuestion = rootPath  \\ "SelfEmployment" \\ "MoreThanYearAgo" \\ "QuestionLabel"
  val selfEmployedMoreThanYearAgoAnswer = rootPath  \\ "SelfEmployment" \\ "MoreThanYearAgo" \\ "Answer"

  val selfEmployedDateStartedQuestion = rootPath  \\ "SelfEmployment" \\ "DateStarted" \\ "QuestionLabel"
  val selfEmployedDateStartedAnswer = rootPath  \\ "SelfEmployment" \\ "DateStarted" \\ "Answer"

  val selfEmployedDateEndedQuestion = rootPath  \\ "SelfEmployment" \\ "DateEnded" \\ "QuestionLabel"
  val selfEmployedDateEndedAnswer = rootPath  \\ "SelfEmployment" \\ "DateEnded" \\ "Answer"

  val selfEmployedGotAccountsQuestion = rootPath  \\ "SelfEmployment" \\ "GotAccounts" \\ "QuestionLabel"
  val selfEmployedGotAccountsAnswer = rootPath  \\ "SelfEmployment" \\ "GotAccounts" \\ "Answer"

  val selfEmployedKnowTradingYearQuestion = rootPath  \\ "SelfEmployment" \\ "KnowTradingYear" \\ "QuestionLabel"
  val selfEmployedKnowTradingYearAnswer = rootPath  \\ "SelfEmployment" \\ "KnowTradingYear" \\ "Answer"

  val selfEmployedTradingYearStartQuestion = rootPath  \\ "SelfEmployment" \\ "TradingYearStart" \\ "QuestionLabel"
  val selfEmployedTradingYearStartAnswer = rootPath  \\ "SelfEmployment" \\ "TradingYearStart" \\ "Answer"

  val selfEmployedPaidMoneyYetQuestion = rootPath  \\ "SelfEmployment" \\ "PaidMoneyYet" \\ "QuestionLabel"
  val selfEmployedPaidMoneyYetAnswer = rootPath  \\ "SelfEmployment" \\ "PaidMoneyYet" \\ "Answer"

  val selfEmployedPaidMoneyDateQuestion = rootPath  \\ "SelfEmployment" \\ "PaidMoneyDate" \\ "QuestionLabel"
  val selfEmployedPaidMoneyDateAnswer = rootPath  \\ "SelfEmployment" \\ "PaidMoneyDate" \\ "Answer"

  val selfEmployedPaidForPensionQuestion = rootPath  \\ "SelfEmployment" \\ "PaidForPension" \\ "QuestionLabel"
  val selfEmployedPaidForPensionAnswer = rootPath  \\ "SelfEmployment" \\ "PaidForPension" \\ "Answer"

  val selfEmployedPensionExpensesQuestion = rootPath  \\ "SelfEmployment" \\ "PensionExpenses" \\ "QuestionLabel"
  val selfEmployedPensionExpensesAnswer = rootPath  \\ "SelfEmployment" \\ "PensionExpenses" \\ "Answer"

  val selfEmployedPaidForJobExpensesQuestion = rootPath  \\ "SelfEmployment" \\ "PaidForJobExpenses" \\ "QuestionLabel"
  val selfEmployedPaidForJobExpensesAnswer = rootPath  \\ "SelfEmployment" \\ "PaidForJobExpenses" \\ "Answer"

  val selfEmployedJobExpensesQuestion = rootPath  \\ "SelfEmployment" \\ "JobExpenses" \\ "QuestionLabel"
  val selfEmployedJobExpensesAnswer = rootPath  \\ "SelfEmployment" \\ "JobExpenses" \\ "Answer"

}
