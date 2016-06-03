package generators;

import helpers.CarersWriter;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterConfiguration;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleHtmlReportConfiguration;
import net.sf.jasperreports.export.type.HtmlSizeUnitEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.OutputStream;
import java.util.List;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class HtmlGenerator extends ReportGenerator {
    private static final Logger logger = LoggerFactory.getLogger(HtmlGenerator.class);
    
    @Override
    public SuccessOrFailure exportReportToStream(JasperPrint print, OutputStream stream) {
        try {
            if (print != null) {
                logger.info("HMTL generation started.");
                HtmlExporter exporter = new HtmlExporter();
                CarersWriter lineWriter = new CarersWriter(stream);
                SimpleHtmlReportConfiguration reportConfiguration = new SimpleHtmlReportConfiguration();
                reportConfiguration.setIgnorePageMargins(false);
                reportConfiguration.setRemoveEmptySpaceBetweenRows(true);
                reportConfiguration.setWrapBreakWord(true);
                reportConfiguration.setSizeUnit(HtmlSizeUnitEnum.POINT);
                SimpleHtmlExporterConfiguration exporterConfiguration = new SimpleHtmlExporterConfiguration();
                exporterConfiguration.setBetweenPagesHtml("<p class=\"htmlPageBreak\" style=\"page-break-after: always\"></p>");
                SimpleExporterInput exporterInput = new SimpleExporterInput(removeBlankPage(print));
                SimpleHtmlExporterOutput writerExporter = new SimpleHtmlExporterOutput(lineWriter);
                exporter.setExporterInput(exporterInput);
                exporter.setExporterOutput(writerExporter);
                exporter.setConfiguration(reportConfiguration);
                exporter.setConfiguration(exporterConfiguration);
                exporter.exportReport();
                logger.info("HMTL generation finished.");
                return new GenerationSuccess();
            }
            else {
                logger.error("Received an empty print object to convert to HTML.");
                return new GenerationFailure();
            }
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
            return new GenerationFailure();
        }
    }

    /**
     * Remove the last empty page from the report
     * @param print
     * @return
     */
    private JasperPrint removeBlankPage(JasperPrint print) {
        List<JRPrintPage> pages = print.getPages();
        JRPrintPage lastPage = pages.get(pages.size() -1);
        if (null != lastPage && lastPage.getElements().size() == 0){
            pages.remove(lastPage);
        }
        return print;
    }
}
