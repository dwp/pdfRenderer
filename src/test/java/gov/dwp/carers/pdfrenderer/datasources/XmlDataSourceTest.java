package gov.dwp.carers.pdfrenderer.datasources;

import net.sf.jasperreports.engine.data.JRXmlDataSource;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;

public class XmlDataSourceTest {
    @Test
    public void errorWhenBadXMLtoJRXmlDataSource() {
        String xml = "not xml!";
        String expectedError="XmlDataSource failed to convert XML likely bad xml";
        XmlDataSource dataSource = new XmlDataSource("1234", "testReport", "", xml);
        assertThatThrownBy(() -> dataSource.convertToJRDataSource()).isInstanceOf(InvalidXmlException.class).hasMessageContaining(expectedError);
    }

    @Test
    public void convertParamstoJRXmlDataSource() {
        String xml = "<Body><q1>Question</q1></Body>";
        XmlDataSource dataSource = new XmlDataSource("1234", "any-report", "XX", xml);
        assertThat(dataSource.getTransactionId(), is("1234"));
        assertThat(dataSource.getReportVersion(), is("XX"));
        assertThat(dataSource.getReportName(), is("any-report"));
    }

    @Test
    public void convertXMLtoJRXmlDataSource() {
        String xml = "<Body><q1>Question</q1></Body>";
        XmlDataSource dataSource = new XmlDataSource("1234", "testReport", "", xml);
        assertThat(dataSource.convertToJRDataSource(), is(instanceOf(JRXmlDataSource.class)));
    }
}