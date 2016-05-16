package monitoring;

import com.codahale.metrics.SharedMetricRegistries;
import com.codahale.metrics.Slf4jReporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * Created by peterwhitehead on 05/05/2016.
 */
@Component
public class RenderingServiceMonitorRegistration {
    private final Logger logger = LoggerFactory.getLogger(RenderingServiceMonitorRegistration.class);

    @Value("${metrics.frequency}")
    private Integer metricsFrequency;

    @Value("${metrics.slf4j}")
    private Boolean metricsSlf4j;

    @Value("${health.logging}")
    private Boolean healthLogging;

    @Value("${metrics.name}")
    private String metricsName;

    @Value("${application.name}")
    private String applicationName;

    @Value("${application.version}")
    private String applicationVersion;

    @Value("${health.logging.frequency}")
    private Integer healthLoggingFrequency;

    private Slf4jReporter reporter;

    private ProdHealthMonitor logHealthReporter;

    public RenderingServiceMonitorRegistration() {}

    public int getFrequency() { return metricsFrequency; }

    public int getHealthLoggingFrequency() { return healthLoggingFrequency; }

    public boolean isLogMetrics() { return metricsSlf4j; }

    public boolean isLogHealth() { return healthLogging; }

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

    public void unRegisterReporters() {
        if (isLogMetrics()) {
            logger.info("Metrics stopped");
            reporter.stop();
        }
    }

    public void unRegisterHealthChecks() {
        if (isLogHealth()) {
            logger.info("Health Logging stopped");
            logHealthReporter.stop();
        }
    }
}
