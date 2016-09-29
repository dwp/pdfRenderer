package gov.dwp.carers.pdfrenderer.generators;

import gov.dwp.carers.pdfrenderer.datasources.XmlDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by peterwhitehead on 06/05/2016.
 */
public class FileHelper {
    public void deleteFile(final String fileLocation) {
        final File file = new File(fileLocation);
        if (file.exists()) {
            file.delete();
        }
    }

    public SuccessOrFailure generatePDF(final String pdfFileLocation, final String xml, final PdfGenerator pdfGenerator) throws Exception {
        return generateFile(pdfFileLocation, xml, pdfGenerator);
    }

    public SuccessOrFailure generateHTML(final String fileLocation, final String xml, final HtmlGenerator htmlGenerator) throws Exception {
        return generateFile(fileLocation, xml, htmlGenerator);
    }

    private SuccessOrFailure generateFile(final String fileLocation, final String xml, final ReportGenerator generator) throws Exception {
        final XmlDataSource dataSource = new XmlDataSource(xml);
        final JasperPrint print = generator.generateFrom(dataSource, StringUtils.substringBetween(xml, "<Version>", "</Version>"));
        final FileOutputStream fileOutputStream = new FileOutputStream(fileLocation);
        return generator.exportReportToStream(print, fileOutputStream);
    }
}
