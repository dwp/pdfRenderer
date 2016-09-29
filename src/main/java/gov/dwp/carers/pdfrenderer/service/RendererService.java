package gov.dwp.carers.pdfrenderer.service;

import gov.dwp.carers.pdfrenderer.datasources.InvalidSourceFormatException;
import gov.dwp.carers.pdfrenderer.datasources.XmlDataSource;
import gov.dwp.carers.pdfrenderer.generators.GenerationSuccess;
import gov.dwp.carers.pdfrenderer.generators.ReportGenerator;
import gov.dwp.carers.pdfrenderer.generators.SuccessOrFailure;
import gov.dwp.carers.monitor.Counters;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.lang3.StringUtils;
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

    private String getTransactionId(final String xmlBody) {
        final String node = StringUtils.substringBetween(xmlBody, "<TransactionId>","</TransactionId>");
        return StringUtils.isEmpty(node) ? "" : node;
    }

    public String outputHtmlGeneration(final String xmlBody, final ReportGenerator reportGenerator) {
        String rtnMsg;
        try {
            rtnMsg = new String(outputGeneration(xmlBody, reportGenerator), "UTF-8");
        } catch (Exception e) {
            final String transactionId = getTransactionId(xmlBody);
            rtnMsg = ("<Error>Failed to convert output for transactionId: [" + transactionId + "]</Error>");
        }
        return rtnMsg;
    }

    public byte[] outputGeneration(final String xmlBody, final ReportGenerator reportGenerator) {
        final String transactionId = getTransactionId(xmlBody);
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] output;
        try {
            LOGGER.info("Creating output.");
            final JasperPrint print = reportGenerator.generateFrom(new XmlDataSource(xmlBody), StringUtils.substringBetween(xmlBody, "<Version>", "</Version>"));

            LOGGER.info("exporting jasper print to stream.");
            final SuccessOrFailure successOrFailure = reportGenerator.exportReportToStream(print, outputStream);
            if (successOrFailure instanceof GenerationSuccess) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("Generation success for transactionId: [" + transactionId + "]");
                }
                counters.incrementMetric("rs-render-count");
                output = outputStream.toByteArray();
            } else {
                LOGGER.error("Could not render XML for transactionId: [" + transactionId + "]");
                output = createErrorMessage(transactionId);
            }
        } catch (InvalidSourceFormatException e) {
            LOGGER.error("Could not render for transactionId: [" + transactionId + "]. " + e.getMessage(), e);
            output = createErrorMessage(transactionId);
        } catch (Throwable t) {
            LOGGER.error("Could not render for transactionId: [" + transactionId + "]. " + t.getMessage(), t);
            output = createErrorMessage(transactionId);
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

    private byte[] createErrorMessage(final String transactionId) {
        byte[] errorMsg;
        try {
            errorMsg = ("<Error>Failed to render XML for transactionId: [" + transactionId + "]</Error>").getBytes("UTF-8");
        } catch (UnsupportedEncodingException uee) {
            LOGGER.error("Unable to encode error string: " + uee.getMessage(), uee);
            errorMsg = ("<Error>Failed to render XML for transactionId: [" + transactionId + "]</Error>").getBytes();
        }
        return errorMsg;
    }

    @Inject
    public RendererService(final Counters counters) {
        this.counters = counters;
    }
}
