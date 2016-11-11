package gov.dwp.carers.pdfrenderer.controllers;

import gov.dwp.carers.monitor.MonitorRegistration;
import gov.dwp.carers.pdfrenderer.monitoring.PdfHealthCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.util.Arrays;

/**
 * Created by peterwhitehead on 04/05/2016.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"gov.dwp.carers"})
@PropertySource("classpath:/config/application-info.properties")
public class PdfServiceApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(PdfServiceApplication.class);

    @Value("${server.port}")
    private String serverPort;

    @Value("${env.name}")
    private String envName;

    @Value("${application.name}")
    private String appName;

    @Inject
    private MonitorRegistration monitorRegistration;

    @PostConstruct
    public void onStart() {

        System.out.println("============================ COLING onStart .... =====================");
        String cp = System.getProperty("java.class.path");
        String[] cps = cp.split(":");
        for (int n = 0; n < cps.length; n++) {
            System.out.println("classpath:" + n + "->" + cps[n]);
        }
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Starting application with - serverPort:" + serverPort + " envName:" + envName + " appName:" + appName);
            LOGGER.info("RS (RenderingService) is now starting.");
        }

        monitorRegistration.registerReporters();

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("RS (RenderingService) started.");
        }
    }

    @PreDestroy
    public void onStop() {
        monitorRegistration.unRegisterReporters();
        monitorRegistration.unRegisterHealthChecks();
    }

    @Inject
    private void registerHealthChecks(final PdfHealthCheck pdfHealthCheck) {
        LOGGER.info(appName + " - registering health checks.");
        monitorRegistration.registerHealthChecks(Arrays.asList(pdfHealthCheck));
    }

    public static void main(final String... args) throws Exception {
        final SpringApplication springApplication = new SpringApplication(PdfServiceApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }
}
