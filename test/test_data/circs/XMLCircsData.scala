package test_data.circs

import utils.TestUtils
import scala.xml.Elem


object XMLCircsData extends TestUtils{

  def functionalTestCase1(xml: Elem) = {
    claimantDetails(xml) ++ careeDetails(xml)
  }

  def claimantDetails (xml:Elem) = {
    val claimantDetails = ClaimantDetails(xml)
    Seq(
      "Part 1 - Identification - Carer and Person cared for.",
      "Your details",
      buildQuestion(claimantDetails.fullNameQuestion.text, claimantDetails.fullNameAnswer.text),
      buildQuestion(claimantDetails.dateOfBirthQuestion.text, claimantDetails.dateOfBirthAnswer.text),
      buildQuestion(claimantDetails.nationalInsuranceNumberQuestion.text, claimantDetails.nationalInsuranceNumberAnswer.text)
    )
  }

  def careeDetails (xml:Elem) = {
    val details = CareeDetails(xml)
    Seq(
      "Person you are caring for",
      buildQuestion(details.fullNameQuestion.text, details.fullNameAnswer.text),
      buildQuestion(details.relationToClaimantQuestion.text, details.relationToClaimantAnswer.text)
    )
  }
}
