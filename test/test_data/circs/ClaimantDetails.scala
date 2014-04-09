package test_data.circs

import scala.xml.{NodeSeq, Elem}


sealed abstract class CircsUtils(rootPath: NodeSeq) {

  def pathQuestionLabel (element:String) = {
    rootPath \\ element \\ "QuestionLabel"
  }

  def pathAnswer (element:String) = {
    rootPath \\ element \\ "Answer"
  }

}

case class ClaimantDetails(xml: Elem) extends CircsUtils(xml \\ "DWPCATransaction" \\ "DWPCAChangeOfCircumstances" \\ "ClaimantDetails"){
  val fullNameQuestion = pathQuestionLabel("FullName")
  val fullNameAnswer = pathAnswer("FullName")
  val dateOfBirthQuestion = pathQuestionLabel("DateOfBirth")
  val dateOfBirthAnswer = pathAnswer("DateOfBirth")
  val nationalInsuranceNumberQuestion = pathQuestionLabel("NationalInsuranceNumber")
  val nationalInsuranceNumberAnswer = pathAnswer("NationalInsuranceNumber")
}

case class CareeDetails(xml: Elem) extends CircsUtils(xml \\ "DWPCATransaction" \\ "DWPCAChangeOfCircumstances" \\ "CareeDetails"){
  val fullNameQuestion = pathQuestionLabel("FullName")
  val fullNameAnswer = pathAnswer("FullName")
  val relationToClaimantQuestion = pathQuestionLabel("RelationToClaimant")
  val relationToClaimantAnswer = pathAnswer("RelationToClaimant")
}

case class StoppedCaring(xml: Elem) extends CircsUtils(xml \\ "DWPCATransaction" \\ "DWPCAChangeOfCircumstances" \\ "StoppedCaring"){
  val dateStoppedCaringQuestion = pathQuestionLabel("DateStoppedCaring")
  val dateStoppedCaringAnswer = pathAnswer("DateStoppedCaring")
  val otherChangesQuestion = pathQuestionLabel("OtherChanges")
  val otherChangesAnswer = pathAnswer("OtherChanges")
}
