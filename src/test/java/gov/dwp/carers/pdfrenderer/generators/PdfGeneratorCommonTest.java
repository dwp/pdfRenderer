package gov.dwp.carers.pdfrenderer.generators;

import gov.dwp.carers.pdfrenderer.controllers.PdfServiceApplication;
import gov.dwp.carers.pdfrenderer.datasources.InvalidSourceFormatException;
import gov.dwp.carers.pdfrenderer.datasources.XmlDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import gov.dwp.carers.pdfrenderer.testdata.ClaimBuilder;
import javax.inject.Inject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.fail;

/**
 * Created by peterwhitehead on 06/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PdfServiceApplication.class)
@TestPropertySource(locations="classpath:test.application.properties")
public class PdfGeneratorCommonTest extends FileHelper {
    private String pdfFileLocation;
    private String xml;


    @Inject
    private PdfGenerator pdfGenerator;

    @Value("${jrxml.folder}")
    private String jrxmlLocation;

    private String getVersion(final String xml) {
        return StringUtils.substringBetween(xml, "<Version>", "</Version>");
    }

    @Test
    public void testRejectXMLThatDoesNotContainDWPCAClaimOrDWPCACircs() throws Exception {
        pdfFileLocation = "goodClaimReject.pdf";
        xml = ClaimBuilder.badClaim();
        String generatorResult = "";
        try {
            final XmlDataSource dataSource = new XmlDataSource(xml);
            final JasperPrint jasperPrint = pdfGenerator.generateFrom(dataSource, getVersion(xml));
            pdfGenerator.exportReportToStream(jasperPrint, new FileOutputStream(pdfFileLocation));
        } catch(InvalidSourceFormatException e) {
            generatorResult = "";
        } catch (Exception e) {
            fail();
        }
        assertThat(generatorResult , is(""));
    }

    @Test
    public void testHandleValidXMLAndReturnSuccess() throws Exception {
        pdfFileLocation = "goodClaimSuccess.pdf";
        xml = ClaimBuilder.goodClaim();
        final XmlDataSource dataSource = new XmlDataSource(xml);
        final JasperPrint print = pdfGenerator.generateFrom(dataSource, getVersion(xml));
        if (print.getPages().size() == 0) {
            fail();
        }
        final SuccessOrFailure generatorResult = pdfGenerator.exportReportToStream(print, new FileOutputStream(pdfFileLocation));
        assertThat(generatorResult, is(instanceOf(GenerationSuccess.class)));
        deleteFile(pdfFileLocation);
    }

    @Test
    public void testCreateAPDFFile() throws Exception {
        pdfFileLocation = "goodClaimCreate.pdf";
        xml = ClaimBuilder.goodClaim();
        final XmlDataSource dataSource = new XmlDataSource(xml);
        final JasperPrint print = pdfGenerator.generateFrom(dataSource, getVersion(xml));
        if (print.getPages().size() == 0) {
            fail();
        }
        pdfGenerator.exportReportToStream(print, new FileOutputStream(pdfFileLocation));
        final File pdfFile = new File(pdfFileLocation);
        assertThat(pdfFile.exists(), is(true));
        deleteFile(pdfFileLocation);
    }

    @Test
    public void testWriteFilesInParallel() throws Exception {
        final File allFiles = new File(jrxmlLocation);
        final List<File> list = Arrays.asList(allFiles.listFiles());
        list.parallelStream().filter(f -> f.isDirectory()).forEach(x -> {
            try {
                final String pdfFileLocation = "parallelTestFile" + x.getName().replace("0.", "") + ".pdf";
                final String xml = new String(Files.readAllBytes(Paths.get(getClass().getResource("/c3_functional9.xml").toURI())));
                final XmlDataSource dataSource = new XmlDataSource(xml);
                final JasperPrint print = pdfGenerator.generateFrom(dataSource, getVersion(xml));
                if (print.getPages().size() == 0) {
                    fail();
                }
                pdfGenerator.exportReportToStream(print, new FileOutputStream(pdfFileLocation));
                final File pdfFile = new File(pdfFileLocation);
                assertThat(pdfFile.exists(), is(true));
            } catch (URISyntaxException | IOException e) {
                fail();
            }
        });

        list.forEach(x -> {
            final String pdfFileLocation = "parallelTestFile" + x.getName().replace("0.", "") + ".pdf";
            deleteFile(pdfFileLocation);
        });
    }

}
