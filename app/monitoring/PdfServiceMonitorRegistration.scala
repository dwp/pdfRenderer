package monitoring

import app.ConfigProperties._
import monitor.{MonitorRegistration, NoHealthCheck}

trait PdfServiceMonitorRegistration extends MonitorRegistration with NoHealthCheck {

  override def getFrequency: Int = getProperty("metrics.frequency", default = 1)

  override def isLogMetrics: Boolean = getProperty("metrics.slf4j", default = false)

  override def isLogHealth: Boolean = getProperty("health.logging", default = false)

}