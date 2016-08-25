package service;

import controllers.PdfServiceApplication;
import dataSources.XmlDataSource;
import generators.HtmlGenerator;
import gov.dwp.carers.monitor.Counters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import testData.ClaimBuilder;
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
@SpringBootTest(classes = PdfServiceApplication.class)
@TestPropertySource(locations="classpath:test.application.properties")
public class HtmlRendererServiceTest {
    @Inject
    private HtmlRendererService htmlRendererService;

    @Test
    public void acceptXMLAndReturnBADREQUESTErrorIfUnknownXMLType() throws Exception {
        String status = htmlRendererService.generateHtml("<Invalid>type</Invalid>");
        assertThat(status, is("<Error>Failed to render XML for transactionId: []</Error>"));
    }

    @Test
    public void notAcceptNonXMLRequest() throws Exception {
        String status = htmlRendererService.generateHtml("Hello");
        assertThat(status, is("<Error>Failed to render XML for transactionId: []</Error>"));
    }

    @Test
    public void returnInternalErrorCodeIfCouldNotGenerateHTML() throws Exception {
        Counters counters = mock(Counters.class);
        HtmlGenerator reportGenerator = mock(HtmlGenerator.class);
        HtmlRendererService htmlRendererServiceMock = new HtmlRendererService(reportGenerator, counters);
        when(reportGenerator.generateFrom(Mockito.any(XmlDataSource.class), Mockito.anyString())).thenThrow(Throwable.class);
        String status = htmlRendererServiceMock.generateHtml(ClaimBuilder.goodClaim());
        assertThat(status, is("<Error>Failed to render XML for transactionId: [NFM33DB]</Error>"));
    }

    @Test
    public void acceptValidXMLAndGenerateAHTML() throws Exception {
        String status = htmlRendererService.generateHtml(ClaimBuilder.goodClaim());
        assertThat(status, containsString("Transaction: NFM33DB"));
    }
}