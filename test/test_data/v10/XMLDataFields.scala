package test_data.v10

import scala.xml.Elem
import utils.TestUtils


case class XMLDataFields(xml: Elem) extends TestUtils{

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim"

  val transactionPath = xml \\ "DWPCATransaction" \\ "TransactionId"

  val serviceVersion = xml \\ "Version"

  val titleQuestion = rootPath \\ "Claimant" \\ "Title" \\ "QuestionLabel"

  val titleAnswer = rootPath \\ "Claimant" \\ "Title" \\ "Answer"

  val claimantMiddleNameAnswer = rootPath \\ "Claimant" \\ "MiddleNames" \\ "Answer"

  val claimantMiddleNamesQuestion = rootPath \\ "Claimant" \\ "MiddleNames" \\ "QuestionLabel"

  val surNameAnswer = rootPath \\ "Claimant" \\ "Surname" \\ "Answer"

  val surNameQuestion = rootPath \\ "Claimant" \\ "Surname" \\ "QuestionLabel"

  val nationalInsuranceNumberAnswer = rootPath \\ "Claimant" \\ "NationalInsuranceNumber" \\ "Answer"

  val nationalInsuranceNumberQuestion = rootPath \\ "Claimant" \\ "NationalInsuranceNumber" \\ "QuestionLabel"

  val firstNameAnswer = rootPath \\ "Claimant" \\ "OtherNames" \\ "Answer"

  val firstNameQuestion = rootPath \\ "Claimant" \\ "OtherNames" \\ "QuestionLabel"

  val careeLastNameAnswer = rootPath \\ "Caree" \\ "Surname" \\ "Answer"

  val careeLastNameQuestion = rootPath \\ "Caree" \\ "Surname" \\ "QuestionLabel"

  val careeFirstNameAnswer = rootPath \\ "Caree" \\ "OtherNames" \\ "Answer"

  val careeFirstNameQuestion = rootPath \\ "Caree" \\ "OtherNames" \\ "QuestionLabel"

  val careeMiddleNameAnswer = rootPath \\ "Caree" \\ "MiddleNames" \\ "Answer"

  val careeMiddleNameQuestion = rootPath \\ "Caree" \\ "MiddleNames" \\ "QuestionLabel"

  val careeTitleAnswer = rootPath \\ "Caree" \\ "Title" \\ "Answer"

  val dateClaimReceived = xml \\ "DWPCATransaction" \\ "DateTimeGenerated"

  val addressCarerAnswer = (rootPath \\ "Claimant" \\ "Address" \\ "Answer" \\ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val addressCarerQuestion = (rootPath \\ "Claimant" \\ "Address" \\ "QuestionLabel")

  val postCodeCarer = rootPath \\ "Claimant" \\ "Address" \\ "PostCode"

  val addressCareeAnswer = (rootPath \\ "Caree" \\ "Address" \\ "Line" \\ "Answer").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val postCodeCaree = rootPath \\ "Caree" \\ "Address" \\ "PostCode"

  val nationalityAnswer = SectionPart1AboutYouTheCarer(xml: Elem).nationalityAnswer

  val qualifyingBenefitAnswer = rootPath \ "QualifyingBenefit" \ "Answer"

  val nationalityQuestion = SectionPart1AboutYouTheCarer(xml: Elem).nationalityQuestion

  val receiveEEAPensionsBenefitsQuestion = SectionPart1AboutYouTheCarer(xml: Elem).receiveEEAPensionsBenefitsQuestion

  val receiveEEAPensionsBenefitsAnswer = SectionPart1AboutYouTheCarer(xml: Elem).receiveEEAPensionsBenefitsAnswer

  val timeOutsideGBLast3YearsQuestion =  xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Residency" \\ "TimeOutsideGBLast3Years" \\ "QuestionLabel[0]"

  val timeOutsideGBLast3YearsAnswer = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Residency" \\ "TimeOutsideGBLast3Years" \\ "Answer[0]"

  val reasonTimeAbroadOther = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Residency" \\ "Reason" \\ "Other"

  val statePensionQuestion = SectionPart1AboutYouTheCarer(xml: Elem).statePensionQuestion

  val statePensionAnswer = SectionPart1AboutYouTheCarer(xml: Elem).statePensionAnswer

  val otherInformationWelshCommunicationQuestion = SectionConsentAndDeclaration(xml).otherInformationWelshCommunicationQuestion

  val otherInformationWelshCommunicationAnswer = SectionConsentAndDeclaration(xml).otherInformationWelshCommunicationAnswer

  val otherInformationAddtionalInformationQuestion = SectionConsentAndDeclaration(xml).otherInformationAdditionalInformationQuestion

  val otherInformationAddtionalInformationAnswer = SectionConsentAndDeclaration(xml).otherInformationAdditionalInformationAnswer

  val dateOfClaimQuestion = rootPath \\ "DateOfClaim" \\ "QuestionLabel"

  val dateOfClaimAnswer = rootPath \\ "DateOfClaim" \\ "Answer"

  val careBreak: Seq[String] = {
    (rootPath \\ "Caree" \\ "CareBreak").
      map(x => {
      val fromDate: Seq[String] = Seq((x \\ "StartDate" \\ "QuestionLabel").text + " " + (x \\ "StartDate" \\ "Answer").text)
      val toDate: Seq[String] = (x \\ "EndDate").text.isEmpty match {
        case true => Seq()
        case false => Seq((x \\ "EndDate" \\ "QuestionLabel").text + " " + (x \\ "EndDate" \\ "Answer").text)
      }
      val otherData = Seq(
         buildQuestion((x \\ "BreaksSinceClaim" \\ "QuestionLabel").text, (x \\ "BreaksSinceClaim" \\ "Answer").text),
         buildQuestion((x \\ "ReasonClaimant" \\ "QuestionLabel").text,(x \\ "ReasonClaimant" \\ "Answer").text),
         (x \\ "ReasonClaimant" \\ "Other" \\ "Answer").text,
        buildQuestion((x \\ "ReasonCaree" \\ "QuestionLabel").text,(x \\ "ReasonCaree" \\ "Answer").text),
        buildQuestion((x \\ "MedicalCare" \\ "QuestionLabel").text,(x \\ "MedicalCare" \\ "Answer").text),
        buildQuestion((x \\ "StartTime" \\ "QuestionLabel").text, (x \\ "StartTime" \\ "Answer").text),
        buildQuestion((x \\ "EndTime" \\ "QuestionLabel").text, (x \\ "EndTime" \\ "Answer").text)
      )
      (fromDate ++ toDate).filterNot(x => x.isEmpty) ++ otherData
    }).filterNot(x => x.isEmpty).flatten
  }
}
