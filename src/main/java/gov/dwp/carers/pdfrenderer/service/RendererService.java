package gov.dwp.carers.pdfrenderer.service;

import gov.dwp.carers.pdfrenderer.datasources.InvalidReportException;
import gov.dwp.carers.pdfrenderer.datasources.InvalidSourceFormatException;
import gov.dwp.carers.pdfrenderer.datasources.InvalidXmlException;
import gov.dwp.carers.pdfrenderer.datasources.ReportDataSource;
import gov.dwp.carers.pdfrenderer.generators.GenerationSuccess;
import gov.dwp.carers.pdfrenderer.generators.ReportGenerator;
import gov.dwp.carers.pdfrenderer.generators.SuccessOrFailure;
import gov.dwp.carers.monitor.Counters;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import netscape.javascript.JSException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class RendererService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RendererService.class);

    private final Counters counters;

    public String outputHtmlGeneration(final ReportDataSource source, final ReportGenerator reportGenerator) {
        String rtnMsg;
        try {
            rtnMsg = new String(outputGeneration(source, reportGenerator), "UTF-8");
        } catch (Exception e) {
            rtnMsg = ("<Error>Failed to convert output for transactionId: [" + source.getTransactionId() + "]</Error>");
        }
        return rtnMsg;
    }

    public byte[] outputGeneration(final ReportDataSource source, final ReportGenerator reportGenerator) {
        if (source.getReportName() == null || source.getReportName().equals("")) {
            LOGGER.error("Report name not specified unable to create pdf");
            return (createErrorMessage("Report name not specified unable to generate report"));
        }
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] output;
        try {
            LOGGER.info("RendererService outputGeneration creating output for report:" + source.getReportName() + " version:" + source.getReportVersion());
            final JasperPrint print = reportGenerator.generateFrom(source);
            LOGGER.info("exporting jasper print to stream.");
            final SuccessOrFailure successOrFailure = reportGenerator.exportReportToStream(print, outputStream);
            if (successOrFailure instanceof GenerationSuccess) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("Generation success for transactionId: [" + source.getTransactionId() + "]");
                }
                counters.incrementMetric("rs-render-count");
                output = outputStream.toByteArray();
            } else {
                LOGGER.error("Could not render XML for transactionId: [" + source.getTransactionId() + "]");
                output = createErrorMessage("Failed to render XML for transactionId:" + source.getTransactionId());
            }
        } catch (InvalidReportException e) {
            LOGGER.error("InvalidReportException - Could not find jasper report for transactionId: [" + source.getTransactionId() + "]. " + e.getMessage(), e);
            output = createErrorMessage("Failed to find report for :" + source.getReportVersion() + "/" + source.getReportName());
        } catch (InvalidXmlException e) {
            LOGGER.error("JRException - Could not convert xml for transactionId: [" + source.getTransactionId() + "]. " + e.getMessage(), e);
            output = createErrorMessage("Failed to convert XML for transactionId:" + source.getTransactionId());
        } catch (JRException e) {
            LOGGER.error("JRException - Could not render for transactionId: [" + source.getTransactionId() + "]. " + e.getMessage(), e);
            output = createErrorMessage("Failed to render XML for transactionId:" + source.getTransactionId());
        } catch (InvalidSourceFormatException e) {
            LOGGER.error("InvalidSourceFormatException - Could not render for transactionId: [" + source.getTransactionId() + "]. " + e.getMessage(), e);
            output = createErrorMessage("Failed to render XML for transactionId:" + source.getTransactionId()+" invalid source");
        } catch (Throwable t) {
            LOGGER.error("Throwable - Could not render for transactionId: [" + source.getTransactionId() + "]. " + t.getMessage(), t);
            output = createErrorMessage("Failed to render XML for transactionId:" + source.getTransactionId());
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                    LOGGER.error("Unable to close output stream", e);
                }
            }
        }
        return output;
    }

    private byte[] createErrorMessage(final String message) {
        byte[] errorMsg;
        try {
            errorMsg = ("<Error>" + message + "</Error>").getBytes("UTF-8");
        } catch (UnsupportedEncodingException uee) {
            LOGGER.error("Unable to encode error string: " + uee.getMessage(), uee);
            errorMsg = ("<Error>" + message + "</Error>").getBytes();
        }
        return errorMsg;
    }

    @Inject
    public RendererService(final Counters counters) {
        this.counters = counters;
    }
}
