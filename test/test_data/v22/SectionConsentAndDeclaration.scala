package test_data.v22

import scala.xml.Elem

case class SectionConsentAndDeclaration(xml: Elem) {

  val rootPath = xml \ "DWPCATransaction" \ "DWPCAClaim"

  val otherInformationAdditionalInformationQuestion = xml \ "DWPCATransaction" \ "DWPCAClaim" \ "OtherInformation" \ "AdditionalInformation" \ "QuestionLabel"
  val otherInformationAdditionalInformationAnswer = xml \ "DWPCATransaction" \ "DWPCAClaim" \ "OtherInformation" \ "AdditionalInformation" \ "Answer"
  val otherInformationWelshCommunicationQuestion = xml \ "DWPCATransaction" \ "DWPCAClaim" \ "OtherInformation" \ "WelshCommunication" \ "QuestionLabel"
  val otherInformationWelshCommunicationAnswer = xml \ "DWPCATransaction" \ "DWPCAClaim" \ "OtherInformation" \ "WelshCommunication" \ "Answer"

  val consent = xml \ "DWPCATransaction" \ "DWPCAClaim" \ "Consents" \ "Consent"

  val disclaimerStatement = xml \ "DWPCATransaction" \ "DWPCAClaim" \ "Disclaimer" \ "DisclaimerStatement"
  val disclaimerQuestion = xml \ "DWPCATransaction" \ "DWPCAClaim" \ "Disclaimer" \ "DisclaimerQuestion"

  val declarationStatement = xml \ "DWPCATransaction" \ "DWPCAClaim" \ "Declaration" \ "DeclarationStatement"
  val declarationQuestion = xml \ "DWPCATransaction" \ "DWPCAClaim" \ "Declaration" \ "DdclarationQuestion"

}
