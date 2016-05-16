package service;

import dataSources.InvalidSourceFormatException;
import dataSources.XmlDataSource;
import generators.GenerationSuccess;
import generators.ReportGenerator;
import generators.SuccessOrFailure;
import monitoring.Counters;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class RendererService {
    Logger logger = LoggerFactory.getLogger(RendererService.class);

    @Inject
    private Counters counters;

    OutputStream outputStream = new ByteArrayOutputStream();

    public String outputGeneration(String xmlBody, ReportGenerator reportGenerator) {
        String node = StringUtils.substringBetween(xmlBody, "<TransactionId>","</TransactionId>");
        String transactionId = StringUtils.isEmpty(node) ? "" : node;
        try {
            logger.debug("treating XML received.");
            JasperPrint print = reportGenerator.generateFrom(new XmlDataSource(xmlBody), StringUtils.substringBetween(xmlBody, "<Version>","</Version>"));

            SuccessOrFailure successOrFailure = reportGenerator.exportReportToStream(print, outputStream);
            if (successOrFailure instanceof GenerationSuccess) {
                logger.info("Generation success for transactionId: [" + transactionId + "]");
                counters.recordClaimRenderCount();
                return outputStream.toString();
            } else {
                logger.error("Could not render XML for transactionId: [" + transactionId + "]");
                return "<Error>Failed to render XML for transactionId: [" + transactionId + "]</Error>";
            }
        } catch (InvalidSourceFormatException e) {
            logger.error("Could not render for transactionId: [" + transactionId + "]. " + e.getMessage(), e);
            return "<Error>Failed to render XML for transactionId: [" + transactionId + "]</Error>"; // Error already logged by generator;
        } catch (Throwable t) {
            logger.error("Could not render for transactionId: [" + transactionId + "]. " + t.getMessage(), t);
            return "<Error>Failed to render XML for transactionId: [" + transactionId + "]</Error>";
        }
    }
}
