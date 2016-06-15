package controllers;

import gov.dwp.carers.monitor.MonitorRegistration;
import monitoring.PdfHealthCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.net.InetAddress;

/**
 * Created by peterwhitehead on 04/05/2016.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"controllers", "dataSources", "generators", "service", "monitoring", "gov.dwp.carers"})
@PropertySource("classpath:/config/application-info.properties")
public class PdfServiceApplication {
    private static final Logger logger = LoggerFactory.getLogger(PdfServiceApplication.class);

    @Value("${http.port}")
    private String httpPort;

    @Value("${env.name}")
    private String envName;

    @Value("${application.name}")
    private String appName;

    @Inject
    private MonitorRegistration monitorRegistration;

    @Inject
    private PdfHealthCheck pdfHealthCheck;

    @PostConstruct
    public void onStart() {
        try {
            logger.info("Starting application with - httpPort:" + httpPort + " envName:" + envName + " appName:" + appName);
            MDC.put("httpPort", httpPort);
            MDC.put("hostName", InetAddress.getLocalHost().getHostName());
            MDC.put("envName", envName);
            MDC.put("appName", appName);
        } catch (Exception e) {
            logger.error("Failed to initialise MDC " + e.getMessage(), e);
        }
        logger.info("RS (RenderingService) is now starting.");

        monitorRegistration.registerReporters();
        monitorRegistration.registerHealthChecks(pdfHealthCheck);

        logger.info("RS (RenderingService) started.");
    }

    @PreDestroy
    public void onStop() {
        monitorRegistration.unRegisterReporters();
        monitorRegistration.unRegisterHealthChecks();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PdfServiceApplication.class, args);
    }
}
