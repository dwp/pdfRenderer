package test_data

import scala.xml.Elem
import utils.TestUtils


case class XMLDataFields(xml: Elem) extends TestUtils{

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim"

  val transactionPath = xml \\ "DWPCATransaction" \\ "TransactionId"

  val title = rootPath \\ "Claimant" \\ "Title"

  val claimantOtherSurnames = rootPath \\ "Claimant" \\ "OtherSurnames"

  val surName = rootPath \\ "Claimant" \\ "Surname"

  val nationalInsuranceNumber = rootPath \\ "Claimant" \\ "NationalInsuranceNumber"

  val firstName = rootPath \\ "Claimant" \\ "OtherNames"

  val careeLastName = rootPath \\ "Caree" \\ "Surname"

  val careeFirstName = rootPath \\ "Caree" \\ "OtherNames"

  val careeTitle = rootPath \\ "Caree" \\ "Title"

  val dateClaimReceived = xml \\ "DWPCATransaction" \\ "DateTimeGenerated"

  val addressCarer = (rootPath \\ "Claimant" \\ "Address" \\ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val postCodeCarer = rootPath \\ "Claimant" \\ "Address" \\ "PostCode"

  val addressCaree = (rootPath \\ "Caree" \\ "Address" \\ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val postCodeCaree = rootPath \\ "Caree" \\ "Address" \\ "PostCode"

  val parnerNINO = rootPath \\ "Partner" \\ "NationalInsuranceNumber"

  val partnerSurname = rootPath \\ "Partner" \\ "Surname"

  val partnerOtherNames = rootPath \\ "Partner" \\ "OtherNames"

  val partnerTitle = rootPath \\ "Partner" \\ "Title"

  val partnerOtherSurnames = rootPath \\ "Partner" \\ "OtherSurnames"

  val careBreak: Seq[String] = {
    (rootPath \\ "Caree" \\ "CareBreak").
      map(x => {
      val fromDate: Seq[String] = Seq("From date and time " + (x \\ "StartDateTime").text)
      val toDate: Seq[String] = (x \\ "EndDateTime").text.isEmpty match {
        case true => Seq()
        case false => Seq("To date and time " + (x \\ "EndDateTime").text)
      }
      val otherData = Seq(
         buildQuestion((x \\ "ReasonClaimant" \\ "QuestionLabel").text,(x \\ "ReasonClaimant" \\ "Answer").text),
         (x \\ "ReasonClaimant" \\ "Other").text,
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
