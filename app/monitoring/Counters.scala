package monitoring

import com.codahale.metrics.SharedMetricRegistries
import play.api.Play._

object Counters {
  def recordClaimRenderCount() {
    SharedMetricRegistries.getOrCreate(current.configuration.getString("metrics.name").getOrElse("default")).counter(s"rs-render-count").inc()
  }
}
