package test_data.v9

import scala.xml.Elem


case class SectionAboutTheCareYouProvide(xml: Elem) {

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "Caree"

  val nationalInsuranceNumber = rootPath \\ "NationalInsuranceNumber"

  val dateOfBirth = rootPath \\ "DateOfBirth"

  val liveSameAddressQuestion = rootPath \\ "LiveSameAddress" \\ "QuestionLabel"

  val liveSameAddressAnswer = rootPath \\ "LiveSameAddress" \\ "Answer"

  val dayTimeTelephoneNumber = rootPath \\ "DayTimePhoneNumber"

  val relationToClaimantQuestion = rootPath \\ "RelationToClaimant" \\ "QuestionLabel"

  val relationToClaimantAnswer = rootPath \\ "RelationToClaimant" \\ "Answer"

  val cared35HoursQuestion = rootPath \\ "Cared35Hours" \\ "QuestionLabel"

  val cared35HoursAnswer = rootPath \\ "Cared35Hours" \\ "Answer"

  val cared35HoursBeforeQuestion = rootPath \\ "Cared35HoursBefore" \\ "QuestionLabel"

  val cared35HoursBeforeAnswer = rootPath \\ "Cared35HoursBefore" \\ "Answer"

  val dateStartedCaringQuestion = rootPath \\ "DateStartCaring" \\ "QuestionLabel"

  val dateStartedCaringAnswer = rootPath \\ "DateStartCaring" \\ "Answer"

  val breaksInCareQuestion = rootPath \\ "BreaksSinceClaim" \\ "QuestionLabel"

  val breaksInCareAnswer = rootPath \\ "BreaksSinceClaim" \\ "Answer"

  val careeLastName = rootPath  \\ "Surname"

  val careeFirstName = rootPath  \\ "OtherNames"

  val careeTitle = rootPath  \\ "Title"

  val addressCaree = (rootPath \\ "Address" \\ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val postCodeCaree = rootPath \\ "Address" \\ "PostCode"

}
