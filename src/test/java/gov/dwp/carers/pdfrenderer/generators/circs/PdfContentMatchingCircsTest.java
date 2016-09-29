package gov.dwp.carers.pdfrenderer.generators.circs;

import gov.dwp.carers.pdfrenderer.controllers.PdfServiceApplication;
import gov.dwp.carers.pdfrenderer.generators.PdfContentMatching;
import gov.dwp.carers.pdfrenderer.generators.PdfGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import gov.dwp.carers.pdfrenderer.testdata.circs.XMLCircsData;
import javax.inject.Inject;
import java.io.File;
import java.util.Arrays;

/**
 * Created by peterwhitehead on 09/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PdfServiceApplication.class)
@TestPropertySource(locations="classpath:test.application.properties")
public class PdfContentMatchingCircsTest extends PdfContentMatching {
    private static final Logger LOGGER = LoggerFactory.getLogger(PdfContentMatchingCircsTest.class);

    @Inject
    private PdfGenerator pdfGenerator;

    @Value("${jrxml.folder}")
    private String jrxmlLocation;

    @Test
    public void testExtractCircsPDFForFunctionalTestCasesAndMatchContentsVersions() throws Exception {
        final File allFiles = new File(jrxmlLocation);
        Arrays.asList(allFiles.listFiles()).stream().filter(f -> f.isDirectory()).forEach(folder -> {
            try {
                extractCircsPDFTestForVersion(folder.getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void extractCircsPDFTestForVersion(final String version) throws Exception {
        LOGGER.info("extractCircsPDFTestForVersion for version:" + version);
        final XMLCircsData xmlCircsData = new XMLCircsData();

        functionalTestCase1Test(version, xmlCircsData);
        functionalTestCase2Test(version, xmlCircsData);
        selfEmployedTest(version, xmlCircsData);
        breaksInCareTest(version, xmlCircsData);
        bankPaymentsTest(version, xmlCircsData);
        otherChangedTest(version, xmlCircsData);
        addressChangedTest(version, xmlCircsData);
        finishEmploymentTest(version, xmlCircsData);
        futureEmploymentTest(version, xmlCircsData);
        startedAndOngoingEmploymentTest(version, xmlCircsData);
    }

    private void functionalTestCase1Test(final String version, final XMLCircsData xmlCircsData) throws Exception {
        contentForCircsVersion(version, 1, pdfGenerator, xmlCircsData.functionalTestCase1);
    }

    private void functionalTestCase2Test(final String version, final XMLCircsData xmlCircsData) throws Exception {
        for (int i = 2; i <= 3; i++) {
            //2,3
            contentForCircsVersion(version, i, pdfGenerator, xmlCircsData.functionalTestCase2);
        }
    }

    private void selfEmployedTest(final String version, final XMLCircsData xmlCircsData) throws Exception {
        for (int i = 4; i <= 9; i++) {
            //4,5,6,7,8,9
            contentForCircsVersion(version, i, pdfGenerator, xmlCircsData.functionalTestDataSelfEmployed);
        }
    }

    private void breaksInCareTest(final String version, final XMLCircsData xmlCircsData) throws Exception {
        for (int i = 22; i <= 24; i++) {
            contentForCircsVersion(version, i, pdfGenerator, xmlCircsData.functionalTestDataBreaksInCareChangeDetails);
        }
    }

    private void bankPaymentsTest(final String version, final XMLCircsData xmlCircsData) throws Exception {
        for (int i = 10; i <= 13; i++) {
            //10,11,12,13
            contentForCircsVersion(version, i, pdfGenerator, xmlCircsData.functionalTestDataPaymentBankDetails);
        }
        contentForCircsVersion(version, 20, pdfGenerator, xmlCircsData.functionalTestDataPaymentBankDetails);
        contentForCircsVersion(version, 21, pdfGenerator, xmlCircsData.functionalTestDataPaymentBankDetails);
        contentForCircsVersion(version, 28, pdfGenerator, xmlCircsData.functionalTestDataPaymentBankDetails);
    }

    private void otherChangedTest(final String version, final XMLCircsData xmlCircsData) throws Exception {
        contentForCircsVersion(version, 30, pdfGenerator, xmlCircsData.functionalTestDataOtherDetails);
    }

    private void addressChangedTest(final String version, final XMLCircsData xmlCircsData) throws Exception {
        for (int i = 25; i <= 27; i++) {
            contentForCircsVersion(version, i, pdfGenerator, xmlCircsData.functionalTestDataAddressChangeDetails);
        }
    }

    private void finishEmploymentTest(final String version, final XMLCircsData xmlCircsData) throws Exception {
        contentForCircsVersion(version, 31, pdfGenerator, xmlCircsData.finishedEmployment);
        contentForCircsVersion(version, 32, pdfGenerator, xmlCircsData.finishedEmployment);
        contentForCircsVersion(version, 35, pdfGenerator, xmlCircsData.finishedEmployment);
        contentForCircsVersion(version, 36, pdfGenerator, xmlCircsData.finishedEmployment);
    }

    private void futureEmploymentTest(final String version, final XMLCircsData xmlCircsData) throws Exception {
        contentForCircsVersion(version, 37, pdfGenerator, xmlCircsData.futureEmployment);
    }

    private void startedAndOngoingEmploymentTest(final String version, final XMLCircsData xmlCircsData) throws Exception {
        contentForCircsVersion(version, 33, pdfGenerator, xmlCircsData.startedAndOngoingEmployment);
        contentForCircsVersion(version, 34, pdfGenerator, xmlCircsData.startedAndOngoingEmployment);
    }
}
