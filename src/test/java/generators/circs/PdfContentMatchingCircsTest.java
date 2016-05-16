package generators.circs;

import controllers.PdfServiceApplication;
import generators.PdfContentMatching;
import generators.PdfGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import testData.circs.XMLCircsData;

import javax.inject.Inject;
import java.io.File;
import java.util.Arrays;

/**
 * Created by peterwhitehead on 09/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PdfServiceApplication.class)
public class PdfContentMatchingCircsTest extends PdfContentMatching {
    private static final Logger logger = LoggerFactory.getLogger(PdfContentMatchingCircsTest.class);

    @Inject
    private PdfGenerator pdfGenerator;

    @Value("${jrxml.folder}")
    private String jrxmlLocation;

    @Test
    public void extractCircsPDFForFunctionalTestCasesAndMatchContentsVersions() throws Exception {
        File allFiles = new File(jrxmlLocation);
        Arrays.asList(allFiles.listFiles()).stream().filter(f -> f.isDirectory()).forEach(folder -> {
            try {
                extractCircsPDFTestForVersion(folder.getName());
            } catch (Exception e) { throw new RuntimeException(e); }
        });
    }

    private void extractCircsPDFTestForVersion(String version) throws Exception {
        logger.info("extractCircsPDFTestForVersion for version:" + version);
        XMLCircsData xmlCircsData = new XMLCircsData();

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

    private void functionalTestCase1Test(String version, XMLCircsData xmlCircsData) throws Exception {
        testContentForCircsVersion(version, 1, pdfGenerator, xmlCircsData.functionalTestCase1);
    }

    private void functionalTestCase2Test(String version, XMLCircsData xmlCircsData) throws Exception {
        for (int i = 2; i <= 3; i++) {
            //2,3
            testContentForCircsVersion(version, i, pdfGenerator, xmlCircsData.functionalTestCase2);
        }
    }

    private void selfEmployedTest(String version, XMLCircsData xmlCircsData) throws Exception {
        for (int i = 4; i <= 9; i++) {
            //4,5,6,7,8,9
            testContentForCircsVersion(version, i, pdfGenerator, xmlCircsData.functionalTestDataSelfEmployed);
        }
    }

    private void breaksInCareTest(String version, XMLCircsData xmlCircsData) throws Exception {
        for (int i = 22; i <= 24; i++) {
            testContentForCircsVersion(version, i, pdfGenerator, xmlCircsData.functionalTestDataBreaksInCareChangeDetails);
        }
    }

    private void bankPaymentsTest(String version, XMLCircsData xmlCircsData) throws Exception {
        for (int i = 10; i <= 13; i++) {
            //10,11,12,13
            testContentForCircsVersion(version, i, pdfGenerator, xmlCircsData.functionalTestDataPaymentBankDetails);
        }
        testContentForCircsVersion(version, 20, pdfGenerator, xmlCircsData.functionalTestDataPaymentBankDetails);
        testContentForCircsVersion(version, 21, pdfGenerator, xmlCircsData.functionalTestDataPaymentBankDetails);
        testContentForCircsVersion(version, 28, pdfGenerator, xmlCircsData.functionalTestDataPaymentBankDetails);
    }

    private void otherChangedTest(String version, XMLCircsData xmlCircsData) throws Exception {
        testContentForCircsVersion(version, 30, pdfGenerator, xmlCircsData.functionalTestDataOtherDetails);
    }

    private void addressChangedTest(String version, XMLCircsData xmlCircsData) throws Exception {
        for (int i = 25; i <= 27; i++) {
            testContentForCircsVersion(version, i, pdfGenerator, xmlCircsData.functionalTestDataAddressChangeDetails);
        }
    }

    private void finishEmploymentTest(String version, XMLCircsData xmlCircsData) throws Exception {
        testContentForCircsVersion(version, 31, pdfGenerator, xmlCircsData.finishedEmployment);
        testContentForCircsVersion(version, 32, pdfGenerator, xmlCircsData.finishedEmployment);
        testContentForCircsVersion(version, 35, pdfGenerator, xmlCircsData.finishedEmployment);
        testContentForCircsVersion(version, 36, pdfGenerator, xmlCircsData.finishedEmployment);
    }

    private void futureEmploymentTest(String version, XMLCircsData xmlCircsData) throws Exception {
        testContentForCircsVersion(version, 37, pdfGenerator, xmlCircsData.futureEmployment);
    }

    private void startedAndOngoingEmploymentTest(String version, XMLCircsData xmlCircsData) throws Exception {
        testContentForCircsVersion(version, 33, pdfGenerator, xmlCircsData.startedAndOngoingEmployment);
        testContentForCircsVersion(version, 34, pdfGenerator, xmlCircsData.startedAndOngoingEmployment);
    }
}
