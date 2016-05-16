package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import service.HtmlRendererService;
import service.PdfRendererService;
import utils.RenameThread;
import javax.inject.Inject;

/**
 * Created by peterwhitehead on 03/05/2016.
 */
@RestController
public class Application {
    private final Logger logger = LoggerFactory.getLogger(Application.class);

    @Inject
    private PdfRendererService pdfRendererService;

    @Inject
    private HtmlRendererService htmlRendererService;

    @RequestMapping(value = "/print", method = RequestMethod.POST, consumes = "application/xml")
    public @ResponseBody String generatePDF(@RequestBody String requestBody) {
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
}
