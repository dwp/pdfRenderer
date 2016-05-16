package service;

import generators.PdfGenerator;
import org.springframework.stereotype.Component;
import javax.inject.Inject;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class PdfRendererService extends RendererService {
    @Inject
    private PdfGenerator reportGenerator;

    public String generatePdf(String xmlBody) {
        return outputGeneration(xmlBody, reportGenerator);
    }
}
