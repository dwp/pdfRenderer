package monitoring;

import com.codahale.metrics.SharedMetricRegistries;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by peterwhitehead on 04/05/2016.
 */
@Component
public class Counters {
    @Value("${metrics.name}")
    private String metricsName;

    public void recordClaimRenderCount() {
        SharedMetricRegistries.getOrCreate(metricsName).counter("rs-render-count").inc();
    }
}
