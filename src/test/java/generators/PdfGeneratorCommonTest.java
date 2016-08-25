package generators;

import controllers.PdfServiceApplication;
import dataSources.InvalidSourceFormatException;
import dataSources.XmlDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import testData.ClaimBuilder;
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
@SpringBootTest(classes = PdfServiceApplication.class)
@TestPropertySource(locations="classpath:test.application.properties")
public class PdfGeneratorCommonTest extends FileHelper {

    @Inject
    private PdfGenerator pdfGenerator;

    @Value("${jrxml.folder}")
    private String jrxmlLocation;

    private String getVersion(String xml) {
        return StringUtils.substringBetween(xml, "<Version>", "</Version>");
    }

    @Test
    public void rejectXMLThatDoesNotContainDWPCAClaimOrDWPCACircs() throws Exception {
        String pdfFileLocation = "goodClaimReject.pdf";
        String xml = ClaimBuilder.badClaim();
        String generatorResult = "";
        try {
            XmlDataSource dataSource = new XmlDataSource(xml);
            JasperPrint jasperPrint = pdfGenerator.generateFrom(dataSource, getVersion(xml));
            pdfGenerator.exportReportToStream(jasperPrint, new FileOutputStream(pdfFileLocation));
        } catch(InvalidSourceFormatException e) {
            generatorResult = "";
        } catch (Exception e) {
            fail();
        }
        assertThat(generatorResult , is(""));
    }

    @Test
    public void handleValidXMLAndReturnSuccess() throws Exception {
        String pdfFileLocation = "goodClaimSuccess.pdf";
        String xml = ClaimBuilder.goodClaim();
        XmlDataSource dataSource = new XmlDataSource(xml);
        JasperPrint print = pdfGenerator.generateFrom(dataSource, getVersion(xml));
        if (print.getPages().size() == 0)fail();
        SuccessOrFailure generatorResult = pdfGenerator.exportReportToStream(print, new FileOutputStream(pdfFileLocation));
        assertThat(generatorResult, is(instanceOf(GenerationSuccess.class)));
        deleteFile(pdfFileLocation);
    }

    @Test
    public void createAPDFFile() throws Exception {
        String pdfFileLocation = "goodClaimCreate.pdf";
        String xml = ClaimBuilder.goodClaim();
        XmlDataSource dataSource = new XmlDataSource(xml);
        JasperPrint print = pdfGenerator.generateFrom(dataSource, getVersion(xml));
        if (print.getPages().size() == 0)fail();
        pdfGenerator.exportReportToStream(print, new FileOutputStream(pdfFileLocation));
        File pdfFile = new File(pdfFileLocation);
        assertThat(pdfFile.exists(), is(true));
        deleteFile(pdfFileLocation);
    }

    @Test
    public void writeFilesInParallel() throws Exception {
        File allFiles = new File(jrxmlLocation);
        List<File> list = Arrays.asList(allFiles.listFiles());
        list.parallelStream().filter(f -> f.isDirectory()).forEach(x -> {
            try {
                String pdfFileLocation = "parallelTestFile" + x.getName().replace("0.", "") + ".pdf";
                String xml = new String(Files.readAllBytes(Paths.get(getClass().getResource("/c3_functional9.xml").toURI())));
                XmlDataSource dataSource = new XmlDataSource(xml);
                JasperPrint print = pdfGenerator.generateFrom(dataSource, getVersion(xml));
                if (print.getPages().size() == 0)fail();
                pdfGenerator.exportReportToStream(print, new FileOutputStream(pdfFileLocation));
                File pdfFile = new File(pdfFileLocation);
                assertThat(pdfFile.exists(), is(true));
            } catch (URISyntaxException | IOException e) {
                fail();
            }
        });

        list.forEach(x -> {
            String pdfFileLocation = "parallelTestFile" + x.getName().replace("0.", "") + ".pdf";
            deleteFile(pdfFileLocation);
        });
    }

}
