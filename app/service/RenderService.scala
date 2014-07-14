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
trait RenderService {

  protected def reportGenerator: ReportGenerator

  protected val outputStream: OutputStream

  protected def content: String

  def outputGeneration(request: Request[AnyContent]) = {


    request.body.asXml.map {
      xml =>
        val generator = reportGenerator
        val node = xml \\ "TransactionId"
        val transactionId = if (node.isEmpty) "" else node.text
        try {
          Logger.debug("treating XML received.")
          val print = generator.generateFrom(xml)

          generator.exportReportToStream(print, outputStream) match {
            case GenerationSuccess() =>
              Logger.info("Generation success for transactionId [${transactionId}] with content size:"+content.length)
              Results.Ok(content)

            case GenerationFailure() =>
              Logger.error(s"Could not render XML for transactionId [${transactionId}]")
              Results.InternalServerError

            case e: Throwable =>
              Logger.error("Unexpected result for transactionId [${transactionId}]",e)
              Results.InternalServerError
          }
        }
        catch {
          case e: InvalidSourceFormatException =>
            Logger.error(s"Could not render for transactionId [${transactionId}]")
            Results.BadRequest // Error already logged by generator
          case t: Throwable => {
            Logger.error(s"Could not render for transactionId [${transactionId}]. ${t.getMessage}",t)
            Results.InternalServerError
          }
        }

    }.getOrElse(Results.UnsupportedMediaType)

  }

}
