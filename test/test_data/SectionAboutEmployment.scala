package test_data

import scala.xml.Elem


case class SectionAboutEmployment(xml: Elem) {

  val rootPathJobDetails = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Employment" \\ "JobDetails"

  val areYouEmployedQuestion = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Employed" \\ "QuestionLabel"

  val areYouEmployedAnswer = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Employed" \\ "Answer"

  val address = (rootPathJobDetails \\ "Employer" \\ "Address" \\ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val postCode = rootPathJobDetails \\ "Employer" \\ "Address" \\ "PostCode"

  val employmentDetails: Seq[String] = {
    (rootPathJobDetails
      map (y =>
      (y \\ "Employer").
        map(x => {
        Seq("Your Job Details for "+(x \\ "Name").text,
          (x \\ "DateJobStarted" \\ "QuestionLabel").text+" "+(x \\ "DateJobStarted" \\ "Answer").text,
          (x \\ "HaveFinishedJob" \\ "QuestionLabel").text+" "+(x \\ "HaveFinishedJob" \\ "Answer").text,
          (x \\ "DateJobEnded" \\ "QuestionLabel").text+" "+(x \\ "DateJobEnded" \\ "Answer").text,
          (x \\ "P45LeavingDate" \\ "QuestionLabel").text+" "+(x \\ "P45LeavingDate" \\ "Answer").text,
          "Payroll or Employee number "+(x \\ "ClockPayrollNumber").text,
          "Employer's contact details",
          "Street / Town / City " + address,
          "Postcode " + postCode.text)
      }).flatten ++
      (y \\ "Pay").
      map(x => {
      Seq((x \\ "WeeklyHoursWorked" \\ "QuestionLabel").text+" "+(x \\ "WeeklyHoursWorked" \\ "Answer").text)
      }).flatten
      )
      ).flatten
  }
}
