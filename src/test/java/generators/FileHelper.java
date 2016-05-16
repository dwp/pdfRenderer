package generators;

import dataSources.XmlDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by peterwhitehead on 06/05/2016.
 */
public class FileHelper {
    public void deleteFile(String fileLocation) {
        File file = new File(fileLocation);
        if (file.exists()) {
            file.delete();
        }
    }

    public SuccessOrFailure generatePDF(String pdfFileLocation, String xml, PdfGenerator pdfGenerator) throws Exception {
        return generateFile(pdfFileLocation, xml, pdfGenerator);
    }

    public SuccessOrFailure generateHTML(String fileLocation, String xml, HtmlGenerator htmlGenerator) throws Exception {
        return generateFile(fileLocation, xml, htmlGenerator);
    }

    private SuccessOrFailure generateFile(String fileLocation, String xml, ReportGenerator generator) throws Exception {
        XmlDataSource dataSource = new XmlDataSource(xml);
        JasperPrint print = generator.generateFrom(dataSource, StringUtils.substringBetween(xml, "<Version>", "</Version>"));
        FileOutputStream fileOutputStream = new FileOutputStream(fileLocation);
        return generator.exportReportToStream(print, fileOutputStream);
    }
}
