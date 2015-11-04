package test_data.circs

import scala.xml.Elem
import scala._


object XMLCircsData extends utils.TestUtils {

  def functionalTestCase1(xml: Elem) = {
    claimantDetails(xml) ++ careeDetails(xml) ++ declaration(xml:Elem)
  }

  /**
   * Section with stopped caring and without Other changes
   * @param xml
   * @return
   */
  def functionalTestCase2(xml: Elem) = {
    claimantDetails(xml) ++ careeDetails(xml) ++ stoppedCaring(xml) ++ declaration(xml:Elem)
  }

  def functionalTestDataSelfEmployed(xml: Elem) = {
    claimantDetails(xml) ++ careeDetails(xml) ++ selfEmployment(xml) ++ declaration(xml:Elem)
  }

  def functionalTestDataPaymentBankDetails(xml: Elem) = {
    claimantDetails(xml) ++ careeDetails(xml) ++ paymentBankDetails(xml) ++ declaration(xml:Elem)
  }

  def functionalTestDataAddressChangeDetails(xml: Elem) = {
    claimantDetails(xml) ++ careeDetails(xml) ++ addressChangeDetails(xml) ++ declaration(xml:Elem)
  }

  def functionalTestDataBreaksInCareChangeDetails(xml: Elem) = {
    claimantDetails(xml) ++ careeDetails(xml) ++ breaksInCareChangeDetails(xml) ++ declaration(xml:Elem)
  }

  def functionalTestDataOtherDetails(xml: Elem) = {
    claimantDetails(xml) ++ careeDetails(xml) ++ otherChanges(xml) ++ declaration(xml:Elem)
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

  def otherChanges(xml:Elem) = {
    val details = OtherChangesDetails(xml).otherChangesData.map(s => buildQuestion(s._1.text, s._2.text))
    Seq(
      "Part 2 - Change in Circumstance - Other Changes"
    ) ++ details
  }


  def paymentBankDetails(xml:Elem) = {
    val details = PaymentBankDetailsPaidIntoAccount(xml).paidIntoAccountData.map(s => buildQuestion(s._1.text, s._2.text))
    Seq(
      "Part 2 -Change in Circumstance - Change of payment and bank details",
      "Existing payment details",
      "New payment details"
    ) ++ details ++ PaymentBankDetailsAccountDetails(xml).accountDetailsData.map(s => buildQuestion(s._1.text, s._2.text)) ++
      PaymentBankDetailsBuildingSocietyDetails(xml).buildingSocietyDetailsData.map(s => buildQuestion(s._1.text, s._2.text))
  }

  def addressChangeDetails(xml:Elem) = {
    val details = ChangeAddressDetails(xml).changeAddressData.map(s => buildQuestion(s._1.text, s._2.text))
    Seq(
      "Part 2 - Change in Circumstance - Change of address",
      "For security, we also need you to confirm your previous address.",
      ChangeAddressDetails(xml).previousAddressQuestion.text,
      ChangeAddressDetails(xml).previousAddressAnswer,
      ChangeAddressDetails(xml).newAddressQuestion.text,
      ChangeAddressDetails(xml).newAddressAnswer,
      ChangeAddressDetails(xml).personYouCareForAddressQuestion.text,
      ChangeAddressDetails(xml).personYouCareForAddressAnswer
    ) ++ details
  }

  def breaksInCareChangeDetails(xml:Elem) = {
    val details = BreaksInCareDetails(xml).breaksInCareData.map(s => buildQuestion(s._1.text, s._2.text))
    val breaksFromCaringEnded = BreaksFromCaringEnded(xml).breaksFromCaringEndedData.map(s => buildQuestion(s._1.text, s._2.text))
    Seq(
      "Part 2 - Change in Circumstance - Breaks From Caring",
      BreaksInCareDetails(xml).wherePersonYouCareSomeWhereElse.text,
      BreaksInCareDetails(xml).whereWereYouSomeWhereElse.text
    ) ++ details ++ breaksFromCaringEnded
  }

  def declaration(xml:Elem):Seq[String] = {
    val titleContentPath = DeclarationDetails(xml).declarationTitleContentPath
    val declarationQuestionData = DeclarationDetails(xml).declarationQuestionContentPath.map(f => buildQuestion((f \ "QuestionLabel").text,(f \ "Answer").text))
    val nameOrOrgData = DeclarationQuestionContentPath(xml).declarationNameOrOrgPath.map(s => buildQuestion(s._1.text, s._2.text))
    val consentsData = ConsentsQuestionPath(xml).consentsQuestionPath.map(s => buildQuestion(s._1.text, s._2.text))
    val consentsDataWhy = ConsentsWhyQuestionPath (xml).consentsWhyQuestionPath.map(s => buildQuestion(s._1.text, s._2.text))
    val title = Seq("Part 3 - Declaration",
        "Further Information",
        "Declaration",
      (titleContentPath \ "Title").text
      ) ++ declarationQuestionData ++ nameOrOrgData ++ consentsData ++ consentsDataWhy ++ titleContentPath.map(x => {
                    Seq((x \\ "Content").map(v => v.text).reduce((total,cur) => total + " " + cur)
                   )
                   }).flatten

    title
  }
}
