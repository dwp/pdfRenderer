package gov.dwp.carers.pdfrenderer.service;

import gov.dwp.carers.pdfrenderer.controllers.PdfServiceApplication;
import gov.dwp.carers.pdfrenderer.datasources.XmlDataSource;
import gov.dwp.carers.pdfrenderer.generators.HtmlGenerator;
import gov.dwp.carers.monitor.Counters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import gov.dwp.carers.pdfrenderer.testdata.ClaimBuilder;
import javax.inject.Inject;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by peterwhitehead on 11/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PdfServiceApplication.class)
@TestPropertySource(locations="classpath:test.application.properties")
public class HtmlRendererServiceTest {
    @Inject
    private HtmlRendererService htmlRendererService;

    @Test
    public void acceptXMLAndReturnBADREQUESTErrorIfUnknownXMLType() throws Exception {
        final String status = htmlRendererService.generateHtml("<Invalid>type</Invalid>");
        assertThat(status, is("<Error>Failed to render XML for transactionId: []</Error>"));
    }

    @Test
    public void notAcceptNonXMLRequest() throws Exception {
        final String status = htmlRendererService.generateHtml("Hello");
        assertThat(status, is("<Error>Failed to render XML for transactionId: []</Error>"));
    }

    @Test
    public void returnInternalErrorCodeIfCouldNotGenerateHTML() throws Exception {
        final Counters counters = mock(Counters.class);
        final HtmlGenerator reportGenerator = mock(HtmlGenerator.class);
        final HtmlRendererService htmlRendererServiceMock = new HtmlRendererService(reportGenerator, counters);
        when(reportGenerator.generateFrom(Mockito.any(XmlDataSource.class), Mockito.anyString())).thenThrow(Throwable.class);
        final String status = htmlRendererServiceMock.generateHtml(ClaimBuilder.goodClaim());
        assertThat(status, is("<Error>Failed to render XML for transactionId: [NFM33DB]</Error>"));
    }

    @Test
    public void acceptValidXMLAndGenerateAHTML() throws Exception {
        final String status = htmlRendererService.generateHtml(ClaimBuilder.goodClaim());
        assertThat(status, containsString("Transaction: NFM33DB"));
    }
}