package test_data.circs

import scala.xml.{NodeSeq, Elem}


sealed abstract class CircsUtils(rootPath: NodeSeq) {

  def pathQuestionLabel (element:String) = {
    rootPath \\ element \\ "QuestionLabel"
  }

  def pathAnswer (element:String) = {
    rootPath \\ element \\ "Answer"
  }

  def pathQuestionLabelAnswer(element:String):(NodeSeq,NodeSeq) = {
    (pathQuestionLabel(element), pathAnswer(element))
  }

  def prepareTestData(elements:Seq[String]) = {
     elements.map(e => pathQuestionLabelAnswer(e))
  }
}

case class ClaimantDetails(xml: Elem) extends CircsUtils(xml \\ "DWPCATransaction" \\ "DWPCAChangeOfCircumstances" \\ "ClaimantDetails"){
  val claimantDetails = prepareTestData(Seq("FullName","DateOfBirth","NationalInsuranceNumber"))
}

case class CareeDetails(xml: Elem) extends CircsUtils(xml \\ "DWPCATransaction" \\ "DWPCAChangeOfCircumstances" \\ "CareeDetails"){
  val careeDetailsData = prepareTestData(Seq("FullName","RelationToClaimant"))
}

case class StoppedCaring(xml: Elem) extends CircsUtils(xml \\ "DWPCATransaction" \\ "DWPCAChangeOfCircumstances" \\ "StoppedCaring"){
  val stoppedCaringData = prepareTestData(Seq("DateStoppedCaring", "OtherChanges"))
}

case class SelfEmployment(xml:Elem) extends CircsUtils(xml \\ "DWPCATransaction" \\ "DWPCAChangeOfCircumstances" \\ "SelfEmployedChange"){
  val selfEmploymentData = prepareTestData(Seq("Caring35Hours", "BusinessStartDate", "BusinessType", "MoreThan100", "OtherChanges","DateStoppedCaring35Hours"))
}
