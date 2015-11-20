package test_data.v14

import scala.xml.Elem

object XMLData extends utils.TestUtils {
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
    functionalTestCaseMandatoryFields(xml) ++ sectionAboutYourPartner(xml)
  }

  def functionalTestCase3(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml) ++ sectionAboutYourPartner(xml) ++ careBreaks(fields) ++ sectionAboutEmployment(xml) ++ sectionEvidenceList(xml)
  }

  def functionalTestCase4(xml: Elem): Seq[String] = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml) ++ careBreaks(fields)
  }

  def functionalTestCase5(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml) ++ sectionAboutYourPartner(xml) ++ careBreaks(fields)
  }

  def functionalTestCase6(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml) ++ sectionAboutOtherMoney(xml)
  }

  def functionalTestCase7(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml) ++ sectionAboutYourPartner(xml) ++ careBreaks(fields)
  }

  def functionalTestCase8(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml) ++ sectionAboutSelfEmployment(xml)
  }

  def functionalTestCase9(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml)
  }

  def functionalTestCase10(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml)
  }

  def functionalTestCase11(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml) ++ sectionCustomerConsent(xml)
  }

  def functionalTestCase12(xml: Elem) = {
    val fields = XMLDataFields(xml)
    functionalTestCaseMandatoryFields(xml) ++ sectionCustomerConsent(xml)
  }

  def functionalTestCaseMandatoryFields(xml: Elem) = {
    val fields = XMLDataFields(xml)
    Seq(
      "Transaction: " + fields.transactionPath.text + " " + fields.titleAnswer.text + " " + fields.surNameAnswer.text + " " + fields.nationalInsuranceNumberAnswer.text,
      "Summary",
      "About the care you provide"
    ) ++ aboutYouTheCarer(xml) ++ sectionAboutTheCareYouProvide(xml) ++ claimDates(fields) ++ claimSummary(fields)
  }

  def aboutYouTheCarer(xml: Elem) = {
    val fields = SectionPart1AboutYouTheCarer(xml)
    Seq("About you - the carer",
      buildQuestion(fields.nationalInsuranceNumberQuestion.text, fields.nationalInsuranceNumberAnswer.text.trim),
      buildQuestion(fields.lastNameQuestion.text, fields.lastNameAnswer.text.trim),
      buildQuestion(fields.firstNameQuestion.text, fields.firstNameAnswer.text.trim),
      buildQuestion(fields.claimantMiddleNamesQuestion.text, fields.claimantMiddleNameAnswer.text.trim),
      buildQuestion(fields.titleQuestion.text, fields.titleAnswer.text.trim),
      buildQuestion(fields.dateOfBirthQuestion.text, fields.dateOfBirthAnswer.text.trim),
      buildQuestion(fields.maritalStatusQuestion.text, fields.maritalStatusAnswer.text.trim),
      buildQuestion(fields.dayTimeTelephoneNumberQuestion.text, fields.dayTimeTelephoneNumberAnswer.text.trim),
      buildQuestion(fields.speechOrHearingDifficultyQuestion.text, fields.speechOrHearingDifficultyAnswer.text.trim),
      buildQuestion(fields.nationalityQuestion.text, fields.nationalityAnswer.text.trim),
      buildQuestion(fields.doYouLiveEnglandScotlandWalesQuestion.text, fields.doYouLiveEnglandScotlandWalesAnswer.text.trim),
      buildQuestion(fields.countryNormallyLiveInQuestion.text, fields.countryNormallyLiveInAnswer.text.trim),
      buildQuestion(fields.timeOutsideGBLast3YearsQuestion.text, fields.timeOutsideGBLast3YearsAnswer.text.trim),
      buildQuestion(fields.havePartnerQuestion.text, fields.havePartnerAnswer.text.trim),
      fields.addressCarerAnswer,
      fields.postCodeCarer.text,
      fields.reasonTimeAbroadOther.text,
      buildQuestion(fields.cared35HoursBeforeQuestion.text, fields.cared35HoursBeforeAnswer.text),
      buildQuestion(fields.dateStartedCaringQuestion.text, fields.dateStartedCaringAnswer.text)
    )
  }

  def aboutTheCareYouProvide(fields: XMLDataFields) = {
    Seq(
      fields.careeLastNameQuestion.text + " " + fields.careeLastNameAnswer.text.trim,
      fields.careeFirstNameQuestion.text + " " + fields.careeFirstNameAnswer.text.trim,
      fields.careeMiddleNameQuestion.text + " " + fields.careeMiddleNameAnswer.text.trim,
      fields.titleQuestion.text + " " + fields.titleAnswer.text,
      fields.addressCareeAnswer,
      fields.postCodeCaree.text
    )
  }

  def claimDates(fields: XMLDataFields) = {
    Seq("Claim Date",
      buildQuestion(fields.dateOfClaimQuestion.text, fields.dateOfClaimAnswer.text)
    )
  }

  def claimSummary(fields: XMLDataFields) = {
    Seq("Claim Summary",
      fields.nationalityAnswer.text,
      fields.qualifyingBenefitAnswer.text,
      buildQuestion(fields.receiveEEAPensionsBenefitsQuestion.text, fields.receiveEEAPensionsBenefitsAnswer.text),
      buildQuestion(fields.timeOutsideGBLast3YearsQuestion.text, fields.timeOutsideGBLast3YearsAnswer.text),
      buildQuestion(fields.otherInformationWelshCommunicationQuestion.text, fields.otherInformationWelshCommunicationAnswer.text),
      buildQuestion(fields.otherInformationAddtionalInformationQuestion.text, fields.otherInformationAddtionalInformationAnswer.text)
    )
  }

  def careBreaks(fields: XMLDataFields) = fields.careBreak

  def sectionAboutYourPartner(xml: Elem) = {
    val fields = SectionPart2AboutYourPartner(xml)
    Seq (
            "Part 2 - About your partner",
            "Partner details",
            buildQuestion(fields.dateOfBirthQuestion.text, fields.dateOfBirthAnswer.text),
            buildQuestion(fields.nationalityPartnerQuestion.text, fields.nationalityPartnerAnswer.text),
            buildQuestion(fields.seperatedFromPartnerQuestion.text, fields.seperatedFromPartnerAnswer.text),
            buildQuestion(fields.isCareeQuestion.text, fields.isCareeAnswer.text),
            buildQuestion(fields.parnerNINOQuestion.text, fields.parnerNINOAnswer.text),
            buildQuestion(fields.partnerSurnameQuestion.text,fields.partnerSurnameAnswer.text),
            buildQuestion(fields.partnerMiddleNamesQuestion.text,fields.partnerMiddleNamesAnswer.text),
            buildQuestion(fields.partnerOtherNamesQuestion.text,fields.partnerOtherNamesAnswer.text),
            buildQuestion(fields.partnerTitleQuestion.text,fields.partnerTitleAnswer.text),
            buildQuestion(fields.partnerOtherSurnamesQuestion.text,fields.partnerOtherSurnamesAnswer.text)
         )
  }

  def sectionAboutEmployment(xml:Elem) = {
    val fields = SectionAboutEmployment(xml)
    var employmentTitle = "Part 5 - About Your Employment"
    if (serviceVersion(xml).equals("0.2")){
      employmentTitle = "Part 5 - Employment"
    }
    Seq (employmentTitle,
         fields.areYouEmployedQuestion.text+" "+fields.areYouEmployedAnswer.text,
         buildEmpAdditionaInfo(xml)) ++ fields.employmentDetails
  }

  private def buildEmpAdditionaInfo (xml:Elem) = {
    val xmlDatafields = XMLDataFields(xml)
    buildOther(xmlDatafields.employmentAdditionaInfoQuestion.text,
      xmlDatafields.employmentAdditionaInfoAnswer.text,
      xmlDatafields.employmentAdditionaInfoOther.text)
  }

  def sectionAboutSelfEmployment(xml:Elem) = {
    val fields = SectionAboutSelfEmployment(xml)

    val yourAccounts: Seq[String] = if (fields.haveBeenSelfEmployedAnswer.text == "yes")
      Seq("Your accounts",
          buildQuestion(fields.tradingYearStartedQuestion.text, fields.tradingYearStartedAnswer.text),
          buildQuestion(fields.tradingYearEndedQuestion.text, fields.tradingYearEndedAnswer.text),
          buildQuestion(fields.sameIncomeOutgoingLevelsQuestion.text, fields.sameIncomeOutgoingLevelsAnswer.text),
          buildQuestion(fields.whyWhenChangeQuestion.text, fields.whyWhenChangeAnswer.text))
      else Seq()


    Seq ("Part 6 - About Self Employment",
         buildQuestion(fields.haveBeenSelfEmployedQuestion.text, fields.haveBeenSelfEmployedAnswer.text),
         "Your job",
         buildQuestion(fields.selfEmployedNowQuestion.text, fields.selfEmployedNowAnswer.text),
         buildQuestion(fields.selfEmployedStartedQuestion.text, fields.selfEmployedStartedAnswer.text),
         buildQuestion(fields.selfEmployedEndedQuestion.text, fields.selfEmployedEndedAnswer.text),
         buildQuestion(fields.ceasedTradingQuestion.text, fields.ceasedTradingAnswer.text),
         buildQuestion(fields.natureOfBusinessQuestion.text, fields.natureOfBusinessAnswer.text)) ++
    yourAccounts ++
    Seq ("Pension and expenses",
         buildQuestion(fields.paidForPensionQuestion.text, fields.paidForPensionAnswer.text),
         buildQuestion(fields.paidForPensionQuestion.text, fields.paidForPensionAnswer.text),
         buildQuestion(fields.pensionExpensesQuestion.text, fields.pensionExpensesAnswer.text),
         buildQuestion(fields.paidForJobExpensesQuestion.text, fields.paidForJobExpensesAnswer.text),
         buildQuestion(fields.jobExpensesQuestion.text, fields.jobExpensesAnswer.text)
      ) ++ Seq(buildEmpAdditionaInfo(xml))
  }

  def sectionAboutTheCareYouProvide(xml:Elem) = {
    val fields = SectionAboutTheCareYouProvide(xml)
    Seq("Part 3 - About the care you provide",
        "Details of the person you care for",
        buildQuestion((fields.nationalInsuranceNumber \\ "QuestionLabel").text, (fields.nationalInsuranceNumber \\ "Answer").text),
        buildQuestion((fields.dateOfBirth \\ "QuestionLabel").text, (fields.dateOfBirth \\ "Answer").text),
        buildQuestion(fields.liveSameAddressQuestion.text,fields.liveSameAddressAnswer.text),
        //"Contact details of the person you care for", This is now a dynamic label, so is giving problems
        buildQuestion((fields.dayTimeTelephoneNumber \\ "QuestionLabel").text, (fields.dayTimeTelephoneNumber \\ "Answer").text),
        buildQuestion(fields.relationToClaimantQuestion.text, fields.relationToClaimantAnswer.text),
        "More about the care you provide",
        buildQuestion(fields.cared35HoursQuestion.text, fields.cared35HoursAnswer.text)
    ) ++ aboutTheCareYouProvide(XMLDataFields(xml)) ++ careBreaks(XMLDataFields(xml))
  }
  
  def sectionAboutOtherMoney(xml:Elem) = {
    val fields = SectionAboutOtherMoney(xml)
    var otherMoneyTitle = "Part 7 - About Other Money"
    if (!serviceVersion(xml).equals("0.1")){
      otherMoneyTitle = "PART 7 - OTHER PAYMENTS"
    }
    Seq (otherMoneyTitle,
      buildQuestion(fields.otherMoneyQuestion.text, fields.otherMoneyAnswer.text),
      buildQuestion(fields.otherMoneyPaymentQuestion.text, fields.otherMoneyPaymentAnswer.text),
      buildQuestion(fields.otherMoneyPaymentNameQuestion.text, fields.otherMoneyPaymentNameAnswer.text),
      buildQuestion(fields.otherMoneyPaymentAmountQuestion.text, fields.otherMoneyPaymentAmountAmount.text),
      buildOther(fields.otherMoneyPaymentFrequencyQuestion.text, fields.otherMoneyPaymentFrequencyAnswer.text, fields.otherMoneyPaymentFrequencyOther.text),
      buildQuestion(fields.otherMoneySSPQuestion.text, fields.otherMoneySSPAnswer.text),
      buildQuestion(fields.otherMoneySSPPaymentAmountQuestion.text, fields.otherMoneySSPPaymentAmountAmount.text),
      buildOther(fields.otherMoneySSPPaymentFrequencyQuestion.text, fields.otherMoneySSPPaymentFrequencyAnswer.text, fields.otherMoneySSPPaymentFrequencyOther.text),
      "Employer's Name" + " " + fields.otherMoneySSPEmployerName.text,
      "Employer's Address " + fields.otherMoneySSPEmployerAddress,
      "Employer's Postcode " + fields.otherMoneySSPEmployerPostcode.text,
      buildQuestion(fields.otherMoneySPQuestion.text, fields.otherMoneySPAnswer.text),
      buildQuestion(fields.otherMoneySPPaymentAmountQuestion.text, fields.otherMoneySPPaymentAmountAmount.text),
      buildOther(fields.otherMoneySPPaymentFrequencyQuestion.text, fields.otherMoneySPPaymentFrequencyAnswer.text, fields.otherMoneySPPaymentFrequencyOther.text),
      "Employer's Name" + " " + fields.otherMoneySPEmployerName.text,
      "Employer's Address " + fields.otherMoneySPEmployerAddress,
      "Employer's Postcode " + fields.otherMoneySPEmployerPostcode.text,
      buildQuestion(fields.receiveEEAPensionsBenefitsQuestion.text, fields.receiveEEAPensionsBenefitsAnswer.text),
      buildQuestion(fields.receiveEEAPensionsBenefitsDetailsQuestion.text, fields.receiveEEAPensionsBenefitsDetailsAnswer.text),
      buildQuestion(fields.workingEEAInsuranceQuestion.text, fields.workingEEAInsuranceAnswer.text),
      buildQuestion(fields.workingEEAInsuranceDetailsQuestion.text, fields.workingEEAInsuranceDetailsAnswer.text)
    )
  }

  def sectionAboutYourPayDetails(xml:Elem) = {
    val fields = SectionAboutYourPayDetails(xml)
    var payDetailsTitle = "Part 8 - About Your Pay Details"
    if (serviceVersion(xml).equals("0.2")){
      payDetailsTitle = "PART 8 - PAY DETAILS"
    }
    Seq (payDetailsTitle,
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
        "Course title "+fields.courseDetailsTitle.text,
        buildQuestion(fields.courseDetailsDateStartedQuestion.text, fields.courseDetailsDateStartedAnswer.text),
        buildQuestion(fields.courseDetailsExpectedEndDateQuestion.text, fields.courseDetailsExpectedEndDateAnswer.text),
        "Your student reference number "+fields.studentReferenceNumber.text,
        "Name of school, college or university "+fields.nameOfUniversity.text,
        "Name of main Teacher or Tutor "+fields.nameOfTheTutor.text,
        "Course contact number "+fields.phoneNumber.text
     )
  }

  def sectionCustomerConsent(xml:Elem) = {
    val fields = SectionConsentAndDeclaration(xml)

    val consentXml: Seq[String] = fields.consent.flatMap {
      c => {
        ((c \ "Answer").text.toLowerCase == "no") match {
          case true => Seq(buildQuestion((c \ "QuestionLabel").text, (c \ "Answer").text), buildQuestion((c \ "Why" \ "QuestionLabel").text, (c \ "Why" \ "Answer").text))
          case false => Seq(buildQuestion((c \ "QuestionLabel").text, (c \ "Answer").text))
        }
      }
    }

    Seq ("Part 9 - Customer Consent And Declaration",
         "Additional Information",
         buildQuestion(fields.otherInformationAdditionalInformationQuestion.text,fields.otherInformationAdditionalInformationAnswer.text),
         buildQuestion(fields.otherInformationWelshCommunicationQuestion.text,fields.otherInformationWelshCommunicationAnswer.text),
         "Consent",
         "Disclaimer",
         "Declaration"
    ) ++ consentXml
  }

  def sectionCustomerDeclaration(xml:Elem) = {
    val fields = SectionConsentAndDeclaration(xml)

    val disclaimerQuestionXml = fields.disclaimerQuestion.map (d => buildQuestion((d \ "QuestionLabel").text, (d \ "Answer").text))

    val disclaimerStatementXml: Seq[String] = {
      fields.disclaimerStatement.
        map(x => {
        Seq((x \\ "Content").map(v => v.text).reduce((total,cur) => total + " " + cur)
        )
      }).flatten
    }

    val declarationQuestionXml = fields.declarationQuestion.map (d => buildQuestion((d \ "QuestionLabel").text, (d \ "Answer").text))

    val declarationStatementXml: Seq[String] = {
      fields.disclaimerStatement.
        map(x => {
        Seq((x \\ "Content").map(v => v.text).reduce((total,cur) => total + " " + cur)
        )
      }).flatten
    }

    disclaimerStatementXml ++ disclaimerQuestionXml ++ declarationStatementXml ++ declarationQuestionXml
  }

  def sectionEvidenceList(xml:Elem) = {
    val fields = SectionEvidenceList(xml)
    Seq("Part 10 - Customer Evidence List",
        fields.postCode.text
    ) ++ fields.evidenceList ++ fields.address
  }

  def serviceVersion(xml:Elem) = {
    XMLDataFields(xml).serviceVersion.text
  }

}
