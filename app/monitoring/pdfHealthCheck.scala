package monitoring

import app.ConfigProperties._
import gov.dwp.carers.CADSHealthCheck
import gov.dwp.carers.CADSHealthCheck.Result

class pdfHealthCheck extends CADSHealthCheck(s"${getProperty("application.name", default="p1")}", getProperty("application.version", default="x1").takeWhile(_ != '-')) {
  override protected def check: CADSHealthCheck.Result = {
    Result.healthy()
  }
}
