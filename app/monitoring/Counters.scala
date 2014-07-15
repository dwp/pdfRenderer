package monitoring

import com.kenshoo.play.metrics.MetricsRegistry

object Counters {
  def recordClaimRenderCount() {
    MetricsRegistry.default.counter(s"cr-claim-render-count").inc()
  }
}
