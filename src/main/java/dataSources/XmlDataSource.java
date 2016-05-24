package dataSources;

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
    Logger logger = LoggerFactory.getLogger(XmlDataSource.class);

    private String xmlBody;
    private String claimJasperTemplate = "reportClaimWithSummary";
    private String circsJasperTemplate = "reportNewCircs";

    public XmlDataSource(String xmlBody) {
        this.xmlBody = xmlBody;
    }

    @Override
    public JRDataSource convertToJRDataSource() {
        try {
            logger.debug("Converting xml to JRDataSource");
            XmlSchemaDecryptor xmlSchemaDecryptor = new XmlSchemaDecryptor();
            String decryptedSource = xmlSchemaDecryptor.decryptSchema(xmlBody);
            return new JRXmlDataSource(new ByteArrayInputStream(decryptedSource.getBytes("UTF-8")));
        } catch (Exception e) {
            logger.error("Failed to convert xml to JRDataSource " + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public String jasperReportFilenameMatcher() {
        Boolean claimElement = xmlBody.contains("<DWPCAClaim>");
        Boolean circsElement = xmlBody.contains("<DWPCAChangeOfCircumstances>");
        if (claimElement) return claimJasperTemplate;
        else if (circsElement) return circsJasperTemplate;
        else throw new InvalidSourceFormatException("XmlDataSource did not contain an XML element that matches a jasper template.");
    }
}
