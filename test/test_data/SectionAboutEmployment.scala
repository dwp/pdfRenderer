package test_data

import scala.xml.Elem


case class SectionAboutEmployment(xml: Elem) {

  val rootPathJobDetails = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Employment" \\ "JobDetails"

  val areYouEmployedQuestion = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Employed" \\ "QuestionLabel"

  val areYouEmployedAnswer = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Employed" \\ "Answer"

  val address = (rootPathJobDetails \\ "Employer" \\ "Address" \\ "Answer" \\"Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val postCode = rootPathJobDetails \\ "Employer" \\ "Address" \\ "Answer" \\ "PostCode"

  val currentlyEmployedQuestion = xml \ "DWPCATransaction" \ "DWPCAClaim" \ "Employment" \ "JobDetails" \ "Employer" \ "CurrentlyEmployed" \ "QuestionLabel"

  val currentlyEmployedAnswer = xml \ "DWPCATransaction" \ "DWPCAClaim" \ "Employment" \ "JobDetails" \ "Employer" \ "CurrentlyEmployed" \ "Answer"


  val employmentDetails: Seq[String] = {
    (rootPathJobDetails
      map (y =>
      (y \\ "Employer").
        map(x => {
        Seq((x \\ "Name" \\ "QuestionLabel").text+ " "+(x \\ "Name" \\ "Answer").text,
          (x \\ "DateJobStarted" \\ "QuestionLabel").text+" "+(x \\ "DateJobStarted" \\ "Answer").text,
          (x \\ "DateJobEnded" \\ "QuestionLabel").text+" "+(x \\ "DateJobEnded" \\ "Answer").text,
          (x \\ "P45LeavingDate" \\ "QuestionLabel").text+" "+(x \\ "P45LeavingDate" \\ "Answer").text,
          (x \\ "ClockPayrollNumber" \\ "QuestionLabel").text+" "+(x \\ "ClockPayrollNumber" \\ "Answer").text,
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
            "Pension schemes",
            (x \\ "PaidForOccupationalPension" \\ "QuestionLabel").text+" "+(x \\ "PaidForOccupationalPension" \\ "Answer").text,
            (x \\ "OccupationalPension" \\ "Payment" \\ "QuestionLabel").text+" "+(x \\ "OccupationalPension" \\ "Payment" \\ "Answer" \\ "Amount").text,
            (x \\ "OccupationalPension" \\ "Frequency" \\ "QuestionLabel").text+" "+(x \\ "OccupationalPension" \\ "Frequency" \\ "Answer").text,
            (x \\ "OccupationalPension" \\ "Frequency" \\ "Other").text,
            (x \\ "PaidForPersonalPension" \\ "QuestionLabel").text+" "+(x \\ "PaidForPersonalPension" \\ "Answer").text,
            (x \\ "PersonalPension" \\ "Payment" \\ "QuestionLabel").text+" "+(x \\ "PersonalPension" \\ "Payment" \\ "Answer" \\ "Amount").text,
            (x \\ "PersonalPension" \\ "Frequency" \\ "QuestionLabel").text+" "+(x \\ "PersonalPension" \\ "Frequency" \\ "Answer").text,
            (x \\ "PersonalPension" \\ "Frequency" \\ "Other").text,
            "About expenses to do with your employment",
            (x \\ "PaidForJobExpenses" \\ "QuestionLabel").text+" "+(x \\ "PaidForJobExpenses" \\ "Answer").text,
            (x \\ "CareExpensesChildren" \\ "QuestionLabel").text+" "+(x \\ "CareExpensesChildren" \\ "Answer").text,
            (x \\ "CareExpensesCaree" \\ "QuestionLabel").text+" "+(x \\ "CareExpensesCaree" \\ "Answer").text,
            "Necessary expenses to do your job",
            (x \\ "JobExpenses" \\ "Expense" \\ "QuestionLabel").text+" "+(x \\ "JobExpenses" \\ "Expense" \\ "Answer").text
           )
      }).flatten ++
        (y \\ "ChildCareExpenses").
          map(x => {
           Seq("Childcare expenses while you are at work",
             (x \\ "CarerName" \\ "QuestionLabel").text+" "+(x \\ "CarerName" \\ "Answer").text,
             (x \\ "Expense" \\ "Payment" \\ "QuestionLabel").text+" "+(x \\ "Expense" \\ "Payment" \\ "Answer" \\ "Amount").text,
             (x \\ "Expense" \\ "Frequency" \\ "QuestionLabel").text+" "+(x \\ "Expense" \\ "Frequency" \\ "Answer").text,
             (x \\ "Expense" \\ "Frequency" \\ "Other").text,
             (x \\ "RelationshipCarerToClaimant" \\ "QuestionLabel").text+" "+(x \\ "RelationshipCarerToClaimant" \\ "Answer").text,
             (x \\ "RelationshipCarerToPartner" \\ "QuestionLabel").text+" "+(x \\ "RelationshipCarerToPartner" \\ "Answer").text,
             (x \\ "RelationshipCarerToPartner" \\ "Other").text,
             (x \\ "RelationToChild" \\ "QuestionLabel").text+" "+(x \\ "RelationToChild" \\ "Answer").text
           )
        }).flatten ++
        (y \\ "CareExpenses").
         map(x =>{
          Seq("Expenses related to the person you care for, while you are at work",
            (x \\ "CareExpensesCaree" \\ "QuestionLabel").text+" "+(x \\ "CareExpensesCaree" \\ "Answer").text,
            (x \\ "CarerName" \\ "QuestionLabel").text+" "+(x \\ "CarerName" \\ "Answer").text,
            (x \\ "Expense" \\ "Payment" \\ "QuestionLabel").text+" "+(x \\ "Expense" \\ "Payment" \\ "Answer" \\ "Amount").text,
            (x \\ "Expense" \\ "Frequency" \\ "QuestionLabel").text+" "+(x \\ "Expense" \\ "Frequency" \\ "Answer").text,
            (x \\ "Expense" \\ "Frequency" \\ "Other").text,
            (x \\ "RelationshipCarerToClaimant" \\ "QuestionLabel").text+" "+(x \\ "RelationshipCarerToClaimant" \\ "Answer").text,
            (x \\ "RelationshipCarerToClaimant" \\ "Other").text,
            (x \\ "RelationshipCarerToPartner" \\ "QuestionLabel").text+" "+(x \\ "RelationshipCarerToPartner" \\ "Answer").text,
            (x \\ "RelationshipCarerToPartner" \\ "Other").text,
            (x \\ "RelationshipCarerToCaree" \\ "QuestionLabel").text+" "+(x \\ "RelationshipCarerToCaree" \\ "Answer").text,
            (x \\ "RelationshipCarerToCaree" \\ "Other").text
          )
        }).flatten
      )
      ).flatten
  }
}
