package service;

import dataSources.InvalidSourceFormatException;
import dataSources.XmlDataSource;
import generators.GenerationSuccess;
import generators.ReportGenerator;
import generators.SuccessOrFailure;
import gov.dwp.carers.monitor.Counters;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.io.ByteArrayOutputStream;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class RendererService {
    Logger logger = LoggerFactory.getLogger(RendererService.class);

    private Counters counters;

    private String getTransactionId(String xmlBody) {
        String node = StringUtils.substringBetween(xmlBody, "<TransactionId>","</TransactionId>");
        return StringUtils.isEmpty(node) ? "" : node;
    }

    public String outputHtmlGeneration(String xmlBody, ReportGenerator reportGenerator) {
        String transactionId = getTransactionId(xmlBody);
        try {
            return new String(outputGeneration(xmlBody, reportGenerator), "UTF-8");
        } catch (Exception e) {
            return ("<Error>Failed to convert output for transactionId: [" + transactionId + "]</Error>");
        }
    }

    public byte[] outputGeneration(String xmlBody, ReportGenerator reportGenerator) {
        String transactionId = getTransactionId(xmlBody);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            logger.info("Creating output.");
            JasperPrint print = reportGenerator.generateFrom(new XmlDataSource(xmlBody), StringUtils.substringBetween(xmlBody, "<Version>", "</Version>"));

            logger.info("exporting jasper print to stream.");
            SuccessOrFailure successOrFailure = reportGenerator.exportReportToStream(print, outputStream);
            if (successOrFailure instanceof GenerationSuccess) {
                logger.info("Generation success for transactionId: [" + transactionId + "]");
                counters.incrementMetric("rs-render-count");
                return outputStream.toByteArray();
            } else {
                logger.error("Could not render XML for transactionId: [" + transactionId + "]");
                return ("<Error>Failed to render XML for transactionId: [" + transactionId + "]</Error>").getBytes();
            }
        } catch (InvalidSourceFormatException e) {
            logger.error("Could not render for transactionId: [" + transactionId + "]. " + e.getMessage(), e);
            return ("<Error>Failed to render XML for transactionId: [" + transactionId + "]</Error>").getBytes(); // Error already logged by generator;
        } catch (Throwable t) {
            logger.error("Could not render for transactionId: [" + transactionId + "]. " + t.getMessage(), t);
            return ("<Error>Failed to render XML for transactionId: [" + transactionId + "]</Error>").getBytes();
        } finally {
            if (outputStream != null) try { outputStream.close(); } catch (Exception e) { logger.error("Unable to close output stream", e);}
        }
    }

    @Inject
    public RendererService(Counters counters) {
        this.counters = counters;
    }
}
