package generators;

import dataSources.InvalidSourceFormatException;
import dataSources.ReportDataSource;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class ReportGenerator {
    private static final Logger logger = LoggerFactory.getLogger(ReportGenerator.class);

    @Value("${jasper.folder}")
    private String jasperLocation;

    @Value("${jrxml.folder}")
    private String jrxmlLocation;

    public JasperPrint generateFrom(ReportDataSource source, String version) {
        try {
            String reportName = source.jasperReportFilenameMatcher();

            URL jasperResURL = this.getClass().getResource(fullJasperLocation(version) + reportName + ".jasper");
            setLocations(jasperResURL);

            Map<String, Object> parameter = new HashMap<>();
            parameter.put("SUBREPORT_DIR", fullJasperLocation(version));
            parameter.put("TEMPLATE_DIR", fullJrxmlLocation(version));

            JasperPrint jasperPrint;
            if (jasperResURL != null) {
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperResURL);
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, source.convertToJRDataSource());
            } else {
                jasperPrint = JasperFillManager.fillReport(fullJasperLocation(version) + reportName + ".jasper", parameter, source.convertToJRDataSource());
            }
            return jasperPrint;
        } catch (JRException e) {
            logger.error(e.getMessage(), e);
            return null;
        } catch (InvalidSourceFormatException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    private void setLocations(URL jasperResURL) {
        if (jasperLocation.startsWith("/") && jasperResURL != null) {
            jasperLocation = jasperLocation.substring(jasperLocation.indexOf("/") +1);
            jrxmlLocation = jrxmlLocation.substring(jrxmlLocation.indexOf("/") +1);
        } else if (jasperLocation.startsWith("/")) {
            jasperLocation = "." + jasperLocation;
            jrxmlLocation = "." + jrxmlLocation;
        }
        logger.info("jasperLocation:" + jasperLocation);
    }
    public SuccessOrFailure exportReportToStream(JasperPrint print, OutputStream stream) {
        return new GenerationSuccess();
    }

    public String fullJasperLocation(String version) {
        return jasperLocation + ((version == null) ? "" : "/" + version + "/");
    }

    public String fullJrxmlLocation(String version) {
        return jrxmlLocation + ((version == null) ? "" : "/" + version + "/");
    }
}
