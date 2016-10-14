package gov.dwp.carers.pdfrenderer.datasources;

import net.sf.jasperreports.engine.data.JRXmlDataSource;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarersXmlDataSourceTest {
    private String xml;
    private CarersXmlDataSource dataSource;
    
    @Test
    public void convertXMLtoJRXmlDataSource() {
        xml = "<DWPCAClaim><DWPCATransaction>ER123DF</DWPCATransaction></DWPCAClaim>";
        dataSource = new CarersXmlDataSource(xml);
        assertThat(dataSource.convertToJRDataSource(), is(instanceOf(JRXmlDataSource.class)));
    }

    @Test
    public void extractsCircsReportNameFromCarersXml() {
        xml = "<DWPBody><DWPCATransaction><DWPCAChangeOfCircumstances></DWPCAChangeOfCircumstances></DWPCATransaction></DWPBody>";
        dataSource = new CarersXmlDataSource(xml);
        assertThat(dataSource.getReportName(), is("reportNewCircs"));
    }

    @Test
    public void extractsClaimReportNameFromCarersXml() {
        xml = "<DWPBody><DWPCATransaction><DWPCAClaim></DWPCAClaim></DWPCATransaction></DWPBody>";
        dataSource = new CarersXmlDataSource(xml);
        assertThat(dataSource.getReportName(), is("reportClaimWithSummary"));
    }

    @Test
    public void extractsNeitherClaimNotCircsReportNameFromCarersXml() {
        xml = "<DWPBody><DWPCATransaction></DWPCATransaction></DWPBody>";
        String expectedError="CarersXmlDataSource did not contain an XML element that matches a jasper template.";
        dataSource = new CarersXmlDataSource(xml);
        assertThatThrownBy(() -> dataSource.getReportName()).isInstanceOf(Exception.class).hasMessageContaining(expectedError);
    }

    @Test
    public void extractsReportVersionFromCarersXml() {
        xml = "<DWPBody><DWPCATransaction><Version>0.24</Version><TransactionId>1234</TransactionId><DWPCAClaim></DWPCAClaim></DWPCATransaction></DWPBody>";
        dataSource = new CarersXmlDataSource(xml);
        assertThat(dataSource.getReportVersion(), is("0.24"));
    }

    @Test
    public void extractsTransactionIdFromCarersXml() {
        xml = "<DWPBody><DWPCATransaction><TransactionId>1234</TransactionId><DWPCAClaim></DWPCAClaim></DWPCATransaction></DWPBody>";
        dataSource = new CarersXmlDataSource(xml);
        assertThat(dataSource.getTransactionId(), is("1234"));
    }

    @Test
    public void decryptEncryptedClaim() throws Exception {
        xml = new String(Files.readAllBytes(Paths.get(getClass().getResource("/EncryptedSensitiveDataClaim.xml").toURI())));
        dataSource = new CarersXmlDataSource(xml);
        final JRXmlDataSource jrDataSource = (JRXmlDataSource)dataSource.convertToJRDataSource();
        jrDataSource.next();
        final String textDecrypted = jrDataSource.subDocument().getDocumentElement().getTextContent();
        assertThat(textDecrypted.contains("nameDoe"), is(true));
        assertThat(textDecrypted.contains("National Insurance numberAA000001A"), is(true));
        assertThat(textDecrypted.contains("PR2 2HP"), is(true));
        assertThat(textDecrypted.contains("National Insurance numberAA000002A"), is(true));
        assertThat(textDecrypted.contains("FY14 4AJ"), is(true));
        assertThat(textDecrypted.contains("Name of account holderMe"), is(true));
        assertThat(textDecrypted.contains("Account number12345678"), is(true));
        assertThat(textDecrypted.contains("Sort code222222"), is(true));
    }

    @Test
    public void decryptEncryptedChangeBankDetails() throws Exception {
        xml = new String(Files.readAllBytes(Paths.get(getClass().getResource("/EncryptedSensitiveDataChangeBankDetails.xml").toURI())));
        dataSource = new CarersXmlDataSource(xml);
        final JRXmlDataSource jrDataSource = (JRXmlDataSource)dataSource.convertToJRDataSource();
        jrDataSource.next();
        final String textDecrypted = jrDataSource.subDocument().getDocumentElement().getTextContent();
        assertThat(textDecrypted.contains("George Mason"), is(true));
        assertThat(textDecrypted.contains("Jeanne Mason"), is(true));
        assertThat(textDecrypted.contains("Name of account holderMe"), is(true));
        assertThat(textDecrypted.contains("Account number87654321"), is(true));
        assertThat(textDecrypted.contains("Sort code333333"), is(true));
    }

    @Test
    public void decryptEncryptedChangeAddress() throws Exception {
        xml = new String(Files.readAllBytes(Paths.get(getClass().getResource("/EncryptedSensitiveDataChangeAddress.xml").toURI())));
        dataSource = new CarersXmlDataSource(xml);
        final JRXmlDataSource jrDataSource = (JRXmlDataSource)dataSource.convertToJRDataSource();
        jrDataSource.next();
        final String textDecrypted = jrDataSource.subDocument().getDocumentElement().getTextContent();
        assertThat(textDecrypted.contains("David Doe"), is(true));
        assertThat(textDecrypted.contains("George Doe"), is(true));
        assertThat(textDecrypted.contains("M5 3EJ"), is(true));
        assertThat(textDecrypted.contains("FY1 1RW"), is(true));
        assertThat(textDecrypted.contains("PR2 2HP"), is(true));
    }
}