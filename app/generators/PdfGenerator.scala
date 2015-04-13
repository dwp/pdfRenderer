package generators

import net.sf.jasperreports.engine.export.{JRPdfExporterParameter, JRPdfExporter}
import net.sf.jasperreports.engine._
import net.sf.jasperreports.export.`type`.PdfaConformanceEnum
import net.sf.jasperreports.export._
import play.api.{Play, Logger}
import java.io.OutputStream
import app.ConfigProperties._
import play.api.Play.current

/**
 * Generates a PDF from a DataSource.
 * It reads the compiled report template, generate a JasperPrint and writes to a stream.
 *
 * @author Jorge Migueis
 */
object PdfGenerator extends ReportGenerator {

  val context = DefaultJasperReportsContext.getInstance()
  def config = initConfig

  private def initConfig = {
    val config = new SimplePdfExporterConfiguration()
    config.setTagged(true)
    config.setPdfaConformance(PdfaConformanceEnum.PDFA_1A)
    config.setIccProfilePath(getProperty("icc.path", "./profile.icc"))

    config.setMetadataAuthor("Carer's allowance digital service")

    config
  }

  override def exportReportToStream(print: Option[JasperPrint], stream: OutputStream): SuccessOrFailure = {
    try {
      if (print.isDefined) {
        val exporter = new JRPdfExporter(context);

        exporter.setExporterInput(new SimpleExporterInput(print.get))
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(stream))
        exporter.setConfiguration(config)

        exporter.exportReport()
        Logger.debug("PDF Generated.")
        GenerationSuccess()
      }
      else {
        Logger.error("Received an empty print object to convert to PDF.")
        GenerationFailure()
      }
    } catch {
      case e: Throwable =>
        Logger.error(e.getMessage,e)
        GenerationFailure()
    }
  }
}
