package monitoring

import com.kenshoo.play.metrics.MetricsRegistry

object Counters {
  def recordClaimRenderCount() {
    MetricsRegistry.defaultRegistry.counter(s"rs-render-count").inc()
  }
}
