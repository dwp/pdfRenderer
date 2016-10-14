package gov.dwp.carers.pdfrenderer.service;

import gov.dwp.carers.pdfrenderer.controllers.PdfServiceApplication;
import gov.dwp.carers.pdfrenderer.datasources.XmlDataSource;
import gov.dwp.carers.pdfrenderer.utils.ParsePdf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.inject.Inject;
import java.io.FileOutputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PdfServiceApplication.class)
@TestPropertySource(locations="classpath:test.application.properties")
public class PdfRendererServiceTest {
    ParsePdf parsePdf=new ParsePdf();

    @Inject
    private PdfRendererService pdfRendererService;

    String goodXml = "<Body><TestData><Question>Test Question</Question><Answer>Test Answer</Answer></TestData></Body>";

    @Test
    public void errorWhenNoReportType() throws Exception {
        XmlDataSource source = new XmlDataSource("", "", "", "<data></data>");
        byte[] response = pdfRendererService.generatePdf(source);
        assertThat(new String(response, "UTF-8"), is("<Error>Report name not specified unable to generate report</Error>"));
    }

    @Test
    public void errorWhenBadReportType() throws Exception {
        XmlDataSource source = new XmlDataSource("", "badReportName", "", "<data></data>");
        final byte[] response = pdfRendererService.generatePdf(source);
        assertThat(new String(response, "UTF-8"), is("<Error>Failed to find report for :/badReportName</Error>"));
    }

    @Test
    public void correctlyTransformGoodDataWithVersion() throws Exception {
        XmlDataSource source = new XmlDataSource("", "testReport", "1.00", goodXml);
        final byte[] response = pdfRendererService.generatePdf(source);
        String pdfText=parsePdf.getPdfText(response);
        assertThat(pdfText, containsString("Test Question"));
        assertThat(pdfText, containsString("Test Answer"));
    }

    @Test
    public void errorWhenNonXMLRequest() throws Exception {
        XmlDataSource source=new XmlDataSource("", "testReport", "", "This is not xml!");
        final byte[] response = pdfRendererService.generatePdf(source);
        assertThat(new String(response, "UTF-8"), is("<Error>Failed to convert XML for transactionId:</Error>"));
    }

    @Test
    public void createPdfOutFileForDebug() throws Exception {
        String pdffile="testReport.pdf";
        XmlDataSource source = new XmlDataSource("", "testReport", "1.00", goodXml);
        byte[] response = pdfRendererService.generatePdf(source);
        FileOutputStream fos = new FileOutputStream(pdffile);
        fos.write(response);
        fos.close();
        System.out.println("=======================================");
        System.out.println("testReport jasper pdf written to " + pdffile);
    }
}