package gov.dwp.carers.pdfrenderer.generators;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.type.PdfPrintScalingEnum;
import net.sf.jasperreports.export.type.PdfaConformanceEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.OutputStream;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class PdfGenerator extends ReportGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(PdfGenerator.class);

    private String iccPath;

    private SimplePdfExporterConfiguration initConfig() {
        final SimplePdfExporterConfiguration config = new SimplePdfExporterConfiguration();
        config.setTagged(true);
        config.setPdfaConformance(PdfaConformanceEnum.PDFA_1A);
        config.setCompressed(true);
        setPath();
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("iccPath:" + iccPath);
        }
        config.setIccProfilePath(iccPath);
        config.setMetadataAuthor("Carer's allowance digital gov.dwp.carers.pdfrenderer.service");
        config.setPrintScaling(PdfPrintScalingEnum.NONE);
        return config;
    }

    private void setPath() {
        if (iccPath.charAt(0) == FORWARD_SLASH.charAt(0) && this.getClass().getResource(iccPath) != null) {
            iccPath = iccPath.substring(iccPath.indexOf(FORWARD_SLASH.charAt(0)) + 1);
        } else if (iccPath.charAt(0) == FORWARD_SLASH.charAt(0)) {
            iccPath = "." + iccPath;
        }
    }

    @Override
    public SuccessOrFailure exportReportToStream(final JasperPrint print, final OutputStream stream) {
        SuccessOrFailure successOrFailure = new GenerationFailure();
        try {
            if (print == null) {
                LOGGER.error("Received an empty print object to convert to PDF.");
            } else {
                LOGGER.info("PDF generation started.");
                final JRPdfExporter exporter = new JRPdfExporter(DefaultJasperReportsContext.getInstance());

                exporter.setExporterInput(new SimpleExporterInput(print));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(stream));
                exporter.setConfiguration(initConfig());

                exporter.exportReport();
                LOGGER.info("PDF generation finished.");
                successOrFailure = new GenerationSuccess();
            }
        } catch (Throwable e) {
            LOGGER.error(e.getMessage(), e);
        }
        return successOrFailure;
    }

    @Inject
    public PdfGenerator(final @Value("${icc.path}") String iccPath,
                        final @Value("${jasper.local.folder}") String jasperLocalLocation,
                        final @Value("${jasper.reports.folder}") String jasperReportsFolderLocation,
                        final @Value("${jasper.reportsjar.folder}") String jasperReportsJarLocation) {
        super(jasperLocalLocation, jasperReportsFolderLocation, jasperReportsJarLocation);
        this.iccPath = iccPath;
    }
}
