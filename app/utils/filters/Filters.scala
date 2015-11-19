package utils.filters

import javax.inject.Inject

import com.kenshoo.play.metrics.MetricsFilter
import play.api.http.HttpFilters
import play.filters.gzip.GzipFilter

class Filters @Inject() (metricsFilter: MetricsFilter, gzipFilter: GzipFilter) extends HttpFilters {
  val filters = Seq(metricsFilter, gzipFilter)
}
