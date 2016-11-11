package gov.dwp.carers.pdfrenderer.datasources;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.ByteArrayInputStream;

public class XmlDataSource implements ReportDataSource {
    private static final Logger LOGGER = LoggerFactory.getLogger(XmlDataSource.class);

    private final String transactionId;
    private final String reportName;
    private final String reportVersion;
    private final String xmlBody;

    public XmlDataSource(final String transactionId, final String reportName, final String reportVersion, final String xmlBody) {
        this.transactionId = transactionId;
        this.reportName = reportName;
        this.reportVersion = reportVersion;
        this.xmlBody = xmlBody;
    }

    @Override
    public JRDataSource convertToJRDataSource() {
        JRDataSource jRDataSource = null;
        try {
            jRDataSource = new JRXmlDataSource(new ByteArrayInputStream(xmlBody.getBytes("UTF-8")));
        } catch (Exception e) {
            LOGGER.error("Failed to convert xml to JRDataSource " + e.getMessage(), e);
            throw new InvalidXmlException("XmlDataSource failed to convert XML likely bad xml");
        }
        return jRDataSource;
    }

    @Override
    public String getTransactionId() {
        return this.transactionId;
    }

    @Override
    public String getReportName() {
        return this.reportName;
    }

    @Override
    public String getReportVersion() {
        return this.reportVersion;
    }
}
