package gov.dwp.carers.pdfrenderer.datasources;

import gov.dwp.carers.xml.helpers.XmlSchemaDecryptor;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.ByteArrayInputStream;

public class CarersXmlDataSource implements ReportDataSource {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarersXmlDataSource.class);

    private final String xmlBody;
    private static final String CLAIM_JASPER_TEMPLATE = "reportClaimWithSummary";
    private static final String CIRCS_JASPER_TEMPLATE = "reportNewCircs";

    public CarersXmlDataSource(final String xmlBody) {
        this.xmlBody = xmlBody;
    }

    @Override
    public JRDataSource convertToJRDataSource() {
        JRDataSource jRDataSource = null;
        try {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Converting xml to JRDataSource started.");
            }
            final XmlSchemaDecryptor xmlSchemaDecryptor = new XmlSchemaDecryptor();
            final String decryptedSource = xmlSchemaDecryptor.decryptSchema(xmlBody);
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Converting xml to JRDataSource finished.");
            }
            jRDataSource = new JRXmlDataSource(new ByteArrayInputStream(decryptedSource.getBytes("UTF-8")));
        } catch (Exception e) {
            LOGGER.error("Failed to convert and decrypt carers xml to JRDataSource " + e.getMessage(), e);
            throw new InvalidXmlException("CarersXmlDataSource failed to convert and decrypt carers XML likely bad xml");
        }
        return jRDataSource;
    }

    @Override
    public String getTransactionId() {
        final String node = StringUtils.substringBetween(xmlBody, "<TransactionId>", "</TransactionId>");
        return StringUtils.isEmpty(node) ? "" : node;
    }

    @Override
    public String getReportName() {
        String rtnReportTemplate;
        if (xmlBody.contains("<DWPCAClaim>")) {
            rtnReportTemplate = CLAIM_JASPER_TEMPLATE;
        } else if (xmlBody.contains("<DWPCAChangeOfCircumstances>")) {
            rtnReportTemplate = CIRCS_JASPER_TEMPLATE;
        } else {
            throw new InvalidSourceFormatException("CarersXmlDataSource did not contain an XML element that matches a jasper template.");
        }
        return rtnReportTemplate;
    }

    @Override
    public String getReportVersion() {
        return (StringUtils.substringBetween(xmlBody, "<Version>", "</Version>"));
    }
}
