package gov.dwp.carers.pdfrenderer.generators.claim;

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
import gov.dwp.carers.pdfrenderer.testdata.claim.XMLClaimData;
import javax.inject.Inject;
import java.io.File;
import java.util.Arrays;

/**
 * Created by peterwhitehead on 10/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PdfServiceApplication.class)
@TestPropertySource(locations="classpath:test.application.properties")
public class PdfContentMatchingClaimTest extends PdfContentMatching {
    private static final Logger LOGGER = LoggerFactory.getLogger(PdfContentMatchingClaimTest.class);

    @Inject
    private PdfGenerator pdfGenerator;

    @Value("${jrxml.folder}")
    private String jrxmlLocation;

    @Test
    public void testExtractClaimPDFForFunctionalTestCasesAndMatchContentsVersions() throws Exception {
        final File allFiles = new File(jrxmlLocation);
        Arrays.asList(allFiles.listFiles()).stream().filter(f -> f.isDirectory()).forEach(folder -> {
            try {
                extractClaimPDFTestForVersion(folder.getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void extractClaimPDFTestForVersion(final String version) throws Exception {
        LOGGER.info("extractClaimPDFTestForVersion for version:" + version);
        final XMLClaimData xmlClaimData = new XMLClaimData();
        contentForClaimVersion(version, 1, pdfGenerator, xmlClaimData.functionalTestCase1);
        contentForClaimVersion(version, 2, pdfGenerator, xmlClaimData.functionalTestCase2);
        contentForClaimVersion(version, 3, pdfGenerator, xmlClaimData.functionalTestCase3);
        contentForClaimVersion(version, 4, pdfGenerator, xmlClaimData.functionalTestCase4);
        contentForClaimVersion(version, 5, pdfGenerator, xmlClaimData.functionalTestCase5);
        contentForClaimVersion(version, 6, pdfGenerator, xmlClaimData.functionalTestCase6);
        contentForClaimVersion(version, 7, pdfGenerator, xmlClaimData.functionalTestCase7);
        contentForClaimVersion(version, 8, pdfGenerator, xmlClaimData.functionalTestCase8);
        contentForClaimVersion(version, 9, pdfGenerator, xmlClaimData.functionalTestCase9);
        contentForClaimVersion(version, 10, pdfGenerator, xmlClaimData.functionalTestCase10);
        contentForClaimVersion(version, 11, pdfGenerator, xmlClaimData.functionalTestCase11);
        contentForClaimVersion(version, 12, pdfGenerator, xmlClaimData.functionalTestCase12);
        contentForClaimVersion(version, 13, pdfGenerator, xmlClaimData.functionalTestCase13);
        contentForClaimVersion(version, 14, pdfGenerator, xmlClaimData.functionalTestCase14);
        contentForClaimVersion(version, 15, pdfGenerator, xmlClaimData.functionalTestCase15);
    }
}
