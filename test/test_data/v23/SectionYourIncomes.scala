package test_data.v23

/**
  * Created by peterwhitehead on 19/04/2016.
  */
import scala.xml.Elem

case class SectionYourIncomes(xml: Elem) {
  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Incomes"

  val areYouEmployedQuestion = rootPath \\ "Employed" \\ "QuestionLabel"
  val areYouEmployedAnswer = rootPath \\ "Employed" \\ "Answer"

  val haveBeenSelfEmployedQuestion = rootPath \\ "SelfEmployed" \\ "QuestionLabel"
  val haveBeenSelfEmployedAnswer = rootPath \\ "SelfEmployed" \\ "Answer"

  val otherPaymentQuestion = rootPath \\ "OtherPaymentQuestion" \\ "QuestionLabel"
  val otherPaymentAnswer = rootPath \\ "OtherPaymentQuestion" \\ "Answer"

  val sickPaymentQuestion = rootPath \\ "SickPayment" \\ "QuestionLabel"
  val sickPaymentAnswer = rootPath \\ "SickPayment" \\ "Answer"

  val patMatAdopPaymentQuestion = rootPath \\ "PatMatAdopPayment" \\ "QuestionLabel"
  val patMatAdopPaymentAnswer = rootPath \\ "PatMatAdopPayment" \\ "Answer"

  val fosteringPaymentQuestion = rootPath \\ "FosteringPayment" \\ "QuestionLabel"
  val fosteringPaymentAnswer = rootPath \\ "FosteringPayment" \\ "Answer"

  val directPaymentQuestion = rootPath \\ "DirectPayment" \\ "QuestionLabel"
  val directPaymentAnswer = rootPath \\ "DirectPayment" \\ "Answer"

  val anyOtherPaymentQuestion = rootPath \\ "AnyOtherPayment" \\ "QuestionLabel"
  val anyOtherPaymentAnswer = rootPath \\ "AnyOtherPayment" \\ "Answer"

  val noOtherPaymentQuestion = rootPath \\ "NoOtherPayment" \\ "QuestionLabel"
  val noOtherPaymentAnswer = rootPath \\ "NoOtherPayment" \\ "Answer"
}
