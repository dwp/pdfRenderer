package generators.claim;

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
import testData.claim.XMLClaimData;

import javax.inject.Inject;
import java.io.File;
import java.util.Arrays;

/**
 * Created by peterwhitehead on 10/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PdfServiceApplication.class)
public class PdfContentMatchingClaimTest extends PdfContentMatching {
    private static final Logger logger = LoggerFactory.getLogger(PdfContentMatchingClaimTest.class);

    @Inject
    private PdfGenerator pdfGenerator;

    @Value("${jrxml.folder}")
    private String jrxmlLocation;

    @Test
    public void extractClaimPDFForFunctionalTestCasesAndMatchContentsVersions() throws Exception {
        File allFiles = new File(jrxmlLocation);
        Arrays.asList(allFiles.listFiles()).stream().filter(f -> f.isDirectory()).forEach(folder -> {
            try {
                extractClaimPDFTestForVersion(folder.getName());
            } catch (Exception e) { throw new RuntimeException(e); }
        });
    }

    private void extractClaimPDFTestForVersion(String version) throws Exception {
        logger.info("extractClaimPDFTestForVersion for version:" + version);
        XMLClaimData xmlClaimData = new XMLClaimData();
        testContentForClaimVersion(version, 1, pdfGenerator, xmlClaimData.functionalTestCase1);
        testContentForClaimVersion(version, 2, pdfGenerator, xmlClaimData.functionalTestCase2);
        testContentForClaimVersion(version, 3, pdfGenerator, xmlClaimData.functionalTestCase3);
        testContentForClaimVersion(version, 4, pdfGenerator, xmlClaimData.functionalTestCase4);
        testContentForClaimVersion(version, 5, pdfGenerator, xmlClaimData.functionalTestCase5);
        testContentForClaimVersion(version, 6, pdfGenerator, xmlClaimData.functionalTestCase6);
        testContentForClaimVersion(version, 7, pdfGenerator, xmlClaimData.functionalTestCase7);
        testContentForClaimVersion(version, 8, pdfGenerator, xmlClaimData.functionalTestCase8);
        testContentForClaimVersion(version, 9, pdfGenerator, xmlClaimData.functionalTestCase9);
        testContentForClaimVersion(version, 10, pdfGenerator, xmlClaimData.functionalTestCase10);
        testContentForClaimVersion(version, 11, pdfGenerator, xmlClaimData.functionalTestCase11);
        testContentForClaimVersion(version, 12, pdfGenerator, xmlClaimData.functionalTestCase12);
        testContentForClaimVersion(version, 13, pdfGenerator, xmlClaimData.functionalTestCase13);
        testContentForClaimVersion(version, 14, pdfGenerator, xmlClaimData.functionalTestCase14);
        testContentForClaimVersion(version, 15, pdfGenerator, xmlClaimData.functionalTestCase15);
//        if (version.equals("0.24"))newForVersion24(version, xmlClaimData);
    }

//    //in here until version 24 is first in config i.e. removed older versions then it can be moved into main section
//    private void newForVersion24(String version, XMLClaimData xmlClaimData) throws Exception {
//        testContentForClaimVersion(version, 16, pdfGenerator, xmlClaimData.functionalTestCaseVersion24);
//    }
}
