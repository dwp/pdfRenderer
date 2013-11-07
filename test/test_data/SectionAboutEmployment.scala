package test_data

import scala.xml.Elem


case class SectionAboutEmployment(xml: Elem) {

  val rootPathJobDetails = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Employment" \\ "JobDetails"

  val areYouEmployedQuestion = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Employed" \\ "QuestionLabel"

  val areYouEmployedAnswer = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Employed" \\ "Answer"

  val employerName = rootPathJobDetails \\ "Employer" \\ "Name"



}
