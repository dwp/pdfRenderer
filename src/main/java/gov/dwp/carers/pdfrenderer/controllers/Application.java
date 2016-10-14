package gov.dwp.carers.pdfrenderer.controllers;

import gov.dwp.carers.pdfrenderer.datasources.CarersXmlDataSource;
import gov.dwp.carers.pdfrenderer.datasources.InvalidSourceFormatException;
import gov.dwp.carers.pdfrenderer.datasources.XmlDataSource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import gov.dwp.carers.pdfrenderer.service.HtmlRendererService;
import gov.dwp.carers.pdfrenderer.service.PdfRendererService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import utils.RenameThread;

import javax.inject.Inject;

/**
 * Created by peterwhitehead on 03/05/2016.
 */
@RestController
@Component
@EnableWebMvc
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    private static final String CLAIM_JASPER_TEMPLATE = "reportClaimWithSummary";
    private static final String CIRCS_JASPER_TEMPLATE = "reportNewCircs";

    private final PdfRendererService pdfRendererService;
    private final HtmlRendererService htmlRendererService;

    @RequestMapping(value = "/print", method = RequestMethod.POST, consumes = "text/xml")
    public
    @ResponseBody
    byte[] generatePDF(@RequestBody final String requestBody) {
        RenameThread.getTransactionIdAndRenameThread(requestBody);
        LOGGER.info("generatePDF called with requestBody");
        CarersXmlDataSource carersData = new CarersXmlDataSource(requestBody);
        return pdfRendererService.generatePdf(carersData);
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST, consumes = "application/xml")
    public
    @ResponseBody
    String generateHTML(@RequestBody final String requestBody) {
        RenameThread.getTransactionIdAndRenameThread(requestBody);
        LOGGER.info("generateHTML called with requestBody");
        CarersXmlDataSource carersData = new CarersXmlDataSource(requestBody);
        return htmlRendererService.generateHtml(carersData);
    }

    @RequestMapping(value = "/pdf", method = RequestMethod.POST)
    public
    @ResponseBody
    byte[] doPDF(
            @RequestParam("transactionid") String transactionid,
            @RequestParam("reportname") String reportName,
            @RequestParam("reportversion") String reportVersion,
            @RequestParam("xml") String xml) {
        RenameThread.renameThreadFromTransactionId(transactionid);
        LOGGER.info("/pdf called for transactionid:" + transactionid + " at version:" + reportVersion);
        XmlDataSource source=new XmlDataSource(transactionid, reportName, reportVersion, xml);
        return pdfRendererService.generatePdf(source);
    }

    @RequestMapping(value = "/html", method = RequestMethod.POST)
    public
    @ResponseBody
    String doHtml(
            @RequestParam("transactionid") String transactionid,
            @RequestParam("reportname") String reportName,
            @RequestParam("reportversion") String reportVersion,
            @RequestParam("xml") String xml) {
        RenameThread.renameThreadFromTransactionId(transactionid);
        LOGGER.info("/html called for transactionid:" + transactionid + " at version:" + reportVersion);
        XmlDataSource source=new XmlDataSource(transactionid, reportName, reportVersion, xml);
        return htmlRendererService.generateHtml(source);
    }

    @Inject
    public Application(final PdfRendererService pdfRendererService, final HtmlRendererService htmlRendererService) {
        this.pdfRendererService = pdfRendererService;
        this.htmlRendererService = htmlRendererService;
    }

}
