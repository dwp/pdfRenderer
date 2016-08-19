package gov.dwp.carers.pdfrenderer.testdata.claim;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import gov.dwp.carers.pdfrenderer.utils.TestUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by peterwhitehead on 09/05/2016.
 */
public class XMLClaimData extends TestUtils {
    public Function <String, List<String>> functionalTestCase1 = xml -> {
        final List<String> details = getFunctionalTestCase1(xml);
        return details;
    };

    public Function <String, List<String>> functionalTestCase2 = xml -> {
        final List<String> details = getFunctionalTestCase2(xml);
        return details;
    };

    public Function <String, List<String>> functionalTestCase3 = xml -> {
        final List<String> details = getFunctionalTestCase3(xml);//
        return details;
    };

    public Function <String, List<String>> functionalTestCase4 = xml -> {
        final List<String> details = getFunctionalTestCase4(xml);//
        return details;
    };

    public Function <String, List<String>> functionalTestCase5 = xml -> {
        final List<String> details = getFunctionalTestCase5(xml);//
        return details;
    };

    public Function <String, List<String>> functionalTestCase6 = xml -> {
        final List<String> details = getFunctionalTestCase6(xml);//
        return details;
    };

    public Function <String, List<String>> functionalTestCase7 = xml -> {
        final List<String> details = getFunctionalTestCase7(xml);//
        return details;
    };

    public Function <String, List<String>> functionalTestCase8 = xml -> {
        final List<String> details = getFunctionalTestCase8(xml);//
        return details;
    };

    public Function <String, List<String>> functionalTestCase9 = xml -> {
        final List<String> details = getFunctionalTestCase9(xml);//
        return details;
    };

    public Function <String, List<String>> functionalTestCase10 = xml -> {
        final List<String> details = getFunctionalTestCase10(xml);//
        return details;
    };

    public Function <String, List<String>> functionalTestCase11 = xml -> {
        final List<String> details = getFunctionalTestCase11(xml);//
        return details;
    };

    public Function <String, List<String>> functionalTestCase12 = xml -> {
        final List<String> details = getFunctionalTestCase12(xml);//
        return details;
    };

    public Function <String, List<String>> functionalTestCase13 = xml -> {
        final List<String> details = getFunctionalTestCase13(xml);//
        return details;
    };

    public Function <String, List<String>> functionalTestCase14 = xml -> {
        final List<String> details = getFunctionalTestCase14(xml);//
        return details;
    };

    public Function <String, List<String>> functionalTestCase15 = xml -> {
        final List<String> details = getFunctionalTestCase15(xml);//
        return details;
    };

    private List<String> getFunctionalTestCase1(final String xml) {
        final List<Pair<String, String>> details = functionalTestCaseMandatoryFields(xml);
        return convertListOfPairsToListOfString(details);
    }

    private List<String> getFunctionalTestCase2(final String xml) {
        final List<Pair<String, String>> details = functionalTestCaseMandatoryFields(xml);
        details.addAll(sectionAboutYourPartner(xml));
        details.addAll(sectionAboutYourEducation(xml));
        return convertListOfPairsToListOfString(details);
    }

    private List<String> getFunctionalTestCase3(final String xml) {
        final List<Pair<String, String>> details = functionalTestCaseMandatoryFields(xml);
        details.addAll(sectionAboutYourPartner(xml));
        details.addAll(careBreaks(xml));
        details.addAll(sectionAboutEmployment(xml));
        details.addAll(sectionOtherIncomes(xml));
        details.addAll(sectionEvidenceList(xml));
        details.addAll(sectionCustomerDisclaimer(xml));
        return convertListOfPairsToListOfString(details);
    }

    private List<String> getFunctionalTestCase4(final String xml) {
        final List<Pair<String, String>> details = functionalTestCaseMandatoryFields(xml);
        details.addAll(careBreaks(xml));
        return convertListOfPairsToListOfString(details);
    }

    private List<String> getFunctionalTestCase5(final String xml) {
        final List<Pair<String, String>> details = functionalTestCaseMandatoryFields(xml);
        details.addAll(sectionAboutYourPartner(xml));
        details.addAll(careBreaks(xml));
        return convertListOfPairsToListOfString(details);
    }

    private List<String> getFunctionalTestCase6(final String xml) {
        final List<Pair<String, String>> details = functionalTestCaseMandatoryFields(xml);
        details.addAll(sectionAboutOtherMoney(xml));
        return convertListOfPairsToListOfString(details);
    }

    private List<String> getFunctionalTestCase7(final String xml) {
        final List<Pair<String, String>> details = functionalTestCaseMandatoryFields(xml);
        details.addAll(sectionAboutYourPartner(xml));
        details.addAll(careBreaks(xml));
        return convertListOfPairsToListOfString(details);
    }

    private List<String> getFunctionalTestCase8(final String xml) {
        final List<Pair<String, String>> details = functionalTestCaseMandatoryFields(xml);
        details.addAll(sectionAboutSelfEmployment(xml));
        return convertListOfPairsToListOfString(details);
    }

    private List<String> getFunctionalTestCase9(final String xml) {
        final List<Pair<String, String>> details = functionalTestCaseMandatoryFields(xml);
        return convertListOfPairsToListOfString(details);
    }

    private List<String> getFunctionalTestCase10(final String xml) {
        final List<Pair<String, String>> details = functionalTestCaseMandatoryFields(xml);
        return convertListOfPairsToListOfString(details);
    }

    private List<String> getFunctionalTestCase11(final String xml) {
        final List<Pair<String, String>> details = functionalTestCaseMandatoryFields(xml);
        details.addAll(sectionCustomerConsent(xml));
        return convertListOfPairsToListOfString(details);
    }

    private List<String> getFunctionalTestCase12(final String xml) {
        final List<Pair<String, String>> details = functionalTestCaseMandatoryFields(xml);
        details.addAll(sectionCustomerConsent(xml));
        return convertListOfPairsToListOfString(details);
    }

    private List<String> getFunctionalTestCase13(final String xml) {
        final List<Pair<String, String>> details = functionalTestCaseMandatoryFields(xml);
        details.addAll(sectionCustomerConsent(xml));
        details.addAll(sectionAboutYourPayDetails(xml));
        return convertListOfPairsToListOfString(details);
    }

    private List<String> getFunctionalTestCase14(final String xml) {
        final List<Pair<String, String>> details = functionalTestCaseMandatoryFields(xml);
        details.addAll(sectionCustomerConsent(xml));
        return convertListOfPairsToListOfString(details);
    }

    private List<String> getFunctionalTestCase15(final String xml) {
        final List<Pair<String, String>> details = functionalTestCaseMandatoryFields(xml);
        details.addAll(sectionCustomerConsent(xml));
        return convertListOfPairsToListOfString(details);
    }

    private List<Pair<String, String>> functionalTestCaseMandatoryFields(final String xml) {
        final List<Pair<String, String>> details = aboutYouTheCarer(xml);
        details.addAll(sectionAboutTheCareYouProvide(xml));
        details.addAll(claimDates(xml));
        details.addAll(claimSummary(xml));
        final String transactionPath = StringUtils.substringBetween(xml, "<TransactionId>", "</TransactionId>");
        final String rootPath = StringUtils.substringBetween(xml, "<Claimant>", "</Claimant>");
        details.add(ImmutablePair.of("", "Date Received:" + " " + StringUtils.substringBetween(xml, "<DateTimeGenerated>", "</DateTimeGenerated>") + " " + "Transaction: " + transactionPath + " " + pathAnswerOther(rootPath, "Title", "TitleOther") + " " + pathAnswer(rootPath, "OtherNames") + " " + pathAnswer(rootPath, "Surname") + " " + pathAnswer(rootPath, "NationalInsuranceNumber")));
        details.add(ImmutablePair.of("", "Summary"));
        details.add(ImmutablePair.of("", "About the care you provide"));
        return details;
    }

    private List<Pair<String, String>> aboutYouTheCarer(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<Claimant>", "</Claimant>");
        final String other = StringUtils.substringBetween(StringUtils.substringBetween(StringUtils.substringBetween(rootPath, "<Residency>", "</Residency>"), "<Reason>", "</Reason>"), "<Other>", "</Other>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("Surname", "OtherNames", "NationalInsuranceNumber", "NormallyLiveInGB", "CountryNormallyLive", "TimeOutsideGBLast3Years", "HavePartner", "Cared35HoursBefore", "DateStartCaring"));
        details.add(pathQuestionLabelAnswerOther(rootPath, "Title", "TitleOther"));
        details.add(pathQuestionLabelAnswerAddress(rootPath, "Address"));
        details.add(pathQuestionLabelAnswer(rootPath, "PostCode"));
        details.add(ImmutablePair.of("", other));
        details.add(ImmutablePair.of("", "About you - the carer"));
        return details;
    }

    private List<Pair<String, String>> aboutTheCareYouProvide(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<Caree>", "</Caree>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("Surname", "OtherNames", "NationalInsuranceNumber"));
        if (StringUtils.substringBetween(rootPath, "<LiveSameAddress>", "</LiveSameAddress>").equalsIgnoreCase("no")) {
            details.add(pathQuestionLabelAnswerAddress(rootPath, "Address"));
        }
        details.add(pathQuestionLabelAnswerOther(rootPath, "Title", "TitleOther"));
        details.add(pathQuestionLabelAnswer(rootPath, "PostCode"));
        return details;
    }

    private List<Pair<String, String>> claimDates(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<DWPCAClaim>", "</DWPCAClaim>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("DateOfClaim"));
        details.add(ImmutablePair.of("", "Claim Date"));
        return details;
    }

    private List<Pair<String, String>> claimSummary(final String xml) {
        String rootPath = StringUtils.substringBetween(xml, "<Residency>", "</Residency>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("TimeOutsideGBLast3Years"));
        rootPath = StringUtils.substringBetween(xml, "<OtherInformation>", "</OtherInformation>");
        details.add(pathQuestionLabelAnswerOther(rootPath, "Nationality", "ActualNationality"));
        details.addAll(prepareTestData(rootPath, Arrays.asList("AdditionalInformation", "WelshCommunication")));
        rootPath = StringUtils.substringBetween(xml, "<EEA>", "</EEA>");
        details.addAll(prepareTestData(rootPath, Arrays.asList("EEAReceivePensionsBenefits")));
        details.add(ImmutablePair.of("", "Claim Summary"));
        return details;
    }

    private List<Pair<String, String>> aboutYourPartner(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<Partner>", "</Partner>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("NationalInsuranceNumber", "Surname", "OtherNames", "Title", "Other"));
        return details;
    }

    private List<Pair<String, String>> additionalInfo(final String xml) {
        String rootPath = StringUtils.substringBetween(xml, "<DWPCAClaim>", "</DWPCAClaim>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("EmploymentAdditionalInfo"));
        rootPath = StringUtils.substringBetween(xml, "<EmploymentAdditionalInfo>", "</EmploymentAdditionalInfo>");
        details.add(pathQuestionLabelAnswer("", StringUtils.substringBetween(rootPath, "Other", "Other")));
        return details;
    }

    private List<Pair<String, String>> sectionEvidenceList(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<EvidenceList>", "</EvidenceList>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("DateOfClaim"));
        details.addAll(pathQuestionLabelAnswerTitle(rootPath));
        details.addAll(pathQuestionLabelAnswerContent(rootPath));
        details.add(pathQuestionLabelAnswerAddress(rootPath, "RecipientAddress"));
        details.add(pathQuestionLabelAnswer(rootPath, "PostCode"));
        details.add(ImmutablePair.of("", "Part 10 - Customer Evidence List"));
        return details;
    }

    private List<Pair<String, String>> sectionAboutYourPartner(final String xml) {
        aboutYourPartner(xml);
        final String rootPath = StringUtils.substringBetween(xml, "<Partner>", "</Partner>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("NationalityPartner", "DateOfBirth", "SeparatedFromPartner", "NationalInsuranceNumber", "Surname", "MiddleNames", "OtherNames", "Title", "OtherSurnames", "IsCaree"));
        details.add(ImmutablePair.of("", "Part 2 - About your partner"));
        details.add(ImmutablePair.of("", "Partner details"));
        return details;
    }

    private List<Pair<String, String>> sectionAboutEmployment(final String xml) {
        final List<Pair<String, String>> details = employmentDetails(xml);
        details.addAll(additionalInfo(xml));
        final String rootPath = StringUtils.substringBetween(xml, "<Incomes>", "</Incomes>");
        details.add(pathQuestionLabelAnswer(rootPath, "Employed"));
        details.add(ImmutablePair.of("", "Part 5 - About Your Employment"));
        return details;
    }

    private List<Pair<String, String>> sectionAboutTheCareYouProvide(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<Caree>", "</Caree>");
        final List<Pair<String, String>> details = prepareTestData(rootPath,
                Arrays.asList("NationalInsuranceNumber", "DateOfBirth", "LiveSameAddress", "DayTimePhoneNumber", "RelationToClaimant", "Cared35Hours"));
        details.addAll(aboutTheCareYouProvide(xml));
        details.addAll(careBreaks(xml));
        details.add(ImmutablePair.of("", "Part 3 - About the care you provide"));
        details.add(ImmutablePair.of("", "Details of the person you care for"));
        details.add(ImmutablePair.of("", "More about the care you provide"));
        return details;
    }

    private List<Pair<String, String>> sectionAboutYourPayDetails(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<Payment>", "</Payment>");
        final List<Pair<String, String>> details = prepareTestData(rootPath,
                Arrays.asList("InitialAccountQuestion", "PaymentFrequency", "HolderName", "AccountNumber", "SortCode", "Name", "RollNumber"));
        details.add(ImmutablePair.of("", "PART 8 - PAY DETAILS"));
        details.add(ImmutablePair.of("", "Bank/Building Society Details"));
        details.add(ImmutablePair.of("", StringUtils.substringBetween(StringUtils.substringBetween(rootPath, "<PaymentFrequency>", "</PaymentFrequency>"), "<Other>", "</Other>")));
        return details;
    }

    private List<Pair<String, String>> sectionAboutSelfEmployment(final String xml) {
        final String beenSelfEmployed = pathAnswer(xml, "SelfEmployed");
        final String selfEmployedPath = StringUtils.substringBetween(xml, "<SelfEmployment>", "</SelfEmployment>");
        List<Pair<String, String>> details = new ArrayList<>();
        if ("yes".equalsIgnoreCase(beenSelfEmployed)) {
            details = prepareTestData(selfEmployedPath, Arrays.asList("SelfEmployedNow", "MoreThanYearAgo", "DateStarted", "DateEnded", "PaidMoneyYet", "PaidMoneyYet", "PaidForPension", "PensionExpenses", "PaidForJobExpenses", "JobExpenses"));
        }
        if (!details.isEmpty()) {
            details.add(ImmutablePair.of("", "Your accounts"));
            details.add(ImmutablePair.of("", "Part 6 - About Self Employment"));
            details.add(ImmutablePair.of("", "Your job"));
            details.add(ImmutablePair.of("", "Pension and expenses"));
        }
        details.addAll(additionalInfo(xml));
        return details;
    }

    private List<Pair<String, String>> sectionAboutYourEducation(final String xml) {
        String rootPath = StringUtils.substringBetween(xml, "<FullTimeEducation>", "</FullTimeEducation>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("Type", "Title", "DateStarted", "DateStopped", "StudentReferenceNumber", "Name", "Tutor", "PhoneNumber"));
        details.add(ImmutablePair.of("", "Part 4 - About Your Education"));
        details.add(ImmutablePair.of("", "Your course details"));
        rootPath = StringUtils.substringBetween(xml, "<DWPCAClaim>", "</DWPCAClaim>");
        details.addAll(prepareTestData(rootPath, Arrays.asList("CourseOfEducation")));
        return details;
    }

    private List<Pair<String, String>> sectionCustomerConsent(final String xml) {
        String rootPath = StringUtils.substringBetween(xml, "<Consents>", "</Consents>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("Consent", "Why"));
        details.add(ImmutablePair.of("", "Part 9 - Customer Consent And Declaration"));
        details.add(ImmutablePair.of("", "Additional Information"));
        details.add(ImmutablePair.of("", "Consent"));
        details.add(ImmutablePair.of("", "Disclaimer"));
        details.add(ImmutablePair.of("", "Declaration"));
        rootPath = StringUtils.substringBetween(xml, "<OtherInformation>", "</OtherInformation>");
        details.addAll(prepareTestData(rootPath, Arrays.asList("WelshCommunication", "AdditionalInformation")));
        return details;
    }

    private List<Pair<String, String>> sectionCustomerDisclaimer(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<Disclaimer>", "</Disclaimer>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("DisclaimerQuestion"));
        details.addAll(pathQuestionLabelAnswerTitle(rootPath));
        details.addAll(pathQuestionLabelAnswerContent(rootPath));
        return details;
    }

    private List<Pair<String, String>> sectionAboutOtherMoney(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<OtherBenefits>", "</OtherBenefits>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("EEAGuardQuestion", "EEAReceivePensionsBenefits", "EEAReceivePensionsBenefitsDetails", "EEAWorkingInsurance"));
        details.add(ImmutablePair.of("", "PART 7 - OTHER PAYMENTS"));
        return details;

    }

    private List<Pair<String, String>> careBreaks(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<Caree>", "</Caree>");
        final String[] careeBreaks = rootPath.split("<CareBreak>");
        final List<Pair<String, String>> details = new ArrayList<>();
        for (final String careeBreak : careeBreaks) {
            if (careeBreak.contains("<BreaksSinceClaim>")) {
                details.addAll(prepareTestData(careeBreak, Arrays.asList("StartDate", "EndDate", "BreaksSinceClaim", "ReasonClaimant", "Other", "ReasonCaree", "MedicalCare", "StartTime", "EndTime", "EndDateDoNotKnow")));
            }
        }
        return details;
    }

    private List<Pair<String, String>> employmentDetails(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<JobDetails>", "</JobDetails>");
        final String[] employers = rootPath.split("<Employer>");
        final List<Pair<String, String>> details = new ArrayList<>();
        for (final String employer : employers) {
            details.addAll(prepareTestData(employer, Arrays.asList("CurrentlyEmployed", "Name", "DidJobStartBeforeClaimDate",
                    "DateJobStarted", "DateJobEnded", "P45LeavingDate", "EmployersPhoneNumber", "JobType", "EmployersPhoneNumber")));
            details.add(pathQuestionLabelAnswerAddress(employer, "Address"));
            details.add(pathQuestionLabelAnswer(rootPath, "PostCode"));
            details.add(ImmutablePair.of("", "Employer's contact details"));
        }
        final String[] pays = rootPath.split("<Pay>");
        for (final String pay : pays) {
            details.addAll(prepareTestData(pay, Arrays.asList("WeeklyHoursWorked", "DateLastPaid", "GrossPayment",
                    "IncludedInWage", "ConstantEarnings", "PayFrequency", "UsualPayDay")));
            details.add(ImmutablePair.of("", "Your last wage"));
            details.add(ImmutablePair.of("", "Additional details on your last wage"));
        }
        final String[] jobs = rootPath.split("<JobDetails>");
        for (final String job : jobs) {
            details.addAll(prepareTestData(job, Arrays.asList("OweMoney", "PaidForPension", "PensionExpenses", "PaidForThingsToDoJob", "ExpensesToDoJob", "PaidForJobExpenses", "JobExpenses")));
            details.add(ImmutablePair.of("", "Pension And Expenses"));
        }
        return details;
    }

    public List<Pair<String, String>> sectionOtherIncomes(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<Incomes>", "</Incomes>");
        final List<Pair<String, String>> details = new ArrayList<>();
        if (rootPath != null && StringUtils.substringBetween(xml, "<NoOtherPayment>", "</NoOtherPayment>") == null) {
            details.addAll(statutorySickPay(rootPath));
            details.addAll(statutoryPay(rootPath));
            details.addAll(fosteringAllowance(rootPath));
            details.addAll(directPayment(rootPath));
            details.addAll(otherIncome(rootPath));
        }
        return details;
    }

    private List<Pair<String,String>> statutorySickPay(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<SickPay>", "</SickPay>");
        List<Pair<String, String>> details = new ArrayList<>();
        if (rootPath != null) {
            details = prepareTestData(rootPath, Arrays.asList("StillBeingPaidThisPay", "WhenDidYouLastGetPaid", "WhoPaidYouThisPay", "AmountOfThisPay"));
            details.add(pathQuestionLabelAnswerOther(rootPath, "HowOftenPaidThisPay", "HowOftenPaidThisPayOther"));
        }
        return details;
    }

    private List<Pair<String,String>> statutoryPay(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<StatutoryMaternityPaternityAdopt>", "</StatutoryMaternityPaternityAdopt>");
        List<Pair<String, String>> details = new ArrayList<>();
        if (rootPath != null) {
            details = prepareTestData(rootPath, Arrays.asList("PaymentTypesForThisPay", "StillBeingPaidThisPay", "WhenDidYouLastGetPaid", "WhoPaidYouThisPay", "AmountOfThisPay"));
            details.add(pathQuestionLabelAnswerOther(rootPath, "HowOftenPaidThisPay", "HowOftenPaidThisPayOther"));
        }
        return details;
    }

    private List<Pair<String,String>> fosteringAllowance(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<FosteringAllowance>", "</FosteringAllowance>");
        List<Pair<String, String>> details = new ArrayList<>();
        if (rootPath != null) {
            details = prepareTestData(rootPath, Arrays.asList("StillBeingPaidThisPay", "WhenDidYouLastGetPaid", "WhoPaidYouThisPay", "AmountOfThisPay"));
            details.add(pathQuestionLabelAnswerOther(rootPath, "PaymentTypesForThisPay", "PaymentTypesForThisPayOther"));
            details.add(pathQuestionLabelAnswerOther(rootPath, "HowOftenPaidThisPay", "HowOftenPaidThisPayOther"));
        }
        return details;
    }

    private List<Pair<String,String>> directPayment(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<DirectPay>", "</DirectPay>");
        List<Pair<String, String>> details = new ArrayList<>();
        if (rootPath != null) {
            details = prepareTestData(rootPath, Arrays.asList("StillBeingPaidThisPay", "WhenDidYouLastGetPaid", "WhoPaidYouThisPay", "AmountOfThisPay"));
            details.add(pathQuestionLabelAnswerOther(rootPath, "HowOftenPaidThisPay", "HowOftenPaidThisPayOther"));
        }
        return details;
    }

    private List<Pair<String,String>> otherIncome(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<OtherPaymentsInfo>", "</OtherPaymentsInfo>");
        final List<Pair<String, String>> details = new ArrayList<>();
        if (rootPath != null) {
            details.add(ImmutablePair.of("", pathQuestionLabel(rootPath, "OtherPaymentsInfo")));
            details.add(ImmutablePair.of("", pathAnswer(rootPath, "OtherPaymentsInfo")));
        }
        return details;
    }
}
