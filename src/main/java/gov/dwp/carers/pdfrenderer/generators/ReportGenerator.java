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
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ReportGenerator {
    @Value("${jasper.local.folder}")
    private String localFolder;

    @Value("${jasper.jarfile.folder}")
    private String jarfileFolder;

    @Value("${jasper.jarfile.subfolder}")
    private String jarfileSubfolder;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReportGenerator.class);

    private List<String> jasperLocations;
    protected static final String FORWARD_SLASH = "/";
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

    private URL getUrlFromFolderOrJarfile(final String pathname, final String file) {
        LOGGER.info("Checking for jasper file at path:" + pathname + " file:" + file);
        URL fileFoundUrl = null;
        File f = new File(pathname + FORWARD_SLASH + file);
        try {
            if (f.exists()) {
                fileFoundUrl = f.toURI().toURL();
                LOGGER.info("ReportGenerator found :" + fileFoundUrl.getProtocol() + ":jasper report file at:" + fileFoundUrl.getFile());
            } else {
                // Look in external root folder for jarfile containing the jasper report ... take last one found likely newest jar
                File folder = new File(jarfileFolder);
                if (folder.isDirectory()) {
                    File[] files = folder.listFiles();
                    for (int n = 0; n < files.length; n++) {
                        if (files[n].isFile() && files[n].getName().endsWith(".jar")) {
                            fileFoundUrl = new URL("jar:file:" + files[n].getAbsoluteFile() + "!" + FORWARD_SLASH + jarfileSubfolder + FORWARD_SLASH + file);
                            LOGGER.info("ReportGenerator found :" + fileFoundUrl.getProtocol() + ":jasper report file at:" + fileFoundUrl.getFile());
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("Error constructing jasper url:" + e.toString());
        }
        return (fileFoundUrl);
    }

    // Look through all the jasper file paths for the report at the correct version and take the first one found.
    // We may have test reports under this project, dev reports under an adjacent project folder i.e. pdfReports.
    // Or we try and pickup reports from any jarfile found in jarfile folder.
    public URL getJasperFilePath(final String reportName, final String reportVersion) {
        String filepath = null;
        if (reportVersion != null && reportVersion.length() > 0) {
            filepath = reportVersion + FORWARD_SLASH + reportName + ".jasper";
        } else {
            filepath = reportName + ".jasper";
        }
        URL fileFoundUrl = getUrlFromFolderOrJarfile(localFolder, filepath);
        if (fileFoundUrl == null) {
            fileFoundUrl = getUrlFromFolderOrJarfile(jarfileFolder, filepath);
        }
        if (fileFoundUrl == null) {
            throw new InvalidReportException("No jasper report file found for:" + reportVersion + FORWARD_SLASH + reportName);
        }
        return (fileFoundUrl);
    }
}
