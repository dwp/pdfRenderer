package service;

import generators.PdfGenerator;
import gov.dwp.carers.monitor.Counters;
import org.springframework.stereotype.Component;
import javax.inject.Inject;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class PdfRendererService extends RendererService {
    private PdfGenerator reportGenerator;

    public byte[] generatePdf(String xmlBody) {
        return outputGeneration(xmlBody, reportGenerator);
    }

    @Inject
    public PdfRendererService(PdfGenerator pdfGenerator, Counters counters) {
        super(counters);
        this.reportGenerator = pdfGenerator;
    }
}
