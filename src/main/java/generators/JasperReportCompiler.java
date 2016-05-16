package generators;

import dataSources.InvalidSourceFormatException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRSubreport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRElementsVisitor;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class JasperReportCompiler {
    private static final Logger logger = LoggerFactory.getLogger(JasperReportCompiler.class);

    @Value("${jasper.folder}")
    private String jasperLocation;

    @Value("${jrxml.folder}")
    private String jrxmlLocation;

    /**
     * Compile all JRXML templates under jrxml.folder sub-folders.
     * Called by application at start-up.
     */
    public void compileAllReports() {
        try {
            logger.info("compileAllReports - jrxmlLocation = " + jrxmlLocation + " - jasperLocation = " + jasperLocation);
            File allFiles = new File(jrxmlLocation);
            if (allFiles != null && allFiles.listFiles() != null) {
                Arrays.asList(allFiles.listFiles()).stream().filter(f -> f.isDirectory()).forEach(folder -> compileReportsInFolder(folder.getName()));
            }
        } catch (InvalidSourceFormatException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Compile a specific JRXML template and its sub-reports.
     *
     * @param reportName JRXML report to compile.
     * @param version    The version we want to compile, which defines its location under jrxml.foler.
     */
    public void compileReport(String reportName, String version) {
        String realJasperLocation = fullJasperLocation(version);
        String jasperFilename = realJasperLocation + reportName + ".jasper";
        if (!new File(jasperFilename).exists()) {
            logger.info("compileReport - No jasper file. Compiling from JRXML for " + jasperFilename);
            compileReportsRecursively(reportName, version);
        }
    }

    public String fullJasperLocation(String version) {
        return jasperLocation + ((version == null) ? "" : "/" + version + "/");
    }

    public String fullJrxmlLocation(String version) {
        return jrxmlLocation + ((version == null) ? "" : "/" + version + "/");
    }

    private void compileReportsInFolder(String parentFolder) {
        logger.info("compileReportsInFolder - Compiling JRXML reports in " + parentFolder);
        File allFiles = new File(jrxmlLocation + "/" + parentFolder);
        if (allFiles != null && allFiles.listFiles() != null) {
            List<File> files = Arrays.asList(allFiles.listFiles()).stream().filter(f -> f.getName().endsWith(".jrxml")).collect(Collectors.toList());
            compileReports(files, parentFolder);
        }
    }

    private void compileReports(List<File> files, String path) {
        logger.info("compileReports - Compiling JRXML reports in " + path);
        if (files != null) {
            for (File file : files) {
                // process the file
                String[] reportNameArr = file.getName().split("\\.");
                if (reportNameArr.length > 0) {
                    compileReport(reportNameArr[0], path);
                } else logger.error("compileReports - Error reading from jrxml directory " + path + ".");
            }
        }
    }

    private JasperReport compileReportsRecursively(String fileName, String version) {
        String realJasperLocation = fullJasperLocation(version);
        String realJrxmlLocation = fullJrxmlLocation(version);
        String jasperFilename = realJasperLocation + fileName + ".jasper";
        String jrxmlFilename = realJrxmlLocation + fileName + ".jrxml";
        logger.debug("compileReportsRecursively - jasperFileName is " + jasperFilename);

        logger.info("compileReportsRecursively - Loading jrxml for compilation: " + jrxmlFilename);
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(jrxmlFilename);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            logger.debug("compileReportsRecursively - Report " + jasperFilename + " compiled");

            // If jasper folder does not exist then it creates it. So it can save compiles templates
            if (!new File(realJasperLocation).exists()) {
                new File(realJasperLocation).mkdir();
            }
            JRSaver.saveObject(jasperReport, jasperFilename);
            logger.debug("compileReportsRecursively - Report " + jasperFilename + " saved");

            //Compile sub reports
            JRElementsVisitor.visitReport(jasperReport, new ReportCompilerVisitor() {
                @Override
                public void visitSubreport(JRSubreport subreport) {
                    String expression = subreport.getExpression().getText();
                    // expression looks like: $P{SUBREPORT_DIR} + "reportNewClaim_Summary.jasper"
                    String subReportName = expression.substring(expression.indexOf('"') + 1, expression.length() - 8);
                    // Need to prepend jasperLocation to check existence of compiled template (to support version folders)
                    if (!new File(realJasperLocation + subReportName).exists()) {
                        logger.info("compileReportsRecursively - No jasper file. Compiling subreport from JRXML for " + subReportName + ".");
                        compileReportsRecursively(subReportName, version);
                    }
                }
            });
            logger.debug("compileReportsRecursively - Successfully compiled and saved jasper report. " + jasperFilename);
            return jasperReport;
        } catch (JRException e) {
            logger.error("compileReportsRecursively - Failed to compile and save jasper report. " + jasperFilename, e);
            return null;
        }
    }
}
