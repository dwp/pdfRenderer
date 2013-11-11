package controllers

import play.api.mvc._
import service.PdfServiceImpl


object Application extends Controller with PdfServiceImpl {

  def generatePDF = Action { request =>
    pdfGeneration(request)
  }

}