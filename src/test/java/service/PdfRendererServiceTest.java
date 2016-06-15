package service;

import controllers.PdfServiceApplication;
import generators.HtmlGenerator;
import generators.PdfGenerator;
import gov.dwp.carers.monitor.Counters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import testData.ClaimBuilder;
import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by peterwhitehead on 11/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PdfServiceApplication.class)
@TestPropertySource(locations="classpath:test.application.properties")
public class PdfRendererServiceTest {
    @Inject
    private PdfRendererService pdfRendererService;

    @Test
    public void acceptXMLAndReturnBADREQUESTErrorIfUnknownXMLType() throws Exception {
        byte[] status = pdfRendererService.generatePdf("<Invalid>type</Invalid>");
        assertThat(new String(status, "UTF-8"), is("<Error>Failed to render XML for transactionId: []</Error>"));
    }

    @Test
    public void notAcceptNonXMLRequest() throws Exception {
        byte[] status = pdfRendererService.generatePdf("Hello");
        assertThat(new String(status, "UTF-8"), is("<Error>Failed to render XML for transactionId: []</Error>"));
    }

    @Test
    public void returnInternalErrorCodeIfCouldNotGeneratePDF() throws Exception {
        PdfGenerator reportGenerator = mock(PdfGenerator.class);
        Counters counters = mock(Counters.class);
        PdfRendererService pdfRendererServiceMock = new PdfRendererService(reportGenerator, counters);
        byte[] status = pdfRendererServiceMock.generatePdf(ClaimBuilder.goodClaim());
        assertThat(new String(status, "UTF-8"), is("<Error>Failed to render XML for transactionId: [NFM33DB]</Error>"));
    }

    @Test
    public void acceptValidXMLAndGenerateAPDF() throws Exception {
        byte[] status = pdfRendererService.generatePdf(ClaimBuilder.goodClaim());
        assertThat(new String(status, "UTF-8"), containsString("PDF-1.4"));
    }
}