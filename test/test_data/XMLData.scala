package test_data

import scala.xml.Elem


object XMLData {
  def madeUpField(xml: Elem) = {
    Seq(
      "I am an invalid field that should never appear in the pdf"
    )
  }

  def functionalTestCase1(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml)
  }

  def functionalTestCase2(xml: Elem) = {
    val fields = XMLDataFields(xml)
    val aboutYouTheCarer = Seq(
      "Other surname or maiden name " + fields.claimantOtherSurnames.text
    )
    val aboutYourPartner = Seq(
      "National Insurance Number " + fields.parnerNINO.text,
      "Last name " + fields.partnerSurname.text,
      "First name(s) " + fields.partnerOtherNames.text,
      "Title " + fields.partnerTitle.text,
      "Other surname or maiden name " + fields.partnerOtherSurnames.text
    )

    functionalTestCaseMandatoryFields(xml) ++ aboutYouTheCarer ++ aboutYourPartner
  }

  def functionalTestCase3(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml)
  }

  def functionalTestCase4(xml: Elem): Seq[String] = {
    val fields = XMLDataFields(xml)
    val aboutYouTheCarer = Seq(
      "Other surname or maiden name " + fields.claimantOtherSurnames.text
    )

    functionalTestCaseMandatoryFields(xml) ++ aboutYouTheCarer
  }

  def functionalTestCase5(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml)
  }

  def functionalTestCase6(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml)
  }

  def functionalTestCase7(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml)
  }

  def functionalTestCase8(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml)
  }

  def functionalTestCase9(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml)
  }

  def functionalTestCaseMandatoryFields(xml: Elem) = {
    val fields = XMLDataFields(xml)
    Seq(
      "Transaction: " + fields.transactionPath.text + " " + fields.title.text + " " + fields.surName.text + " " + fields.nationalInsuranceNumber.text,
      "Summary",
      "About you - the carer",
      "National Insurance Number " + fields.nationalInsuranceNumber.text,
      "Last name " + fields.surName.text,
      "First name(s) " + fields.firstName.text,
      "Title " + fields.title.text,
      "Street / Town / City " + fields.addressCarer,
      "Postcode " + fields.postCodeCarer.text,
      "About the care you provide",
      "Last name " + fields.careeLastName.text,
      "First name(s) " + fields.careeFirstName.text,
      "Title " + fields.careeTitle.text,
      "Street / Town / City " + fields.addressCaree,
      "Postcode " + fields.postCodeCaree.text,
      "Claim Dates",
      "Date claim received " + fields.dateClaimReceived.text,
      "Claim Summary",
      "Transaction: " + fields.transactionPath.text + " " + "Claim received: " + fields.dateClaimReceived.text
    )
  }
}
