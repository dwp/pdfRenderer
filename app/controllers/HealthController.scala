package controllers

import gov.dwp.carers.CADSHealthCheck
import monitoring.ProdHealthMonitor
import play.api.libs.json.{Json, Writes}
import play.api.mvc.{Action, Controller}

trait HealthController {
  this: Controller =>

  val healthMonitor = ProdHealthMonitor

  implicit val healthWrites = new Writes[(String, CADSHealthCheck.Result)] {
    def writes(healthCheck: (String, CADSHealthCheck.Result)) = Json.obj(
      "application name" -> healthCheck._2.getApplication,
      "version" -> healthCheck._2.getVersion,
      "name" -> healthCheck._1,
      "isHealthy" -> healthCheck._2.isHealthy
    )
  }

  def healthReport = Action {
    request =>
      Ok(Json.prettyPrint(Json.toJson(healthMonitor.runHealthChecks()))).as("application/json").withHeaders("Cache-Control" -> "must-revalidate,no-cache,no-store")
  }

  def ping = Action {
    request => Ok
  }
}

object HealthController extends Controller with HealthController
