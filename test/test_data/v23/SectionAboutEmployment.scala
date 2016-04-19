package test_data.v23

import scala.xml.Elem


case class SectionAboutEmployment(xml: Elem) {

  val rootPathJobDetails = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Employment" \\ "JobDetails"

  val address = (rootPathJobDetails \\ "Employer" \\ "Address" \\ "Answer" \\"Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val postCode = rootPathJobDetails \\ "Employer" \\ "Address" \\ "Answer" \\ "PostCode"

  val employmentDetails: Seq[String] = {
    (rootPathJobDetails
      map (y =>
      (y \\ "Employer").
        map(x => {
        Seq((x \\ "CurrentlyEmployed" \ "QuestionLabel").text+" "+(x \\ "CurrentlyEmployed" \ "Answer").text,
          (x \\ "Name" \\ "QuestionLabel").text+ " "+(x \\ "Name" \\ "Answer").text,
          (x \\ "DidJobStartBeforeClaimDate" \\ "QuestionLabel").text+ " "+(x \\ "DidJobStartBeforeClaimDate" \\ "Answer").text,
          (x \\ "DateJobStarted" \\ "QuestionLabel").text+" "+(x \\ "DateJobStarted" \\ "Answer").text,
          (x \\ "DateJobEnded" \\ "QuestionLabel").text+" "+(x \\ "DateJobEnded" \\ "Answer").text,
          (x \\ "P45LeavingDate" \\ "QuestionLabel").text+" "+(x \\ "P45LeavingDate" \\ "Answer").text,
          "Employer's contact details",
          (x \\ "Address" \\ "QuestionLabel").text+" "+(x \\ "Address" \\ "Answer" \\"Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" "),
          (x \\ "Address" \\ "Answer" \\ "PostCode").text,
          (x \\ "EmployersPhoneNumber" \\ "QuestionLabel").text+" "+(x \\ "EmployersPhoneNumber" \\ "Answer").text,
          (x \\ "JobType" \\ "QuestionLabel").text+" "+(x \\ "JobType" \\ "Answer").text
        )
      }).flatten ++
      (y \\ "Pay").
      map(x => {
      Seq((x \\ "WeeklyHoursWorked" \\ "QuestionLabel").text+" "+(x \\ "WeeklyHoursWorked" \\ "Answer").text,
         "Your last wage",
        (x \\ "DateLastPaid" \\ "QuestionLabel").text+" "+(x \\ "DateLastPaid" \\ "Answer").text,
        (x \\ "GrossPayment" \\ "QuestionLabel").text+" "+(x \\ "GrossPayment" \\ "Answer" \\ "Amount").text,
        (x \\ "IncludedInWage" \\ "QuestionLabel").text+" "+(x \\ "IncludedInWage" \\ "Answer").text,
        (x \\ "ConstantEarnings" \\ "QuestionLabel").text+" "+(x \\ "ConstantEarnings" \\ "Answer").text,
        "Additional details on your last wage",
        (x \\ "PayFrequency" \\ "QuestionLabel").text+" "+(x \\ "PayFrequency" \\ "Answer").text,
        (x \\ "PayFrequency" \\ "Other").text,
        (x \\ "UsualPayDay" \\ "QuestionLabel").text+" "+(x \\ "UsualPayDay" \\ "Answer").text
        )
      }).flatten ++
      (y).map(x => {
        Seq((x \\ "OweMoney" \\ "QuestionLabel").text+" "+(x \\ "OweMoney" \\ "Answer").text,
            "Pension And Expenses",
            (x \\ "PaidForPension" \\ "QuestionLabel").text+" "+(x \\ "PaidForPension" \\ "Answer").text,
            (x \\ "PensionExpenses" \\ "Expense" \\ "QuestionLabel").text+" "+(x \\ "PensionExpenses" \\ "Expense" \\ "Answer" ).text,
            (x \\ "PaidForThingsToDoJob" \\ "QuestionLabel").text+" "+(x \\ "PaidForThingsToDoJob" \\ "Answer").text,
            (x \\ "ExpensesToDoJob" \\ "Expense" \\ "QuestionLabel").text+" "+(x \\ "ExpensesToDoJob" \\ "Expense" \\ "Answer" ).text,
            (x \\ "PaidForJobExpenses" \\ "QuestionLabel").text+" "+(x \\ "PaidForJobExpenses" \\ "Answer").text,
            (x \\ "JobExpenses" \\ "Expense" \\ "QuestionLabel").text+" "+(x \\ "JobExpenses" \\ "Expense" \\ "Answer").text
           )
      }).flatten
      )
      ).flatten
  }
}
