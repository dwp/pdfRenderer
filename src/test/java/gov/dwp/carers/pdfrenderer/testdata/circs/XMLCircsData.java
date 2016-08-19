package gov.dwp.carers.pdfrenderer.testdata.circs;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import gov.dwp.carers.pdfrenderer.utils.TestUtils;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by peterwhitehead on 09/05/2016.
 */
public class XMLCircsData extends TestUtils {
    public Function <String, List<String>> functionalTestCase1 = xml -> {
        final List<String> details = getClaimantDetails(xml);//
        details.addAll(getCareeDetails(xml));
        details.addAll(getDeclaration(xml));
        return details;
    };

    /**
     * Section with stopped caring and without Other changes
     * @param xml
     * @return
     */
    public Function <String, List<String>> functionalTestCase2 = xml -> {
        final List<String> details = getClaimantDetails(xml);//
        details.addAll(getCareeDetails(xml));
        details.addAll(getStoppedCaring(xml));
        details.addAll(getDeclaration(xml));
        return details;
    };

    public Function <String, List<String>> functionalTestDataSelfEmployed = xml -> {
        final List<String> details = getClaimantDetails(xml);//
        details.addAll(getCareeDetails(xml));
        details.addAll(getSelfEmployment(xml));
        details.addAll(getDeclaration(xml));
        return details;
    };

    public Function <String, List<String>> functionalTestDataPaymentBankDetails = xml -> {
        final List<String> details = getClaimantDetails(xml);//
        details.addAll(getCareeDetails(xml));
        details.addAll(getPaymentBankDetails(xml));
        details.addAll(getDeclaration(xml));
        return details;
    };

    public Function <String, List<String>> functionalTestDataAddressChangeDetails = xml -> {
        final List<String> details = getClaimantDetails(xml);//
        details.addAll(getCareeDetails(xml));
        details.addAll(getAddressChangeDetails(xml));
        details.addAll(getDeclaration(xml));
        return details;
    };

    public Function <String, List<String>> functionalTestDataBreaksInCareChangeDetails = xml -> {
        final List<String> details = getClaimantDetails(xml);//
        details.addAll(getCareeDetails(xml));
        details.addAll(getBreaksInCareChangeDetails(xml));
        details.addAll(getDeclaration(xml));
        return details;
    };

    public Function <String, List<String>> functionalTestDataOtherDetails = xml -> {
        final List<String> details = getClaimantDetails(xml);//
        details.addAll(getCareeDetails(xml));
        details.addAll(getOtherChanges(xml));
        details.addAll(getDeclaration(xml));
        return details;
    };

    public Function <String, List<String>> finishedEmployment = xml -> {
        final List<String> details = getFinishedEmployment(xml);//
        return details;
    };

    public Function <String, List<String>> startedAndOngoingEmployment = xml -> {
        final List<String> details = getStartedAndOngoingEmployment(xml);//
        return details;
    };

    public Function <String, List<String>> futureEmployment = xml -> {
        final List<String> details = getFutureEmployment(xml);//
        return details;
    };

    public List<String> getFinishedEmployment(final String xml) {
        final List<String> details = convertListOfPairsToListOfString(finishedEmploymentBasicDetails(xml));
        details.addAll(convertListOfPairsToListOfString(finishedEmploymentFurtherDetails(xml)));
        details.addAll(0, Arrays.asList(
                "Part 2 - Change in Circumstance - Employment Change",
                "Finished Employment"

        ));
        return details;
    }

    public List<String> getStartedAndOngoingEmployment(final String xml) {
        final List<String> details = convertListOfPairsToListOfString(startedAndOngoingEmploymentBasicDetails(xml));
        details.addAll(convertListOfPairsToListOfString(startedAndOngoingEmploymentFurtherDetails(xml)));
        details.addAll(0, Arrays.asList(
                "Part 2 - Change in Circumstance - Employment Change"
        ));
        return details;
    }

    public List<String> getFutureEmployment(final String xml) {
        final List<String> details = convertListOfPairsToListOfString(futureEmploymentBasicDetails(xml));
        details.addAll(convertListOfPairsToListOfString(futureEmploymentFurtherDetails(xml)));
        details.addAll(0, Arrays.asList(
                "Part 2 - Change in Circumstance - Employment Change"
        ));
        return details;
    }

    public List<String> getClaimantDetails(final String xml) {
        final List<String> details = convertListOfPairsToListOfString(claimantDetails(xml));
        details.addAll(0, Arrays.asList(
                "Part 1 - Identification - Carer and Person cared for",
                "Your details"
        ));
        return details;
    }

    public List<String> getCareeDetails(final String xml) {
        final List<String> details = convertListOfPairsToListOfString(careeDetails(xml));
        details.addAll(0, Arrays.asList(
                "Person you are caring for"
        ));
        return details;
    }

    public List<String> getStoppedCaring(final String xml) {
        final List<String> details = convertListOfPairsToListOfString(stoppedCaring(xml));
        details.addAll(0, Arrays.asList(
                "Part 2 - Change in Circumstance - Stopped Caring"
        ));
        return details;
    }

    public List<String> getSelfEmployment(final String xml) {
        final List<String> details = convertListOfPairsToListOfString(selfEmployment(xml));
        details.addAll(0, Arrays.asList(
                "Part 2 - Change in Circumstance - Started self employment",
                "About your self employment"
        ));
        return details;
    }

    public List<String> getOtherChanges(final String xml) {
        final List<String> details = convertListOfPairsToListOfString(otherChangesDetails(xml));
        details.addAll(0, Arrays.asList(
                "Part 2 - Change in Circumstance - Other Changes"
        ));
        return details;
    }


    public List<String> getPaymentBankDetails(final String xml) {
        final List<String> details = convertListOfPairsToListOfString(paymentBankDetailsPaidIntoAccount(xml));
        details.addAll(convertListOfPairsToListOfString(paymentBankDetailsAccountDetails(xml)));
        details.addAll(convertListOfPairsToListOfString(paymentBankDetailsBuildingSocietyDetails(xml)));
        details.addAll(0, Arrays.asList(
                "Part 2 - Change in Circumstance - Change of payment and bank details",
                "Existing payment details",
                "New payment details"
        ));
        return details;
   }

    public List<String> getAddressChangeDetails(final String xml) {
        final List<String> details = convertListOfPairsToListOfString(changeAddressDetails(xml));
        details.addAll(0, Arrays.asList(
                "Part 2 - Change in Circumstance - Change of address"
        ));
        return details;
    }

    public List<String> getBreaksInCareChangeDetails(final String xml) {
        final List<String> details = convertListOfPairsToListOfString(breaksInCareDetails(xml));
        details.addAll(convertListOfPairsToListOfString(breaksFromCaringEnded(xml)));
        details.addAll(0, Arrays.asList(
                "Part 2 - Change in Circumstance - Breaks From Caring"
        ));
        return details;
    }

    public List<String> getDeclaration(final String xml) {
        final List<String> details = convertListOfPairsToListOfString(declarationDetails(xml));
        details.addAll(convertListOfPairsToListOfString(declarationQuestionContentPath(xml)));
        details.addAll(convertListOfPairsToListOfString(consentsQuestionPath(xml)));
        details.addAll(convertListOfPairsToListOfString(consentsWhyQuestionPath(xml)));
        details.addAll(0, Arrays.asList(
                "Part 3 - Declaration",
                "Further Information",
                "Declaration"
        ));
        return details;
    }

    public List<Pair<String, String>> claimantDetails(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<ClaimantDetails>", "</ClaimantDetails>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("FullName", "DateOfBirth", "NationalInsuranceNumber", "ContactPreference"));
        return details;
    }

    public List<Pair<String, String>> careeDetails(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<ClaimantDetails>", "</CareeDetails>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("FullName","RelationToClaimant"));
        return details;
    }

    public List<Pair<String, String>> stoppedCaring(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<StoppedCaring>", "</StoppedCaring>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("DateStoppedCaring", "OtherChanges"));
        return details;
    }

    public List<Pair<String, String>> selfEmployment(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<SelfEmployedChange>", "</SelfEmployedChange>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("Caring35Hours", "BusinessStartDate", "BusinessType", "MoreThan100", "OtherChanges","DateStoppedCaring35Hours"));
        return details;
    }

    public List<Pair<String, String>> paymentBankDetailsPaidIntoAccount(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<PaidIntoAccountDetails>", "</PaidIntoAccountDetails>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("PaidIntoAccount", "BankName", "MethodOfPayment"));
        return details;
    }

    public List<Pair<String, String>> paymentBankDetailsAccountDetails(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<AccountDetails>", "</AccountDetails>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("AccountHolder", "HolderName"));
        return details;
    }

    public List<Pair<String, String>> paymentBankDetailsBuildingSocietyDetails(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<BuildingSocietyDetails>", "</BuildingSocietyDetails>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("AccountNumber", "RollNumber", "SortCode", "Name"));
        return details;
    }

    public List<Pair<String, String>> declarationDetails(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<Declaration>", "</Declaration>");
        final List<Pair<String, String>> declaration = prepareTestData(rootPath, Arrays.asList("DeclarationQuestion"));
        declaration.addAll(pathQuestionLabelAnswerTitle(rootPath));
        declaration.addAll(pathQuestionLabelAnswerContent(rootPath));
        return declaration;
    }

    public List<Pair<String, String>> declarationQuestionContentPath (final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<Declaration>", "</Declaration>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("DeclarationNameOrg"));
        return details;
    }

    public List<Pair<String, String>> consentsQuestionPath(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<Consents>", "</Consents>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("Consent"));
        return details;
    }

    public List<Pair<String, String>> consentsWhyQuestionPath(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<Consent>", "</Consent>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("Why"));
        return details;
    }

    public List<Pair<String, String>> changeAddressDetails(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<AddressChange>", "</AddressChange>");
        final String previousAddress = StringUtils.substringBetween(rootPath, "<PreviousAddress>", "</PreviousAddress>");
        final String newAddress = StringUtils.substringBetween(rootPath, "<NewAddress>", "</NewAddress>");
        final String personYouCareForAddress = StringUtils.substringBetween(rootPath, "<CareeAddress>", "</CareeAddress>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("Caring35Hours", "DateStoppedCaring35Hours", "CareeChangedAddress", "CareeSameAddress", "OtherChanges"));
        details.add(pathQuestionLabelAnswerAddress(previousAddress, "Address"));
        details.add(pathQuestionLabelAnswer(previousAddress, "PostCode"));
        details.add(pathQuestionLabelAnswerAddress(newAddress, "Address"));
        details.add(pathQuestionLabelAnswer(newAddress, "PostCode"));
        details.add(pathQuestionLabelAnswerAddress(personYouCareForAddress, "Address"));
        details.add(pathQuestionLabelAnswer(personYouCareForAddress, "PostCode"));
        return details;
    }

    public List<Pair<String, String>> breaksInCareDetails(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<BreakFromCaring>", "</BreakFromCaring>");
        final String wherePersonYouCare = StringUtils.substringBetween(rootPath, "<WherePersonYouCare>", "</WherePersonYouCare>");
        final String wherePersonYouCareSomeWhereElse = StringUtils.substringBetween(wherePersonYouCare, "<Other>", "</Other>");
        Pair<String, String> wherePerson = pathQuestionLabelAnswer(rootPath, "WherePersonYouCare");
        if (wherePersonYouCareSomeWhereElse != null) {
            wherePerson = ImmutablePair.of(buildQuestion(wherePerson.getLeft(), wherePerson.getRight()), wherePersonYouCareSomeWhereElse);
        }

        final String whereWereYou = StringUtils.substringBetween(rootPath, "<WhereWereYou>", "</WhereWereYou>");
        final String whereWereYouSomeWhereElse = StringUtils.substringBetween(whereWereYou, "<Other>", "</Other>");
        Pair<String, String> whereWere = pathQuestionLabelAnswer(rootPath, "WhereWereYou");
        if (whereWereYouSomeWhereElse != null) {
            whereWere = ImmutablePair.of(buildQuestion(whereWere.getLeft(), whereWere.getRight()), whereWereYouSomeWhereElse);
        }

        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("RecentBreakStartDate", "RecentBreakStartTime", "WherePersonYouCare", "WhereWereYou", "MedicalTreatmentDuringBreak", "MoreChanges", "AdditionalBreaksNotReported", "AdditionalBreaksNotReportedDesc"));
        details.add(wherePerson);
        details.add(whereWere);
        return details;
    }

    public List<Pair<String, String>> breaksFromCaringEnded(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<BreakFromCaringEnded>", "</BreakFromCaringEnded>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("HasBreakFromCaringEnded", "EndDate", "EndTime", "ExpectStartCaringAgain", "ExpectStartCaringAgainDate", "PermanentBreakDate"));
        return details;
    }

    public List<Pair<String, String>> otherChangesDetails(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<DWPCAChangeOfCircumstances>", "</DWPCAChangeOfCircumstances>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("OtherChanges"));
        return details;
    }

    public List<Pair<String, String>> employmentChangeBasicDetails(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<EmploymentChange>", "</EmploymentChange>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("StillCaring", "HasWorkStartedYet", "DateWorkedStarted", "HasWorkFinishedYet", "DateWorkedFinished", "TypeOfWork"));
        return details;
    }

    public List<Pair<String, String>> finishedEmploymentBasicDetails(final String xml) {
        return employmentChangeBasicDetails(xml);
    }

    public List<Pair<String, String>> finishedEmploymentFurtherDetails(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<StartedEmploymentAndFinished>", "</StartedEmploymentAndFinished>");
        final String employerAddress = StringUtils.substringBetween(rootPath, "<Address>", "</Address>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("EmployerOwesYouMoney", "PayFrequency", "BeenPaidYet", "HowMuchPaid", "PaymentDate", "WhatWasIncluded",
                "UsuallyPaidSameAmount", "PayIntoPension", "PayIntoPensionWhatFor", "PaidForThingsToDoJob", "PaidForThingsWhatFor", "CareCostsForThisWork", "CareCostsForThisWorkWhatCosts", "PayFrequency"));
        details.add(pathQuestionLabelAnswerAddress(employerAddress, "Address"));
        details.add(pathQuestionLabelAnswer(employerAddress, "PostCode"));
        return details;
    }

    public List<Pair<String, String>> startedAndOngoingEmploymentBasicDetails(final String xml) {
        return employmentChangeBasicDetails(xml);
    }

    public List<Pair<String, String>> startedAndOngoingEmploymentFurtherDetails(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<StartedEmploymentAndOngoing>", "</StartedEmploymentAndOngoing>");
        final String employerAddress = StringUtils.substringBetween(rootPath, "<Address>", "</Address>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("EmployerName", "EmployerContactNumber", "EmployerPayroll", "BeenPaidYet", "HowMuchPaid", "PaymentDate",
                "UsuallyPaidSameAmount", "PayIntoPension", "PayIntoPensionWhatFor", "PaidForThingsToDoJob", "PaidForThingsWhatFor", "CareCostsForThisWork", "CareCostsForThisWorkWhatCosts", "PayFrequency"));
        details.add(pathQuestionLabelAnswerAddress(employerAddress, "Address"));
        details.add(pathQuestionLabelAnswer(employerAddress, "PostCode"));
        return details;
    }

    public List<Pair<String, String>> futureEmploymentBasicDetails(final String xml) {
        return employmentChangeBasicDetails(xml);
    }

    public List<Pair<String, String>> futureEmploymentFurtherDetails(final String xml) {
        final String rootPath = StringUtils.substringBetween(xml, "<NotStartedEmployment>", "</NotStartedEmployment>");
        final String employerAddress = StringUtils.substringBetween(rootPath, "<Address>", "</Address>");
        final List<Pair<String, String>> details = prepareTestData(rootPath, Arrays.asList("EmployerName", "EmployerContactNumber", "EmployerPayroll", "BeenPaidYet", "HowMuchPaid", "PaymentDate",
                "UsuallyPaidSameAmount", "PayIntoPension", "PayIntoPensionWhatFor", "PaidForThingsToDoJob", "PaidForThingsWhatFor", "CareCostsForThisWork", "CareCostsForThisWorkWhatCosts", "PayFrequency"));
        details.add(pathQuestionLabelAnswerAddress(employerAddress, "Address"));
        details.add(pathQuestionLabelAnswer(employerAddress, "PostCode"));
        return details;
    }
    
}
