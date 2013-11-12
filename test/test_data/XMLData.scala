package test_data

import scala.xml.Elem
import utils.TestUtils


object XMLData extends TestUtils{
  def madeUpField(xml: Elem) = {
    Seq(
      "I am an invalid field that should never appear in the pdf"
    )
  }

  def functionalTestCaseSectionAboutYouTheCarer(xml: Elem) = {
    sectionAboutYouTheCarer(xml)
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
      "Summary",
      "About the care you provide"
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

  def sectionAboutYouTheCarer(xml: Elem) = {
    val fields = SectionPart1AboutYouTheCarer(xml)
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

  def sectionAboutYourPartner(xml: Elem) = {
    val fields = SectionPart2AboutYourPartner(xml)
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
    val fields = SectionAboutEmployment(xml)
    Seq ("Part 5 - About Your Employment",
         fields.areYouEmployedQuestion.text+" "+fields.areYouEmployedAnswer.text) ++ fields.employmentDetails
  }

  def sectionAboutSelfEmployment(xml:Elem) = {
    val fields = SectionAboutSelfEmployment(xml)
    Seq ("Part 6 - About Self Employment",
         buildQuestion(fields.haveBeenSelfEmployedQuestion.text, fields.haveBeenSelfEmployedAnswer.text),
         "Your job",
         buildQuestion(fields.selfEmployedNowQuestion.text, fields.selfEmployedNowAnswer.text),
         buildQuestion(fields.selfEmployedStartedQuestion.text, fields.selfEmployedStartedAnswer.text),
         buildQuestion(fields.selfEmployedEndedQuestion.text, fields.selfEmployedEndedAnswer.text),
         buildQuestion(fields.ceasedTradingQuestion.text, fields.ceasedTradingAnswer.text),
         buildQuestion(fields.natureOfBusinessQuestion.text, fields.natureOfBusinessAnswer.text),
         "Your accounts",
         buildQuestion(fields.tradingYearStartedQuestion.text, fields.tradingYearStartedAnswer.text),
         buildQuestion(fields.tradingYearEndedQuestion.text, fields.tradingYearEndedAnswer.text),
         buildQuestion(fields.sameIncomeOutgoingLevelsQuestion.text, fields.sameIncomeOutgoingLevelsAnswer.text),
         buildQuestion(fields.whyWhenChangeQuestion.text, fields.whyWhenChangeAnswer.text),
         "Pension and expenses",
         buildQuestion(fields.paidForPensionQuestion.text, fields.paidForPensionAnswer.text),
         buildAmount(fields.pensionSchemeAmountQuestion.text, fields.pensionSchemeAmountAnswerCurrency.text, fields.pensionSchemeAmountAnswerAmount.text),
         buildOther(fields.pensionSchemeFrequencyQuestion.text, fields.pensionSchemeFrequencyAnswer.text, fields.pensionSchemeFrequencyOther.text),
         "Childcare expenses while you are at work",
         buildQuestion(fields.careExpensesChildrenQuestion.text, fields.careExpensesChildrenAnswer.text),
         buildQuestion(fields.careExpensesChildrenCarerNameQuestion.text, fields.careExpensesChildrenCarerNameAnswer.text),
         buildAmount(fields.careExpensesChildrenPaymentQuestion.text, fields.careExpensesChildrenPaymentAnswerCurrency.text, fields.careExpensesChildrenPaymentAnswerAmount.text),
         buildOther(fields.careExpensesChildrenPaymentFrequencyQuestion.text, fields.careExpensesChildrenPaymentFrequencyAnswer.text, fields.careExpensesChildrenPaymentFrequencyOther.text),
         buildQuestion(fields.careExpensesChildrenRelationshipToCarerQuestion.text, fields.careExpensesChildrenRelationshipToCarerAnswer.text),
         buildQuestion(fields.careExpensesChildrenRelationshipToPartnerQuestion.text, fields.careExpensesChildrenRelationshipToPartnerAnswer.text),
         buildQuestion(fields.careExpensesChildrenRelationshipToChildQuestion.text, fields.careExpensesChildrenRelationshipToChildAnswer.text),
         "Expenses related to the person you care for while at work",
         buildQuestion(fields.careExpensesCareeQuestion.text, fields.careExpensesCareeAnswer.text),
         buildQuestion(fields.careExpensesCareeCarerNameQuestion.text, fields.careExpensesCareeCarerNameAnswer.text),
         buildAmount(fields.careExpensesCareePaymentQuestion.text, fields.careExpensesCareePaymentAnswerCurrency.text, fields.careExpensesCareePaymentAnswerAmount.text),
         buildOther(fields.careExpensesCareePaymentFrequencyQuestion.text, fields.careExpensesCareePaymentFrequencyAnswer.text, fields.careExpensesCareePaymentFrequencyOther.text),
         buildQuestion(fields.careExpensesRelationshipCarerToClaimantQuestion.text, fields.careExpensesRelationshipCarerToClaimantAnswer.text),
         buildQuestion(fields.careExpensesRelationshipCarerToPartnerQuestion.text, fields.careExpensesRelationshipCarerToPartnerAnswer.text),
         buildQuestion(fields.careExpensesRelationshipCarerToCareeQuestion.text, fields.careExpensesRelationshipCarerToCareeAnswer.text)
      )
  }

  def sectionAboutTheCareYouProvide(xml:Elem) = {
    val fields = SectionAboutTheCareYouProvide(xml)
    Seq("Part 3 - About the care you provide",
        "Details of the person you care for",
        "National Insurance number "+fields.nationalInsuranceNumber.text,
        "Date of Birth "+fields.dateOfBirth.text,
        buildQuestion(fields.liveSameAddressQuestion.text,fields.liveSameAddressAnswer.text),
        "Contact details of the person you care for",
        "Daytime telephone number "+fields.dayTimeTelephoneNumber.text,
        "Relationship and other claims",
        buildQuestion(fields.relationToClaimantQuestion.text, fields.relationToClaimantAnswer.text),
        buildQuestion(fields.armedForcesIndependantPaymentQuestion.text, fields.armedForcesIndependantPaymentAnswer.text),
        "More about the care you provide",
        buildQuestion(fields.cared35HoursQuestion.text, fields.cared35HoursAnswer.text),
        buildQuestion(fields.cared35HoursBeforeQuestion.text, fields.cared35HoursBeforeAnswer.text),
        buildQuestion(fields.dateStartedCaringQuestion.text, fields.dateStartedCaringAnswer.text),
        "Last name " + fields.careeLastName.text,
        "First name(s) " + fields.careeFirstName.text,
        "Title " + fields.careeTitle.text,
        "Street / Town / City " + fields.addressCaree,
        "Postcode " + fields.postCodeCaree.text
    ) ++ aboutTheCareYouProvide(XMLDataFields(xml)) ++ careBreaks(XMLDataFields(xml))
  }
  
  def sectionAboutOtherMoney(xml:Elem) = {
    val fields = SectionAboutOtherMoney(xml)
    Seq ("Part 7 - About Other Money",
      "Details about other money",
      buildQuestion(fields.otherMoneyQuestion.text, fields.otherMoneyAnswer.text),
      buildQuestion(fields.otherMoneyPaymentQuestion.text, fields.otherMoneyPaymentAnswer.text),
      buildQuestion(fields.otherMoneyPaymentNameQuestion.text, fields.otherMoneyPaymentNameAnswer.text),
      buildAmount(fields.otherMoneyPaymentAmountQuestion.text, fields.otherMoneyPaymentAmountCurrency.text, fields.otherMoneyPaymentAmountAmount.text),
      buildOther(fields.otherMoneyPaymentFrequencyQuestion.text, fields.otherMoneyPaymentFrequencyAnswer.text, fields.otherMoneyPaymentFrequencyOther.text),
      "Statutory Sick Pay",
      buildQuestion(fields.otherMoneySSPQuestion.text, fields.otherMoneySSPAnswer.text),
      buildAmount(fields.otherMoneySSPPaymentAmountQuestion.text, fields.otherMoneySSPPaymentAmountCurrency.text, fields.otherMoneySSPPaymentAmountAmount.text),
      buildOther(fields.otherMoneySSPPaymentFrequencyQuestion.text, fields.otherMoneySSPPaymentFrequencyAnswer.text, fields.otherMoneySSPPaymentFrequencyOther.text),
      "Employer's Name" + " " + fields.otherMoneySSPEmployerName.text,
      "Street / Town / City " + fields.otherMoneySSPEmployerAddress,
      "Postcode " + fields.otherMoneySSPEmployerPostcode.text,
      "Other Statutory Pay",
      buildQuestion(fields.otherMoneySPQuestion.text, fields.otherMoneySPAnswer.text),
      buildAmount(fields.otherMoneySPPaymentAmountQuestion.text, fields.otherMoneySPPaymentAmountCurrency.text, fields.otherMoneySPPaymentAmountAmount.text),
      buildOther(fields.otherMoneySPPaymentFrequencyQuestion.text, fields.otherMoneySPPaymentFrequencyAnswer.text, fields.otherMoneySPPaymentFrequencyOther.text),
      "Employer's Name" + " " + fields.otherMoneySPEmployerName.text,
      "Street / Town / City " + fields.otherMoneySPEmployerAddress,
      "Postcode " + fields.otherMoneySPEmployerPostcode.text
    )
  }

  def sectionAboutYourPayDetails(xml:Elem) = {
    val fields = SectionAboutYourPayDetails(xml)
    Seq ("Part 8 - About Your Pay Details",
         buildQuestion(fields.howToGetPaidQuestion.text, fields.howToGetPaidAnswer.text),
         buildOther(fields.howOftenGetPaidQuestion.text, fields.howOftenGetPaidAnswer.text, fields.howOftenGetPaidOther.text),
         "Bank/Building Society Details",
         "Name of account holder" + " " + fields.bankAccountHolderName.text,
         "Full name of bank or building society" + " " + fields.bankAccountBankName.text,
         "Sort code" + " " + fields.bankAccountSortCode.text,
         "Account number" + " " + fields.bankAccountNumber.text,
         "Building society roll or reference number" + " " + fields.bankAccountReferenceNumber.text
    )
  }

  def sectionAboutYourEducation(xml:Elem) = {
     val fields = SectionAboutYourEducation(xml)
     Seq("Part 4 - About Your Education",
        buildQuestion(fields.courseOfEducationQuestion.text, fields.courseOfEducationAnswer.text),
        "Your course details",
        "Type of course "+fields.courseDetailsType.text,
        "Course title "+fields.courseDetailsTitle.text,
        buildQuestion(fields.courseDetailsDateStartedQuestion.text, fields.courseDetailsDateStartedAnswer.text),
        buildQuestion(fields.courseDetailsDateStoppedQuestion.text, fields.courseDetailsDateStoppedAnswer.text),
        buildQuestion(fields.courseDetailsExpectedEndDateQuestion.text, fields.courseDetailsExpectedEndDateAnswer.text),
        "Your student reference number "+fields.studentReferenceNumber.text,
        "School, college or university’s contact details",
        "Name of school, college or university "+fields.nameOfUniversity.text,
        "Name of main Teacher or Tutor "+fields.nameOfTheTutor.text,
        "Street / Town / City " + fields.address,
        "Postcode "+fields.postCode.text,
        "Phone number "+fields.phoneNumber.text,
        "Fax number "+fields.faxNumber.text
     )
  }

  def sectionEvidenceList(xml:Elem) = {
    val fields = SectionEvidenceList(xml)
    Seq("Part 10 - Customer Evidence List",
        fields.address,
        fields.postCode.text
    ) ++ fields.evidenceList
  }

}
