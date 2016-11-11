package gov.dwp.carers.pdfrenderer.service;

import gov.dwp.carers.pdfrenderer.controllers.PdfServiceApplication;
import gov.dwp.carers.pdfrenderer.datasources.XmlDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.inject.Inject;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PdfServiceApplication.class)
@TestPropertySource(locations = "classpath:test.application.properties")
public class HtmlRendererServiceTest {
    @Inject
    private HtmlRendererService htmlRendererService;

    String goodXml = "<Body><TestData><Question>QUESTION1</Question><Answer>ANSWER1</Answer></TestData></Body>";

    @Test
    public void errorWhenNoReportType() throws Exception {
        XmlDataSource source = new XmlDataSource("", "", "", "<data></data>");
        final String response = htmlRendererService.generateHtml(source);
        assertThat(response, is("<Error>Report name not specified unable to generate report</Error>"));
    }

    @Test
    public void errorWhenBadReportType() throws Exception {
        XmlDataSource source = new XmlDataSource("", "badReportName", "", "<data></data>");
        final String response = htmlRendererService.generateHtml(source);
        assertThat(response, is("<Error>Failed to find report for :/badReportName</Error>"));
    }

    @Test
    public void correctlyTransformGoodDataWithVersion() throws Exception {
        XmlDataSource source = new XmlDataSource("", "testReport", "1.00", goodXml);
        final String response = htmlRendererService.generateHtml(source);
        assertThat(response, containsString("QUESTION1"));
        assertThat(response, containsString("ANSWER1"));
    }

    @Test
    public void errorWhenNonXMLRequest() throws Exception {
        XmlDataSource source=new XmlDataSource("", "testReport", "1.00", "This is not xml!");
        final String status = htmlRendererService.generateHtml(source);
        assertThat(status, is("<Error>Failed to convert XML for transactionId:</Error>"));
    }
}