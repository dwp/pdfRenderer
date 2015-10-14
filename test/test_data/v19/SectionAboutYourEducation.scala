package test_data.v19

import scala.xml.Elem


case class SectionAboutYourEducation(xml: Elem) {

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim"

  val rootPathFullTimeEducation = rootPath \\ "FullTimeEducation"

  val courseOfEducationQuestion = rootPath \\ "CourseOfEducation" \\ "QuestionLabel"

  val courseOfEducationAnswer = rootPath \\ "CourseOfEducation" \\ "Answer"

  val courseDetailsType = rootPathFullTimeEducation \\ "CourseDetails" \\ "Type"

  val courseDetailsTitle = rootPathFullTimeEducation \\ "CourseDetails" \\ "Title"

  val courseDetailsDateStartedQuestion = rootPathFullTimeEducation \\ "CourseDetails" \\ "DateStarted" \\ "QuestionLabel"

  val courseDetailsDateStartedAnswer = rootPathFullTimeEducation \\ "CourseDetails" \\ "DateStarted" \\ "Answer"

  val courseDetailsDateStoppedQuestion = rootPathFullTimeEducation \\ "CourseDetails" \\ "DateStopped" \\ "QuestionLabel"

  val courseDetailsDateStoppedAnswer = rootPathFullTimeEducation \\ "CourseDetails" \\ "DateStopped" \\ "Answer"

  val courseDetailsExpectedEndDateQuestion = rootPathFullTimeEducation \\ "CourseDetails" \\ "ExpectedEndDate" \\ "QuestionLabel"

  val courseDetailsExpectedEndDateAnswer = rootPathFullTimeEducation \\ "CourseDetails" \\ "ExpectedEndDate" \\ "Answer"

  val studentReferenceNumber = rootPathFullTimeEducation \\ "LocationDetails" \\ "StudentReferenceNumber"

  val nameOfUniversity = rootPathFullTimeEducation \\ "LocationDetails" \\ "Name"

  val nameOfTheTutor = rootPathFullTimeEducation \\ "LocationDetails" \\ "Tutor"

  val address = (rootPathFullTimeEducation \\ "LocationDetails" \\ "Address" \\ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val postCode = rootPathFullTimeEducation \\ "LocationDetails" \\ "Address" \\ "PostCode"

  val phoneNumber = rootPathFullTimeEducation \\ "LocationDetails" \\ "PhoneNumber"

  val faxNumber = rootPathFullTimeEducation \\ "LocationDetails" \\ "FaxNumber"

}
