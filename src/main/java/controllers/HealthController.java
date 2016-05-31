package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.dwp.carers.CADSHealthCheck;
import monitoring.RenderingServiceMonitorRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by peterwhitehead on 27/05/2016.
 */
@RestController
public class HealthController {
    private final Logger logger = LoggerFactory.getLogger(HealthController.class);

    @Value("${application.name}")
    private String appName;

    @Inject
    private RenderingServiceMonitorRegistration renderingServiceMonitorRegistration;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public @ResponseBody String ping() {
        logger.info("ping called");
        return "";
    }

    @RequestMapping(value = "/report/health", method = RequestMethod.GET)
    public @ResponseBody String health() {
        try {
            SortedMap<String, CADSHealthCheck.Result> health = renderingServiceMonitorRegistration.runHealthChecks();
            logger.info("health called");
            ObjectMapper mapper = new ObjectMapper();
            Object json = mapper.readValue(createHealthMap(health), Object.class);
            String value = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(json);
            return "<pre>" + value + "</pre>";
        } catch (Exception e) {
            logger.error("Failed to report health.", e);
            return "Failed health check.";
        }
    }

    private String createHealthMap(SortedMap<String, CADSHealthCheck.Result> health) {
        StringBuilder sb = new StringBuilder().append("[");
        for (Map.Entry<String, CADSHealthCheck.Result> hel : health.entrySet()) {
            if (sb.length() > 1)sb.append(",");
            sb.append("{\"application name\" : \"")
            .append(hel.getValue().getApplication())
            .append("\", \"version\" : \"")
            .append(hel.getValue().getVersion())
            .append("\", \"name\" : \"")
            .append(hel.getKey())
            .append("\", \"Result\" : {\"isHealthy\" : \"")
            .append(hel.getValue().isHealthy())
            .append("\", \"message\" : \"")
            .append((hel.getValue().getMessage()!=null) ? hel.getValue().getMessage() : "")
            .append("\", \"error\" : \"")
            .append((hel.getValue().getError()!=null) ? hel.getValue().getError().getMessage() : "")
            .append("\"}}");
        }
        sb.append("]");
        return sb.toString();
    }
}
