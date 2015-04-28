package service

import helpers.VersionExtractor
import play.api.mvc.{Request, AnyContent, Results}
import generators.{GenerationFailure, GenerationSuccess, ReportGenerator}
import pdfService.Implicits._
import play.api.Logger
import java.io.OutputStream
import data_sources.InvalidSourceFormatException
import monitoring.Counters
import scala.language.higherKinds

/**
 * Entry point of the service. It consumes the HTTP request received, checks it is an XML request
 * and then ask a [[generators.ReportGenerator]] to generate a report from the XML.
 * @author Jorge Migueis
 */
trait RenderService{

  protected def reportGenerator: ReportGenerator

  protected val outputStream: OutputStream

  protected def content: Either[String,Array[Byte]]

  def outputGeneration(request: Request[AnyContent]) = {

    request.body.asXml.map {
      xml =>
        val generator = reportGenerator
        val node = xml \\ "TransactionId"
        val transactionId = if (node.isEmpty) "" else node.text
        try {
          Logger.debug("treating XML received.")
          val print = generator.generateFrom(xml, VersionExtractor.extractVersionFrom(xml))

          generator.exportReportToStream(print, outputStream) match {
            case GenerationSuccess() =>
              Logger.info(s"Generation success for transactionId [${transactionId}] ")//TODO: Fix this with content size: ${content.length}")
              Counters.recordClaimRenderCount()
              content match {
                case Right(v) => Results.Ok(v.asInstanceOf[Array[Byte]])
                case Left(v) => Results.Ok(v.asInstanceOf[String])
              }

            case GenerationFailure() =>
              Logger.error(s"Could not render XML for transactionId [${transactionId}]")
              Results.InternalServerError

            case e: Throwable =>
              Logger.error(s"Unexpected result for transactionId [${transactionId}]",e)
              Results.InternalServerError
          }
        }
        catch {
          case e: InvalidSourceFormatException =>
            Logger.error(s"Could not render for transactionId [${transactionId}]",e)
            Results.BadRequest // Error already logged by generator
          case t: Throwable => {
            Logger.error(s"Could not render for transactionId [${transactionId}]. ${t.getMessage}",t)
            Results.InternalServerError
          }
        }

    }.getOrElse(Results.UnsupportedMediaType)

  }

}
