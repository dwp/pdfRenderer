package gov.dwp.carers.pdfrenderer.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import gov.dwp.carers.pdfrenderer.service.HtmlRendererService;
import gov.dwp.carers.pdfrenderer.service.PdfRendererService;
import utils.RenameThread;
import javax.inject.Inject;

/**
 * Created by peterwhitehead on 03/05/2016.
 */
@RestController
@Component
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private final PdfRendererService pdfRendererService;
    private final HtmlRendererService htmlRendererService;

    @RequestMapping(value = "/print", method = RequestMethod.POST, consumes = "text/xml")
    public @ResponseBody byte[] generatePDF(@RequestBody final String requestBody) {
        RenameThread.getTransactionIdAndRenameThread(requestBody);
        LOGGER.info("generatePDF called with requestBody");
        return pdfRendererService.generatePdf(requestBody);
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST, consumes = "application/xml")
    public @ResponseBody String generateHTML(@RequestBody final String requestBody) {
        RenameThread.getTransactionIdAndRenameThread(requestBody);
        LOGGER.info("generateHTML called with requestBody");
        return htmlRendererService.generateHtml(requestBody);
    }

    @Inject
    public Application(final PdfRendererService pdfRendererService, final HtmlRendererService htmlRendererService) {
        this.pdfRendererService = pdfRendererService;
        this.htmlRendererService = htmlRendererService;
    }
}
