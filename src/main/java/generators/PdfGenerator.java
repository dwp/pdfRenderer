package generators;

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
    private static final Logger logger = LoggerFactory.getLogger(PdfGenerator.class);

    private String iccPath;

    private SimplePdfExporterConfiguration initConfig() {
        SimplePdfExporterConfiguration config = new SimplePdfExporterConfiguration();
        config.setTagged(true);
        config.setPdfaConformance(PdfaConformanceEnum.PDFA_1A);
        config.setCompressed(true);
        setPath();
        logger.info("iccPath:" + iccPath);
        config.setIccProfilePath(iccPath);
        config.setMetadataAuthor("Carer's allowance digital service");
        config.setPrintScaling(PdfPrintScalingEnum.NONE);
        return config;
    }

    //because of class loader issues with Jasper reports need to take / off path or running from file add .
    private void setPath() {
        if (iccPath.startsWith("/") && this.getClass().getResource(iccPath) != null) {
            iccPath = iccPath.substring(iccPath.indexOf("/") +1);
        } else if (iccPath.startsWith("/")) {
            iccPath = "." + iccPath;
        }
    }

    @Override
    public SuccessOrFailure exportReportToStream(JasperPrint print, OutputStream stream) {
        try {
            if (print != null) {
                logger.info("PDF generation started.");
                JRPdfExporter exporter = new JRPdfExporter(DefaultJasperReportsContext.getInstance());

                exporter.setExporterInput(new SimpleExporterInput(print));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(stream));
                exporter.setConfiguration(initConfig());

                exporter.exportReport();
                logger.info("PDF generation finished.");
                return new GenerationSuccess();
            } else {
                logger.error("Received an empty print object to convert to PDF.");
                return new GenerationFailure();
            }
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
            return new GenerationFailure();
        }
    }

    @Inject
    public PdfGenerator(@Value("${icc.path}") String iccPath, @Value("${jasper.folder}") String jasperLocation, @Value("${jrxml.folder}") String jrxmlLocation) {
        super(jasperLocation, jrxmlLocation);
        this.iccPath = iccPath;
    }
}
