package monitoring;

import com.codahale.metrics.SharedMetricRegistries;
import com.codahale.metrics.Slf4jReporter;
import gov.dwp.carers.monitor.MonitorRegistration;
import gov.dwp.carers.monitor.ProdHealthMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.SortedMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by peterwhitehead on 05/05/2016.
 */
@Component
public class RenderingServiceMonitorRegistration extends MonitorRegistration{
    private final Logger logger = LoggerFactory.getLogger(RenderingServiceMonitorRegistration.class);

    public void registerHealthChecks() {
        logger.info("Registering Health Checks.");
        if (isLogHealth()) {
            logHealthReporter = new ProdHealthMonitor(applicationName);
            logHealthReporter.register("p1-check", new PdfHealthCheck(applicationName, applicationVersion));
            logHealthReporter.start(getHealthLoggingFrequency(), TimeUnit.MINUTES);
            logger.info("Health Checks registered. With frequency:" + getHealthLoggingFrequency());
        } else logger.info("Health Checks turned off.");
    }

    public void registerReporters() {
        logger.info("Registering Metrics.");
        if (isLogMetrics()) {
            reporter = Slf4jReporter.forRegistry(SharedMetricRegistries.getOrCreate(metricsName))
                    .outputTo(LoggerFactory.getLogger("application"))
                    .convertRatesTo(TimeUnit.SECONDS)
                    .convertDurationsTo(TimeUnit.MILLISECONDS)
                    .build();
            reporter.start(getFrequency(), TimeUnit.MINUTES);
            logger.info("Metrics registered. With frequency:" + getFrequency());
        } else logger.info("Metrics turned off.");
    }

}
