package gov.dwp.carers.pdfrenderer.controllers;

import gov.dwp.carers.monitor.MonitorRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;

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
    public @ResponseBody String ping() {
        return "";
    }

    @RequestMapping(value = "/report/health", method = RequestMethod.GET)
    public @ResponseBody String health() {
        String rtnMsg = ERROR;
        try {
            final String health = monitorRegistration.retrievePrintFriendlyHealthCheck();
            if (health != null) {
                rtnMsg = health;
            }
        } catch (Exception e) {
            LOGGER.error("Failed to report health.", e);
        }
        return rtnMsg;
    }

    @Inject
    public HealthController(final MonitorRegistration monitorRegistration) {
        this.monitorRegistration = monitorRegistration;
    }
}

