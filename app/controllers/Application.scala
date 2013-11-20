package controllers

import play.api.mvc._
import service.PdfServiceFileImpl


object Application extends Controller with PdfServiceFileImpl {

  def generatePDF = Action { request =>
    pdfGeneration(request)
  }

}