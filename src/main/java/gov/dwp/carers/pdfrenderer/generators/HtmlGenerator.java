package gov.dwp.carers.pdfrenderer.generators;

import gov.dwp.carers.pdfrenderer.helpers.CarersWriter;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class HtmlGenerator extends ReportGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(HtmlGenerator.class);

    @Override
    public SuccessOrFailure exportReportToStream(final JasperPrint print, final OutputStream stream) {
        SuccessOrFailure successOrFailure = new GenerationFailure();
        try {
            if (print == null) {
                LOGGER.error("Received an empty print object to convert to HTML.");
            } else {
                LOGGER.info("HMTL generation started.");
                final HtmlExporter exporter = new HtmlExporter();
                final CarersWriter lineWriter = new CarersWriter(stream);
                final SimpleHtmlReportConfiguration reportConfiguration = new SimpleHtmlReportConfiguration();
                reportConfiguration.setIgnorePageMargins(false);
                reportConfiguration.setRemoveEmptySpaceBetweenRows(true);
                reportConfiguration.setWrapBreakWord(true);
                reportConfiguration.setBorderCollapse("separate");
                reportConfiguration.setSizeUnit(HtmlSizeUnitEnum.POINT);
                final SimpleHtmlExporterConfiguration exporterConfiguration = new SimpleHtmlExporterConfiguration();
                exporterConfiguration.setBetweenPagesHtml("<p class=\"htmlPageBreak\" style=\"page-break-after: always\"></p>");
                final SimpleExporterInput exporterInput = new SimpleExporterInput(removeBlankPage(print));
                final SimpleHtmlExporterOutput writerExporter = new SimpleHtmlExporterOutput(lineWriter);
                exporter.setExporterInput(exporterInput);
                exporter.setExporterOutput(writerExporter);
                exporter.setConfiguration(reportConfiguration);
                exporter.setConfiguration(exporterConfiguration);
                exporter.exportReport();
                LOGGER.info("HMTL generation finished.");
                successOrFailure = new GenerationSuccess();
            }
        } catch (Throwable e) {
            LOGGER.error(e.getMessage(), e);
        }
        return successOrFailure;
    }

    /**
     * Remove the last empty page from the report
     *
     * @param print
     * @return
     */
    private JasperPrint removeBlankPage(final JasperPrint print) {
        final List<JRPrintPage> pages = print.getPages();
        final JRPrintPage lastPage = pages.get(pages.size() - 1);
        if (null != lastPage && lastPage.getElements().size() == 0) {
            pages.remove(lastPage);
        }
        return print;
    }

    @Inject
    public HtmlGenerator(
            final @Value("${jasper.local.folder}") String jasperLocalLocation,
            final @Value("${jasper.reports.folder}") String jasperReportsFolderLocation,
            final @Value("${jasper.reportsjar.folder}") String jasperReportsJarLocation) {
        super(jasperLocalLocation, jasperReportsFolderLocation, jasperReportsJarLocation);
    }
}
