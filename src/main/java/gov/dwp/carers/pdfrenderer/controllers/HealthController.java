package gov.dwp.carers.pdfrenderer.controllers;

import gov.dwp.carers.monitor.MonitorRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by peterwhitehead on 27/05/2016.
 */
@RestController
@Component
public class HealthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HealthController.class);

    private final MonitorRegistration monitorRegistration;
    private static final String ERROR = "Failed health check.";

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public
    @ResponseBody
    String ping() {
        LOGGER.info("STARTED /ping HealthController.ping");
        LOGGER.info("ENDED /ping HealthController.ping");
        return "";
    }

    @RequestMapping(value = "/report/health", method = RequestMethod.GET)
    public
    @ResponseBody
    String health() {
        LOGGER.info("STARTED /report/health HealthController.health");
        String rtnMsg = ERROR;
        try {
            final String health = monitorRegistration.retrievePrintFriendlyHealthCheck();
            if (health != null) {
                rtnMsg = health;
            }
        } catch (IOException e) {
            LOGGER.error("Failed to report health.", e);
        } finally {
            LOGGER.info("ENDED /report/health HealthController.health");
        }
        return rtnMsg;
    }

    @Inject
    public HealthController(final MonitorRegistration monitorRegistration) {
        this.monitorRegistration = monitorRegistration;
    }
}

