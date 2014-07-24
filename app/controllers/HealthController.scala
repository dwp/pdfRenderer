package controllers

import play.api.mvc.{Action, Controller}

trait HealthController {
  this: Controller =>

  def ping = Action {
    request => Ok
  }
}

object HealthController extends Controller with HealthController
