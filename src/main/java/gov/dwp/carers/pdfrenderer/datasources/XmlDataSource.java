package gov.dwp.carers.pdfrenderer.datasources;

import gov.dwp.carers.xml.helpers.XmlSchemaDecryptor;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.ByteArrayInputStream;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
public class XmlDataSource implements ReportDataSource {
    private static final Logger LOGGER = LoggerFactory.getLogger(XmlDataSource.class);

    private final String xmlBody;
    private static final String CLAIM_JASPER_TEMPLATE = "reportClaimWithSummary";
    private static final String CIRCS_JASPER_TEMPLATE = "reportNewCircs";

    public XmlDataSource(final String xmlBody) {
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
            LOGGER.error("Failed to convert xml to JRDataSource " + e.getMessage(), e);
        }
        return jRDataSource;
    }

    @Override
    public String jasperReportFilenameMatcher() {
        String rtnReportTemplate;
        if (xmlBody.contains("<DWPCAClaim>")) {
            rtnReportTemplate = CLAIM_JASPER_TEMPLATE;
        } else if (xmlBody.contains("<DWPCAChangeOfCircumstances>")) {
            rtnReportTemplate = CIRCS_JASPER_TEMPLATE;
        } else {
            throw new InvalidSourceFormatException("XmlDataSource did not contain an XML element that matches a jasper template.");
        }
        return rtnReportTemplate;
    }
}
