package gov.dwp.carers.pdfrenderer.controllers;

import gov.dwp.carers.pdfrenderer.datasources.CarersXmlDataSource;
import gov.dwp.carers.pdfrenderer.datasources.XmlDataSource;
import gov.dwp.exceptions.DwpRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import gov.dwp.carers.pdfrenderer.service.HtmlRendererService;
import gov.dwp.carers.pdfrenderer.service.PdfRendererService;
import utils.RenameThread;

import javax.inject.Inject;

// ColinG beware @EnableWebMvc breaks Pdf extended characters like euro and bullet.
@RestController
@Component
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    private static final String CLAIM_JASPER_TEMPLATE = "reportClaimWithSummary";
    private static final String CIRCS_JASPER_TEMPLATE = "reportNewCircs";

    private final PdfRendererService pdfRendererService;
    private final HtmlRendererService htmlRendererService;

    @RequestMapping(value = "/print", method = RequestMethod.POST, consumes = "text/xml")
    @ResponseBody
    public byte[] generatePDF(@RequestBody final String requestBody) {
        RenameThread.getTransactionIdAndRenameThread(requestBody);
        LOGGER.info("STARTED /print Application.generatePDF with requestBody");
        byte[] response = null;
        try {
            CarersXmlDataSource carersData = new CarersXmlDataSource(requestBody);
            response = pdfRendererService.generatePdf(carersData);
        } finally {
            LOGGER.info("ENDED /print Application.generatePDF with requestBody");
        }
        return response;
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST, consumes = "application/xml")
    @ResponseBody
    public String generateHTML(@RequestBody final String requestBody) {
        RenameThread.getTransactionIdAndRenameThread(requestBody);
        LOGGER.info("STARTED /show Application.generateHTML with requestBody");
        String response = null;
        try {
            CarersXmlDataSource carersData = new CarersXmlDataSource(requestBody);
            response = htmlRendererService.generateHtml(carersData);
        } finally {
            LOGGER.info("ENDED /show Application.generateHTML");
        }
        return response;
    }

    @RequestMapping(value = "/pdf", method = RequestMethod.POST)
    @ResponseBody
    public byte[] doPDF(
            @RequestParam("transactionid") String transactionid,
            @RequestParam("reportname") String reportName,
            @RequestParam("reportversion") String reportVersion,
            @RequestParam("xml") String xml) {
        RenameThread.renameThreadFromTransactionId(transactionid);
        LOGGER.info("STARTED /pdf Application.doPDF for transaction:{} reportname:{} version:{}", transactionid, reportName, reportVersion);
        byte[] response = null;
        try {
            XmlDataSource source = new XmlDataSource(transactionid, reportName, reportVersion, xml);
            response = pdfRendererService.generatePdf(source);
        } finally {
            LOGGER.info("ENDED /pdf Application.doPDF with requestBody");
        }
        return response;
    }

    @RequestMapping(value = "/html", method = RequestMethod.POST)
    @ResponseBody
    public String doHtml(
            @RequestParam("transactionid") String transactionid,
            @RequestParam("reportname") String reportName,
            @RequestParam("reportversion") String reportVersion,
            @RequestParam("xml") String xml) {
        RenameThread.renameThreadFromTransactionId(transactionid);
        LOGGER.info("STARTED /html Application.doHTML for transaction:{} reportname:{} version:{}", transactionid, reportName, reportVersion);
        String response = null;
        try {
            XmlDataSource source = new XmlDataSource(transactionid, reportName, reportVersion, xml);
            response = htmlRendererService.generateHtml(source);
        } finally {
            LOGGER.info("ENDED /html Application.doHTML");
        }
        return response;
    }

    @Inject
    public Application(final PdfRendererService pdfRendererService, final HtmlRendererService htmlRendererService) {
        this.pdfRendererService = pdfRendererService;
        this.htmlRendererService = htmlRendererService;
    }
}
