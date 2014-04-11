package test_data.circs

import utils.TestUtils
import scala.xml.Elem


object XMLCircsData extends TestUtils{

  def functionalTestCase1(xml: Elem) = {
    claimantDetails(xml) ++ careeDetails(xml)
  }

  /**
   * Section with stopped caring and without Other changes
   * @param xml
   * @return
   */
  def functionalTestCase2(xml: Elem) = {
    claimantDetails(xml) ++ careeDetails(xml) ++ stoppedCaring(xml)
  }

  def functionalTestDataSelfEmployed(xml: Elem) = {
    claimantDetails(xml) ++ careeDetails(xml) ++ selfEmployment(xml)
  }

  def functionalTestDataPaymentBankDetails(xml: Elem) = {
    claimantDetails(xml) ++ careeDetails(xml) ++ paymentBankDetails(xml)
  }

  def claimantDetails(xml:Elem) = {
    val claimantDetails = ClaimantDetails(xml).claimantDetails.map(s => buildQuestion(s._1.text, s._2.text))
    Seq(
      "Part 1 - Identification - Carer and Person cared for.",
      "Your details"
    ) ++ claimantDetails
  }

  def careeDetails(xml:Elem) = {
    val details = CareeDetails(xml).careeDetailsData.map(s => buildQuestion(s._1.text, s._2.text))
    Seq(
      "Person you are caring for"
    ) ++ details
  }

  def stoppedCaring(xml:Elem) = {
    val details = StoppedCaring(xml).stoppedCaringData.map(s => buildQuestion(s._1.text, s._2.text))
    Seq(
      "Part 2 - Change in Circumstance - Stopped Caring"
    ) ++ details
  }

  def selfEmployment(xml:Elem) = {
    val details = SelfEmployment(xml).selfEmploymentData.map(s => buildQuestion(s._1.text, s._2.text))
    Seq(
      "Part 2 - Change in Circumstance - Started self employment",
      "About your self employment"
    ) ++ details
  }

  def paymentBankDetails(xml:Elem) = {
    val details = PaymentBankDetailsPaidIntoAccount(xml).paidIntoAccountData.map(s => buildQuestion(s._1.text, s._2.text))
    Seq(
      "Part 2 - Change in Circumstance - Change of payment and bank details",
      "For security, we also need you to confirm your current payment details",
      "New payment details"
    ) ++ details ++ PaymentBankDetailsAccountDetails(xml).accountDetailsData.map(s => buildQuestion(s._1.text, s._2.text)) ++
      PaymentBankDetailsBuildingSocietyDetails(xml).buildingSocietyDetailsData.map(s => buildQuestion(s._1.text, s._2.text))
  }
}
