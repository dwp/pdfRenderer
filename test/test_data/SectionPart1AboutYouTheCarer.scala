package test_data

import scala.xml.Elem

case class SectionPart1AboutYouTheCarer(xml: Elem) {

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Claimant"

  val rootPathResidency = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Residency"

  val title = rootPath \\ "Title"

  val firstName = rootPath  \\ "OtherNames"

  val lastName = rootPath  \\ "Surname"

  val otherSurnameOrMaidenName = rootPath  \\ "OtherSurnames"

  val nationalInsuranceNumber	= rootPath  \\ "NationalInsuranceNumber"

  val dateOfBirth = rootPath \\ "DateOfBirth"

  val maritalStatus =	rootPath \\ "MaritalStatus"

  val dateOfClaimQuestion = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "DateOfClaim" \\ "QuestionLabel"

  val dateOfClaimAnswer = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "DateOfClaim" \\ "Answer"

  val address = (rootPath \\ "Address" \\ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString("\n")

  val postCode = rootPath \\ "Address" \\ "PostCode"

  val dayTimeTelephoneNumber	= rootPath \\ "DayTimePhoneNumber"

  val mobileNumber = rootPath \\ "MobileNumber"

  val speechOrHearingDifficultyQuestion = rootPath \\ "TextPhoneContact" \\ "QuestionLabel"

  val speechOrHearingDifficultyAnswer = rootPath \\ "TextPhoneContact" \\ "Answer"

  val nationality =  rootPathResidency \\ "Nationality"

  val doYouLiveEnglandScotlandWalesQuestion = rootPathResidency \\ "NormallyLiveInGB" \\ "QuestionLabel"

  val doYouLiveEnglandScotlandWalesAnswer = rootPathResidency \\ "NormallyLiveInGB" \\ "Answer"

  val countryNormallyLiveInQuestion = rootPathResidency \\ "CountryNormallyLive" \\ "QuestionLabel"

  val countryNormallyLiveInAnswer = rootPathResidency \\ "CountryNormallyLive" \\ "Answer"

  val timeOutsideGBLast3YearsQuestion = rootPathResidency \\ "TimeOutsideGBLast3Years" \\ "QuestionLabel"

  val timeOutsideGBLast3YearsAnswer = rootPathResidency \\ "TimeOutsideGBLast3Years" \\ "Answer"

  val periodAbroadDateFromQuestion = rootPathResidency \\ "PeriodAbroad" \\ "Period" \\ "DateFrom" \\ "QuestionLabel"

  val periodAbroadDateFromAnswer = rootPathResidency \\ "PeriodAbroad" \\ "Period" \\ "DateFrom" \\ "Answer"

  val periodAbroad: Seq[String] = {
    (rootPathResidency \\ "PeriodAbroad"
      map (y =>
          (y \\ "Period").
            map(x => {
              Seq((x \\ "DateFrom" \\ "QuestionLabel").text+" "+(x \\ "DateFrom" \\ "Answer").text,
              (x \\ "DateTo" \\ "QuestionLabel").text+" "+(x \\ "DateTo" \\ "Answer").text)
          }).flatten ++
          (y \\ "Reason").
              map(x => {
                  Seq((x \\ "QuestionLabel").text+" "+
                    (x \\ "Answer").text match {
                      case "Other" => (x \\ "Other").text +" "+ (x \\ "Answer").text
                      case _ => (x \\ "Answer").text
                  })
          }).flatten ++
          (y \\ "Country").
            map(x => {
              Seq((x \\ "QuestionLabel").text+" "+(x \\ "Answer").text)
          }).flatten ++
          (y \\ "CareePresent").
            map(x => {
              Seq((x \\ "QuestionLabel").text+" "+(x \\ "Answer").text)
          }).flatten
        )
      ).flatten
  }

  val periodAbroad1: Seq[Object] = {
    (rootPathResidency \\ "PeriodAbroad"
      map (y =>
//      (y \\ "Period").
//        map(x => {
//        Seq((x \\ "DateFrom" \\ "QuestionLabel").text+" "+(x \\ "DateFrom" \\ "Answer").text)
//        Seq((x \\ "DateTo" \\ "QuestionLabel").text+" "+(x \\ "DateTo" \\ "Answer").text)
//      }).flatten ++
//        (y \\ "Reason").
//          map(x => {
//          Seq((x \\ "QuestionLabel").text+" "+
//            (x \\ "Answer").text match {
//            case "Other" => (x \\ "Other").text +" "+ (x \\ "Answer").text
//            case _ => (x \\ "Answer").text
//          })
//        }).flatten ++
//        (y \\ "Country").
//          map(x => {
//          Seq((x \\ "QuestionLabel").text+" "+(x \\ "Answer").text)
//        }).flatten ++
        (y \\ "CareePresent").
          map(x => {
          (x \\ "QuestionLabel").text+" "+(x \\ "Answer").text
        })
      )
      ).flatten
  }



  /*

  Money you get from other European Economic Area (EEA) countries or Switzerland
    Do you, or any member of your family, receive any benefits or pensions from a European Economic Area (EEA) state or Switzerland?	DWPCAClaim>OtherBenefits>EEAPensionBenefits
    Have you, or a member  of your family, made a claim for any benefits or pensions from a European Economic Area (EEA) state or Switzerland?
  Are you, or a member of your family, working in or paying insurance to, another European Economic Area (EEA) state or Switzerland?	DWPCAClaim>OtherBenefits>EEAWorkingInsurance
    More about you
  Have you had a partner/spouse living with you since your claim date?: <ddmmyyyy>?	DWPCAClaim>HavePartner
    Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? Have you been on a course of education since your claim date:<ddmmyyyy>? 	DWPCAClaim>CourseofEducation
      Do you get State Pension?	DWPCAClaim>OtherBenefits>ClaimantBenefits>StatePension
      Employment
      Have you been employed at any time since <ddmmyyyy_1> (this is six months before your claim date:< ddmmyyyy>)?	DWPCAClaim>Employed
        Have you been self-employed at any time since <ddmmyyyy_2> (this is one week before your claim date:<ddmmyyyy>)?	DWPCAClaim>SelfEmployed
 */



          }
