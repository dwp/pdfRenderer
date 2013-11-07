package test_data

import scala.xml.Elem


object XMLData {
  def madeUpField(xml: Elem) = {
    Seq(
      "I am an invalid field that should never appear in the pdf"
    )
  }

  def functionalTestCaseSectionPart1AboutYouTheCarer(xml: Elem) = {
    sectionPart1AboutYouTheCarer(xml)
  }

  def functionalTestCase1(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml)
  }

  def functionalTestCase2(xml: Elem) = {
    val fields = XMLDataFields(xml)
    Seq(
      "Other surname or maiden name " + fields.claimantOtherSurnames.text,
      "Other surname or maiden name " + fields.partnerOtherSurnames.text
    ) ++ functionalTestCaseMandatoryFields(xml) ++ aboutYourPartner(fields)
  }

  def functionalTestCase3(xml: Elem) = {
    val fields = XMLDataFields(xml)
    Seq(
      "Other surname or maiden name " + fields.claimantOtherSurnames.text,
      "Other surname or maiden name " + fields.partnerOtherSurnames.text
    ) ++ functionalTestCaseMandatoryFields(xml) ++ aboutYourPartner(fields) ++ careBreaks(fields)
  }

  def functionalTestCase4(xml: Elem): Seq[String] = {
    val fields = XMLDataFields(xml)
    Seq(
      "Other surname or maiden name " + fields.claimantOtherSurnames.text
    ) ++ functionalTestCaseMandatoryFields(xml) ++ careBreaks(fields)
  }

  def functionalTestCase5(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml) ++ aboutYourPartner(fields) ++ careBreaks(fields)
  }

  def functionalTestCase6(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml)
  }

  def functionalTestCase7(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml) ++ aboutYourPartner(fields) ++ careBreaks(fields)
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
      "Summary"
    ) ++ aboutYouTheCarer(fields) ++ aboutTheCareYouProvide(fields) ++ claimDates(fields) ++ claimSummary(fields)
  }

  def aboutYouTheCarer(fields: XMLDataFields) = {
    Seq("About you - the carer",
      "National Insurance Number " + fields.nationalInsuranceNumber.text,
      "Last name " + fields.surName.text,
      "First name(s) " + fields.firstName.text,
      "Title " + fields.title.text,
      "Street / Town / City " + fields.addressCarer,
      "Postcode " + fields.postCodeCarer.text
    )
  }

  def aboutTheCareYouProvide(fields: XMLDataFields) = {
    Seq(
      "About the care you provide",
      "Last name " + fields.careeLastName.text,
      "First name(s) " + fields.careeFirstName.text,
      "Title " + fields.careeTitle.text,
      "Street / Town / City " + fields.addressCaree,
      "Postcode " + fields.postCodeCaree.text
    )
  }

  def claimDates(fields: XMLDataFields) = {
    Seq("Claim Dates",
      "Date claim received " + fields.dateClaimReceived.text
    )
  }

  def claimSummary(fields: XMLDataFields) = {
    Seq("Claim Summary",
      "Transaction: " + fields.transactionPath.text + " " + "Claim received: " + fields.dateClaimReceived.text
    )
  }

  def aboutYourPartner(fields: XMLDataFields) = Seq(
    "National Insurance Number " + fields.parnerNINO.text,
    "Last name " + fields.partnerSurname.text,
    "First name(s) " + fields.partnerOtherNames.text,
    "Title " + fields.partnerTitle.text
  )

  def careBreaks(fields: XMLDataFields) = fields.careBreak

  def sectionPart1AboutYouTheCarer(xml: Elem) = {
    val fields = SectionPart1AboutYouTheCarer(xml);
    Seq("Part 1 - About you - the carer",
      "Your details",
      "Title " + fields.title.text,
      "First Name " + fields.firstName.text,
      "Last Name "+ fields.lastName.text,
      "Other surname or maiden name " + fields.otherSurnameOrMaidenName.text,
      "National Insurance number " + fields.nationalInsuranceNumber.text,
      "Date of Birth " + fields.dateOfBirth.text,
      "Marital Status " + fields.maritalStatus.text,
      fields.dateOfClaimQuestion.text +" "+ fields.dateOfClaimAnswer.text,
      "Your contact details",
      "Street / Town / City " + fields.address,
      "Postcode " + fields.postCode.text,
      "Daytime telephone number " + fields.dayTimeTelephoneNumber.text,
      "Mobile number " + fields.mobileNumber.text,
      fields.speechOrHearingDifficultyQuestion.text +" "+ fields.speechOrHearingDifficultyAnswer.text,
      "Your nationality and residency",
      "What is your nationality "+fields.nationality.text,
      fields.doYouLiveEnglandScotlandWalesQuestion.text +" "+fields.doYouLiveEnglandScotlandWalesAnswer.text,
      fields.countryNormallyLiveInQuestion.text +" "+fields.countryNormallyLiveInAnswer.text,
      "Time outside of England, Scotland or Wales",
      fields.timeOutsideGBLast3YearsQuestion.text +" "+fields.timeOutsideGBLast3YearsAnswer.text,
      "-->>  Outside England, Scotland and Wales X",
      "Money you get from other European Economic Area (EEA) countries or Switzerland",
      fields.receiveEEAPensionsBenefitsQuestion.text + " " + fields.receiveEEAPensionsBenefitsAnswer.text,
      fields.claimEEAPensionsBenefitsQuestion.text + " " + fields.claimEEAPensionsBenefitsAnswer.text,
      fields.workingEEAInsuranceQuestion.text + " " + fields.workingEEAInsuranceAnswer.text,
      "More about you",
      fields.havePartnerQuestion.text + " " + fields.havePartnerAnswer.text,
      fields.courseOfEducationQuestion.text + " " + fields.courseOfEducationAnswer.text,
      fields.statePensionQuestion.text + " " + fields.statePensionAnswer.text,
      "Employment",
      fields.employedQuestion.text + " " + fields.employedAnswer.text,
      fields.selfEmployedQuestion.text + " " + fields.selfEmployedAnswer.text
    ) ++ fields.periodAbroad
  }

  def sectionPart2AboutYourPartner(xml: Elem) = {
    val fields = SectionPart2AboutYourPartner(xml);
    Seq ("Part 2 - About your partner",
         "Partner/Spouse details",
         "Other surname or maiden name "+fields.otherSurnameOrMaidenName.text,
         "Date of Birth "+fields.dateOfBirth.text,
         "Nationality "+fields.nationalityPartner.text,
         fields.seperatedFromPartnerQuestion.text+" "+fields.seperatedFromPartnerAnswer.text,
         "Person you care for",
         fields.isCareeQuestion.text+" "+fields.isCareeAnswer.text
         ) ++ aboutYourPartner(XMLDataFields(xml))
  }

  def sectionAboutEmployment(xml:Elem) = {
    val fields = SectionAboutEmployment(xml);
    Seq ("Part 5 - About Your Employment",
         fields.areYouEmployedQuestion.text+" "+fields.areYouEmployedAnswer.text,
         "Your Job Details for "+fields.employerName.text)
  }
}
