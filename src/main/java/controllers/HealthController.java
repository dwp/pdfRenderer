package controllers;

import gov.dwp.carers.monitor.MonitorRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;

/**
 * Created by peterwhitehead on 27/05/2016.
 */
@RestController
@Component
public class HealthController {
    private final Logger logger = LoggerFactory.getLogger(HealthController.class);

    private String appName;
    private MonitorRegistration monitorRegistration;
    private String error = "Failed health check.";

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public @ResponseBody String ping() {
        return "";
    }

    @RequestMapping(value = "/report/health", method = RequestMethod.GET)
    public @ResponseBody String health() {
        try {
            String health = monitorRegistration.retrievePrintFriendlyHealthCheck();
            return health ==  null ? error : health;
        } catch (Exception e) {
            logger.error("Failed to report health.", e);
            return "Failed health check.";
        }
    }

    @Inject
    public HealthController(MonitorRegistration monitorRegistration, @Value("${application.name}") String appName) {
        this.monitorRegistration = monitorRegistration;
        this.appName = appName;
    }
}

