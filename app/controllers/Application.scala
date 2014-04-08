package controllers

import play.api.mvc._
import service.{HtmlServiceStringImpl, PdfServiceFileImpl, HtmlServiceFileImpl}


object Application extends Controller {

  def generatePDF = Action { request =>
    val service = new PdfServiceFileImpl {}
    service.outputGeneration(request)
  }

  def generateHTML = Action {request =>
    val service = new HtmlServiceStringImpl {}
    service.outputGeneration(request)
  }

}