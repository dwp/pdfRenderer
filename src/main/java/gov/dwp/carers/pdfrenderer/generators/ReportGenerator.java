package gov.dwp.carers.pdfrenderer.generators;

import gov.dwp.carers.pdfrenderer.datasources.InvalidReportException;
import gov.dwp.carers.pdfrenderer.datasources.InvalidSourceFormatException;
import gov.dwp.carers.pdfrenderer.datasources.ReportDataSource;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ReportGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportGenerator.class);

    private List<String> jasperLocations;
    protected static final String FORWARD_SLASH = "/";
    protected static final String DOTCHAR = ".";
    protected static final String GETFOLDERREGEX = "/[^/]*$";

    public JasperPrint generateFrom(ReportDataSource source) throws Exception {
        JasperPrint jasperPrint = null;
        try {
            LOGGER.info("ReportGenerator starting generating jasper print for report:" + source.getReportName() + " version:" + source.getReportVersion());
            URL jasperFileLocation = getJasperFilePath(source.getReportName(), source.getReportVersion());

            // The reports renderer looks for jrtx template files in the TEMPLATE_DIR so needs to be set and files present
            final Map<String, Object> parameters = new ConcurrentHashMap<>();
            String jarfileprefix = "";
            if (jasperFileLocation.getProtocol().equals("jar") && !jasperFileLocation.getPath().startsWith("jar")) {
                jarfileprefix = "jar:";
            }
            String jasperFolder = jarfileprefix + jasperFileLocation.getPath().replaceAll(GETFOLDERREGEX, "") + FORWARD_SLASH;
            LOGGER.info("Setting TEMPLATE_DIR to:" + jasperFolder);
            parameters.put("SUBREPORT_DIR", jasperFolder);
            parameters.put("TEMPLATE_DIR", jasperFolder);

            final JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperFileLocation);
            LOGGER.info("ReportGenerator filling jasper report");
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, source.convertToJRDataSource());
            LOGGER.info("ReportGenerator finished generating jasper print");
        } catch (JRException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (InvalidSourceFormatException e) {
            LOGGER.error(e.getMessage(), e);
            throw e;
        }
        return jasperPrint;
    }

    public SuccessOrFailure exportReportToStream(final JasperPrint print, final OutputStream stream) {
        return new GenerationSuccess();
    }

    // Look through all the jasper file paths for the report at the correct version and take the first one found.
    public URL getJasperFilePath(final String reportName, final String reportVersion) {
        String filepath = null;
        URL fileFoundUrl = null;
        if (reportVersion != null && reportVersion.length() > 0) {
            filepath = reportVersion + FORWARD_SLASH + reportName + ".jasper";
        } else {
            filepath = reportName + ".jasper";
        }
        for (String location : jasperLocations) {
            File file = new File(location + FORWARD_SLASH + filepath);
            URL url = JRLoader.class.getClassLoader().getResource(location + FORWARD_SLASH + filepath);
            if (file.exists()) {
                try {
                    fileFoundUrl = file.toURI().toURL();
                    LOGGER.info("ReportGenerator found " + fileFoundUrl.getProtocol() + "jasper report file at:" + file.getName());
                    break;
                } catch (Exception e) {
                    // just ignore and look for jasper on the other paths
                }
            } else if (url != null) {
                LOGGER.info("ReportGenerator found " + url.getProtocol() + " jasper report on classpath at:" + url.getFile());
                fileFoundUrl = url;
                break;
            }
        }
        if (fileFoundUrl == null) {
            throw new InvalidReportException("No jasper report file found for:" + reportVersion + FORWARD_SLASH + reportName);
        }
        return (fileFoundUrl);
    }

    @Inject
    public ReportGenerator(final @Value("${jasper.local.folder}") String jasperLocalLocation,
                           final @Value("${jasper.reports.folder}") String jasperReportsFolderLocation,
                           final @Value("${jasper.reportsjar.folder}") String jasperReportsJarLocation) {
        jasperLocations = new ArrayList<String>();
        File local = new File(jasperLocalLocation);
        if (local.exists() && local.isDirectory()) {
            if (jasperLocalLocation.charAt(0) == FORWARD_SLASH.charAt(0)) {
                LOGGER.debug("ReportGenerator adding 2 local jasper location to jasper locations :" + jasperLocalLocation);
                jasperLocations.add(DOTCHAR + jasperLocalLocation);
                jasperLocations.add(jasperLocalLocation.substring(1));
            } else {
                LOGGER.debug("ReportGenerator adding 1 local jasper location to jasper locations :" + jasperLocalLocation);
                jasperLocations.add(jasperLocalLocation);
            }
        }
        File reports = new File(jasperReportsFolderLocation);
        if (reports.exists() && reports.isDirectory()) {
            if (jasperReportsFolderLocation.charAt(0) == FORWARD_SLASH.charAt(0)) {
                LOGGER.debug("ReportGenerator adding 2 pdfReports jasper location to jasper locations :" + jasperReportsFolderLocation);
                jasperLocations.add(DOTCHAR + jasperReportsFolderLocation);
                jasperLocations.add(jasperReportsFolderLocation.substring(1));
            } else {
                LOGGER.debug("ReportGenerator adding 1 pdfReports jasper location to jasper locations :" + jasperReportsFolderLocation);
                jasperLocations.add(jasperReportsFolderLocation);
            }
        }

        if (jasperReportsJarLocation.charAt(0) == FORWARD_SLASH.charAt(0)) {
            LOGGER.debug("ReportGenerator adding 2 reportsJar jasper location to jasper locations :" + jasperReportsJarLocation);
            jasperLocations.add(DOTCHAR + jasperReportsJarLocation);
            jasperLocations.add(jasperReportsJarLocation.substring(1));
        } else {
            LOGGER.debug("ReportGenerator adding 1 reportsJar jasper location to jasper locations :" + jasperReportsJarLocation);
            jasperLocations.add(jasperReportsJarLocation);
        }
        LOGGER.info("ReportGenerator added " + jasperLocations.size() + " report locations");
    }
}
