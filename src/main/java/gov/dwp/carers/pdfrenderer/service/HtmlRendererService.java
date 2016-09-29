package gov.dwp.carers.pdfrenderer.service;

import gov.dwp.carers.pdfrenderer.generators.HtmlGenerator;
import gov.dwp.carers.monitor.Counters;
import org.springframework.stereotype.Component;
import javax.inject.Inject;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class HtmlRendererService extends RendererService {
    private final HtmlGenerator reportGenerator;

    public String generateHtml(final String xmlBody) {
        return outputHtmlGeneration(xmlBody, reportGenerator);
    }

    @Inject
    public HtmlRendererService(final HtmlGenerator htmlGenerator, final Counters counters) {
        super(counters);
        this.reportGenerator = htmlGenerator;
    }
}
