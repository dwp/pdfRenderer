package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import service.HtmlRendererService;
import service.PdfRendererService;
import utils.RenameThread;
import javax.inject.Inject;

/**
 * Created by peterwhitehead on 03/05/2016.
 */
@RestController
@Component
public class Application {
    private final Logger logger = LoggerFactory.getLogger(Application.class);

    private PdfRendererService pdfRendererService;
    private HtmlRendererService htmlRendererService;

    @RequestMapping(value = "/print", method = RequestMethod.POST, consumes = "text/xml")
    public @ResponseBody byte[] generatePDF(@RequestBody String requestBody) {
        RenameThread.getTransactionIdAndRenameThread(requestBody);
        logger.info("generatePDF called with requestBody");
        return pdfRendererService.generatePdf(requestBody);
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST, consumes = "application/xml")
    public @ResponseBody String generateHTML(@RequestBody String requestBody) {
        RenameThread.getTransactionIdAndRenameThread(requestBody);
        logger.info("generateHTML called with requestBody");
        return htmlRendererService.generateHtml(requestBody);
    }

    @Inject
    public Application(PdfRendererService pdfRendererService, HtmlRendererService htmlRendererService) {
        this.pdfRendererService = pdfRendererService;
        this.htmlRendererService = htmlRendererService;
    }
}
