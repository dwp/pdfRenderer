package gov.dwp.carers.pdfrenderer.generators;

import gov.dwp.carers.pdfrenderer.datasources.InvalidSourceFormatException;
import gov.dwp.carers.pdfrenderer.datasources.ReportDataSource;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class ReportGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportGenerator.class);

    private String jasperLocation;
    private String jrxmlLocation;
    protected static final String FORWARD_SLASH = "/";

    public JasperPrint generateFrom(final ReportDataSource source, final String version) {
        JasperPrint jasperPrint = null;
        try {
            LOGGER.info("Starting generating jasper print");
            final String reportName = source.jasperReportFilenameMatcher();

            final URL jasperResURL = JRLoader.class.getClassLoader().getResource(fullJasperLocation2(version) + reportName + ".jasper");

            setLocations(jasperResURL);

            final Map<String, Object> parameter = new ConcurrentHashMap<>();
            parameter.put("SUBREPORT_DIR", fullJasperLocation(version));
            parameter.put("TEMPLATE_DIR", fullJrxmlLocation(version));

            if (jasperResURL == null) {
                LOGGER.info("loading and filling jasper report");
                jasperPrint = JasperFillManager.fillReport(fullJasperLocation(version) + reportName + ".jasper", parameter, source.convertToJRDataSource());
            } else {
                LOGGER.info("loading jasper report");
                final JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperResURL);
                LOGGER.info("filling jasper report");
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, source.convertToJRDataSource());
            }
            LOGGER.info("Finished generating jasper print");
        } catch (JRException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (InvalidSourceFormatException e) {
            LOGGER.error(e.getMessage(), e);
            throw e;
        }
        return jasperPrint;
    }

    private void setLocations(final URL jasperResURL) {
        if (jasperLocation.charAt(0) == FORWARD_SLASH.charAt(0) && jasperResURL != null) {
            jasperLocation = jasperLocation.substring(jasperLocation.indexOf(FORWARD_SLASH.charAt(0)) +1);
            jrxmlLocation = jrxmlLocation.substring(jrxmlLocation.indexOf(FORWARD_SLASH.charAt(0)) +1);
        } else if (jasperLocation.charAt(0) == FORWARD_SLASH.charAt(0)) {
            jasperLocation = "." + jasperLocation;
            jrxmlLocation = "." + jrxmlLocation;
        }
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("finished setting jasperLocation:" + jasperLocation);
        }
    }
    public SuccessOrFailure exportReportToStream(final JasperPrint print, final OutputStream stream) {
        return new GenerationSuccess();
    }

    public String fullJasperLocation(final String version) {
        return jasperLocation + ((version == null) ? "" : FORWARD_SLASH + version + FORWARD_SLASH);
    }

    public String fullJrxmlLocation(final String version) {
        return jrxmlLocation + ((version == null) ? "" : FORWARD_SLASH + version + FORWARD_SLASH);
    }

    public String fullJasperLocation2(final String version) {
        final String test = jasperLocation.charAt(0) == FORWARD_SLASH.charAt(0) ? jasperLocation.substring(1) : jasperLocation;
        return test + ((version == null) ? "" : FORWARD_SLASH + version + FORWARD_SLASH);
    }

    @Inject
    public ReportGenerator(final @Value("${jasper.folder}") String jasperLocation, final @Value("${jrxml.folder}") String jrxmlLocation) {
        this.jasperLocation = jasperLocation;
        this.jrxmlLocation = jrxmlLocation;
    }
}
