package gov.dwp.carers.pdfrenderer.service;

import gov.dwp.carers.pdfrenderer.generators.PdfGenerator;
import gov.dwp.carers.monitor.Counters;
import org.springframework.stereotype.Component;
import javax.inject.Inject;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class PdfRendererService extends RendererService {
    private final PdfGenerator reportGenerator;

    public byte[] generatePdf(final String xmlBody) {
        return outputGeneration(xmlBody, reportGenerator);
    }

    @Inject
    public PdfRendererService(final PdfGenerator pdfGenerator, final Counters counters) {
        super(counters);
        this.reportGenerator = pdfGenerator;
    }
}
