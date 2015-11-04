package utils.filters

import javax.inject.Inject

import monitor.MonitorFilter
import play.api.http.HttpFilters
import play.filters.gzip.GzipFilter

class Filters @Inject() (monitorFilter: MonitorFilter, gzipFilter: GzipFilter) extends HttpFilters {
  val filters = Seq(monitorFilter, gzipFilter)
}
