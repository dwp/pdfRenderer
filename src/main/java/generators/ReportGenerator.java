package generators;

import dataSources.InvalidSourceFormatException;
import dataSources.ReportDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
public class ReportGenerator {
    private static final Logger logger = LoggerFactory.getLogger(ReportGenerator.class);

    @Inject
    private JasperReportCompiler jasperReportCompiler;

    public JasperPrint generateFrom(ReportDataSource source, String version) {
        try {
            String realJasperLocation = jasperReportCompiler.fullJasperLocation(version);
            String reportName = source.jasperReportFilenameMatcher();
            String jasperFilename = realJasperLocation + reportName + ".jasper";

            // If we do not have the compiled report templates, then we need to compile them
            // before we can generate a report. They are normally compiled at start-up. It is just in case.
            jasperReportCompiler.compileReport(reportName, version);
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("SUBREPORT_DIR", realJasperLocation);
            parameter.put("TEMPLATE_DIR", jasperReportCompiler.fullJrxmlLocation(version));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFilename, parameter, source.convertToJRDataSource());
            return jasperPrint;
        } catch (JRException e) {
            logger.error(e.getMessage(), e);
            return null;
        } catch (InvalidSourceFormatException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    public SuccessOrFailure exportReportToStream(JasperPrint print, OutputStream stream) {
        return new GenerationSuccess();
    }
}
