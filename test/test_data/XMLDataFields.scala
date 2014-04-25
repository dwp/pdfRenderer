package test_data

import scala.xml.Elem
import utils.TestUtils


case class XMLDataFields(xml: Elem) extends TestUtils{

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim"

  val transactionPath = xml \\ "DWPCATransaction" \\ "TransactionId"

  val titleQuestion = rootPath \\ "Claimant" \\ "Title" \\ "QuestionLabel"

  val titleAnswer = rootPath \\ "Claimant" \\ "Title" \\ "Answer"

  val claimantOtherSurnamesAnswer = rootPath \\ "Claimant" \\ "OtherSurnames" \\ "Answer"

  val claimantOtherSurnamesQuestion = rootPath \\ "Claimant" \\ "OtherSurnames" \\ "QuestionLabel"

  val surNameAnswer = rootPath \\ "Claimant" \\ "Surname" \\ "Answer"

  val surNameQuestion = rootPath \\ "Claimant" \\ "Surname" \\ "QuestionLabel"

  val nationalInsuranceNumberAnswer = rootPath \\ "Claimant" \\ "NationalInsuranceNumber" \\ "Answer"

  val nationalInsuranceNumberQuestion = rootPath \\ "Claimant" \\ "NationalInsuranceNumber" \\ "QuestionLabel"

  val firstNameAnswer = rootPath \\ "Claimant" \\ "OtherNames" \\ "Answer"

  val firstNameQuestion = rootPath \\ "Claimant" \\ "OtherNames" \\ "QuestionLabel"

  val careeLastNameAnswer = rootPath \\ "Caree" \\ "Surname" \\ "Answer"

  val careeFirstNameAnswer = rootPath \\ "Caree" \\ "OtherNames" \\ "Answer"

  val careeTitleAnswer = rootPath \\ "Caree" \\ "Title" \\ "Answer"

  val dateClaimReceived = xml \\ "DWPCATransaction" \\ "DateTimeGenerated"

  val addressCarerAnswer = (rootPath \\ "Claimant" \\ "Address" \\ "Answer" \\ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val addressCarerQuestion = (rootPath \\ "Claimant" \\ "Address" \\ "QuestionLabel")

  val postCodeCarer = rootPath \\ "Claimant" \\ "Address" \\ "PostCode"

  val addressCareeAnswer = (rootPath \\ "Caree" \\ "Address" \\ "Line" \\ "Answer").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val postCodeCaree = rootPath \\ "Caree" \\ "Address" \\ "PostCode"

  val parnerNINOAnswer = rootPath \\ "Partner" \\ "NationalInsuranceNumber" \\ "Answer"

  val parnerNINOQuestion = rootPath \\ "Partner" \\ "NationalInsuranceNumber" \\ "QuestionLabel"

  val partnerSurnameAnswer = rootPath \\ "Partner" \\ "Surname" \\ "Answer"

  val partnerSurnameQuestion = rootPath \\ "Partner" \\ "Surname" \\ "QuestionLabel"

  val partnerOtherNamesAnswer = rootPath \\ "Partner" \\ "OtherNames" \\ "Answer"

  val partnerOtherNamesQuestion = rootPath \\ "Partner" \\ "OtherNames" \\ "QuestionLabel"

  val partnerTitleAnswer = rootPath \\ "Partner" \\ "Title" \\ "Answer"

  val partnerTitleQuestion = rootPath \\ "Partner" \\ "Title" \\ "QuestionLabel"

  val partnerOtherSurnamesAnswer = rootPath \\ "Partner" \\ "OtherSurnames" \\ "Answer"

  val partnerOtherSurnamesQuestion = rootPath \\ "Partner" \\ "OtherSurnames" \\ "QuestionLabel"

  val nationalityAnswer = SectionPart1AboutYouTheCarer(xml: Elem).nationalityAnswer

  val nationalityQuestion = SectionPart1AboutYouTheCarer(xml: Elem).nationalityQuestion

  val receiveEEAPensionsBenefitsQuestion = SectionPart1AboutYouTheCarer(xml: Elem).receiveEEAPensionsBenefitsQuestion

  val receiveEEAPensionsBenefitsAnswer = SectionPart1AboutYouTheCarer(xml: Elem).receiveEEAPensionsBenefitsAnswer

  val timeOutsideGBLast3YearsQuestion =  xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Residency" \\ "TimeOutsideGBLast3Years" \\ "QuestionLabel[0]"

  val timeOutsideGBLast3YearsAnswer = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Residency" \\ "TimeOutsideGBLast3Years" \\ "Answer[0]"

  val statePensionQuestion = SectionPart1AboutYouTheCarer(xml: Elem).statePensionQuestion

  val statePensionAnswer = SectionPart1AboutYouTheCarer(xml: Elem).statePensionAnswer

  val otherInformationWelshCommunicationQuestion = SectionConsentAndDeclaration(xml).otherInformationWelshCommunicationQuestion

  val otherInformationWelshCommunicationAnswer = SectionConsentAndDeclaration(xml).otherInformationWelshCommunicationAnswer

  val careBreak: Seq[String] = {
    (rootPath \\ "Caree" \\ "CareBreak").
      map(x => {
      val fromDate: Seq[String] = Seq((x \\ "StartDateTime" \\ "QuestionLabel").text + " " + (x \\ "StartDateTime" \\ "Answer").text)
      val toDate: Seq[String] = (x \\ "EndDateTime").text.isEmpty match {
        case true => Seq()
        case false => Seq((x \\ "EndDateTime" \\ "QuestionLabel").text + " " + (x \\ "EndDateTime" \\ "Answer").text)
      }
      val otherData = Seq(
         buildQuestion((x \\ "ReasonClaimant" \\ "QuestionLabel").text,(x \\ "ReasonClaimant" \\ "Answer").text),
         (x \\ "ReasonClaimant" \\ "Other" \\ "Answer").text,
        buildQuestion((x \\ "ReasonCaree" \\ "QuestionLabel").text,(x \\ "ReasonCaree" \\ "Answer").text),
        buildQuestion((x \\ "MedicalCare" \\ "QuestionLabel").text,(x \\ "MedicalCare" \\ "Answer").text)
      )
      (fromDate ++ toDate).filterNot(x => x.isEmpty) ++ otherData
    }).filterNot(x => x.isEmpty).flatten ++
    (rootPath \\ "Caree").
      map(x => {
      Seq (
        (x \\ "BreaksSinceClaim" \\ "QuestionLabel").text+" "+(x \\ "BreaksSinceClaim" \\ "Answer").text
      )
    }).flatten
  }
}
