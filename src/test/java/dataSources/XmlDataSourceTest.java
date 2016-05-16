package dataSources;

import net.sf.jasperreports.engine.data.JRXmlDataSource;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

/**
 * Created by peterwhitehead on 06/05/2016.
 */
public class XmlDataSourceTest {
    @Test
    public void convertXMLtoJRXmlDataSource() {
        String xml = "<DWPCAClaim><DWPCATransaction>ER123DF</DWPCATransaction></DWPCAClaim>";
        XmlDataSource dataSource = new XmlDataSource(xml);
        assertThat(dataSource.convertToJRDataSource(), is(instanceOf(JRXmlDataSource.class)));
    }

    @Test
    public void jasperReportFilenameMatcherReturnsReportNewCircsForXMLContainingDWPCAChangeOfCircumstancesElement() {
        String xml = "<DWPBody><DWPCATransaction><DWPCAChangeOfCircumstances></DWPCAChangeOfCircumstances></DWPCATransaction></DWPBody>";
        XmlDataSource dataSource = new XmlDataSource(xml);
        assertThat(dataSource.jasperReportFilenameMatcher(), is("reportNewCircs"));
    }

    @Test
    public void jasperReportFilenameMatcherReturnsReportNewClaimForXMLContainingDWPCAClaimElement() {
        String xml = "<DWPBody><DWPCATransaction><DWPCAClaim></DWPCAClaim></DWPCATransaction></DWPBody>";
        XmlDataSource dataSource = new XmlDataSource(xml);
        assertThat(dataSource.jasperReportFilenameMatcher(), is("reportClaimWithSummary"));
    }

    @Test
    public void jasperReportFilenameMatcherThrowsForXMLNotContainingDWPCAChangeOfCircumstancesOrDWPCAClaimElement() {
        String xml = "<DWPBody><DWPCATransaction></DWPCATransaction></DWPBody>";
        XmlDataSource dataSource = new XmlDataSource(xml);
        assertThatThrownBy(() -> dataSource.jasperReportFilenameMatcher()).isInstanceOf(Exception.class).hasMessageContaining("XmlDataSource did not contain an XML element that matches a jasper template.");
    }

    @Test
    public void decryptEncryptedClaim() throws Exception {
        String xml = new String(Files.readAllBytes(Paths.get(getClass().getResource("/EncryptedSensitiveDataClaim.xml").toURI())));
        XmlDataSource dataSource = new XmlDataSource(xml);
        JRXmlDataSource jrDataSource = (JRXmlDataSource)dataSource.convertToJRDataSource();
        jrDataSource.next();
        String textDecrypted = jrDataSource.subDocument().getDocumentElement().getTextContent();
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
        String xml = new String(Files.readAllBytes(Paths.get(getClass().getResource("/EncryptedSensitiveDataChangeBankDetails.xml").toURI())));
        XmlDataSource dataSource = new XmlDataSource(xml);
        JRXmlDataSource jrDataSource = (JRXmlDataSource)dataSource.convertToJRDataSource();
        jrDataSource.next();
        String textDecrypted = jrDataSource.subDocument().getDocumentElement().getTextContent();
        assertThat(textDecrypted.contains("George Mason"), is(true));
        assertThat(textDecrypted.contains("Jeanne Mason"), is(true));
        assertThat(textDecrypted.contains("Name of account holderMe"), is(true));
        assertThat(textDecrypted.contains("Account number87654321"), is(true));
        assertThat(textDecrypted.contains("Sort code333333"), is(true));
    }

    @Test
    public void decryptEncryptedChangeAddress() throws Exception {
        String xml = new String(Files.readAllBytes(Paths.get(getClass().getResource("/EncryptedSensitiveDataChangeAddress.xml").toURI())));
        XmlDataSource dataSource = new XmlDataSource(xml);
        JRXmlDataSource jrDataSource = (JRXmlDataSource)dataSource.convertToJRDataSource();
        jrDataSource.next();
        String textDecrypted = jrDataSource.subDocument().getDocumentElement().getTextContent();
        assertThat(textDecrypted.contains("David Doe"), is(true));
        assertThat(textDecrypted.contains("George Doe"), is(true));
        assertThat(textDecrypted.contains("M5 3EJ"), is(true));
        assertThat(textDecrypted.contains("FY1 1RW"), is(true));
        assertThat(textDecrypted.contains("PR2 2HP"), is(true));
    }

}