package service

import play.api.mvc.{Request, AnyContent, Results}
import generators.{GenerationFailure, GenerationSuccess, ReportGenerator}
import pdfService.Implicits._
import play.api.Logger
import java.io.OutputStream
import data_sources.InvalidSourceFormatException

/**
 * Entry point of the service. It consumes the HTTP request received, checks it is an XML request
 * and then ask a [[generators.ReportGenerator]] to generate a report from the XML.
 * @author Jorge Migueis
 */
trait PdfService {

  protected def reportGenerator: ReportGenerator

  protected def outputStream: OutputStream

  def pdfGeneration(request: Request[AnyContent]) = {


    request.body.asXml.map {
      xml =>
        val generator = reportGenerator
        try {
          Logger.debug("treating XML received.")
          val print = generator.generateFrom(xml)

          generator.exportReportToStream(print, outputStream) match {
            case GenerationSuccess() =>
              Results.Ok

            case GenerationFailure() =>
              Results.InternalServerError

            case e: Throwable =>
              Logger.error("Unexpected result",e)
              Results.InternalServerError

          }
        }
        catch {
          case e: InvalidSourceFormatException => Results.BadRequest
          case _: Throwable => Results.InternalServerError
        }

    }.getOrElse(Results.UnsupportedMediaType)

  }

}
