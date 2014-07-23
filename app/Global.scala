import generators.ReportGenerator
import play.api.{Logger, Application, GlobalSettings}
import play.api.mvc._
import monitoring.PdfServiceMonitorRegistration
import monitor.MonitorFilter
import monitor._

object Global extends WithFilters(MonitorFilter) with PdfServiceMonitorRegistration with GlobalSettings with ReportGenerator {

  override def onStart(app: Application) {
    super.onStart(app)
    Logger.info("PDFService Started") // used for operations, do not remove

    registerReporters()

    // compile jasper reports if they are not already compiled
    compileAllReports()
  }

  override def onStop(app: Application) {
    super.onStop(app)
    Logger.info("PDFService Stopped") // used for operations, do not remove
  }
}