package test_data

import scala.xml.Elem

case class SectionPart1AboutYouTheCarer(xml: Elem) {

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Claimant"

  val title = rootPath \\ "Title"

  val firstName = rootPath  \\ "OtherNames"

  val lastName = rootPath  \\ "Surname"

  //val otherSurnameOrMaidenName = rootPath  \\ "OtherSurnames"

  //val nationalInsuranceNumber	= rootPath  \\ "NationalInsuranceNumber"

  //val dateOfBirth = rootPath \\ "DateofBirth"

  //val martialStatus =	rootPath \\ "MartialStatus"

  //val dateOfClaim = rootPath \\ "DateofClaim"

  val address = (rootPath \\ "Address" \\ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString("\n")

  val postCode = rootPath \\ "Address" \\ "PostCode"

/*
  Daytime telephone number	DWPCAClaim>Claimant>DayTimePhoneNumber
    Mobile number	DWPCAClaim>Claimant>MobileNumber
  If you have speech or hearing difficulties, would you like us to contact you by textphone?	DWPCAClaim>Claimant>TextPhoneContact
  Your nationality and residency
    What is your nationality	DWPCAClaim>Residency>Nationality
  Do you live in England, Scotland or Wales	DWPCAClaim>Residency>NormallyLiveInGB
    Which country do you normally live in	DWPCAClaim>Residency>CountryNormallyLive
  Time outside of England, Scotland or Wales
  Have you spent any time outside England, Scotland or Wales in the last 3 years before your claim date <<ddmmyyyy>>?	DWPCAClaim>Residency>TimeOutsideGBLast3Years
    -->>  Outside England, Scotland and Wales X
    -->> Which country did you go to?	DWPCAClaim>Residency>PeriodAbroad>Country
  -->> Date you left	DWPCAClaim>Residency>PeriodAbroad>Period>DateFrom
  -->> Date you returned	DWPCAClaim>Residency>PeriodAbroad>Period>DateTo
  -->> Reason for being there?	DWPCAClaim>Residency>PeriodAbroad>Period>Reason
    -->> Other	DWPCAClaim>Residency>PeriodAbroad>Period>Reason>Other
  -->> Was the person you care for with you?	DWPCAClaim>Residency>PeriodAbroad>CareePresent
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
