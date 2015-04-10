package generators

import net.sf.jasperreports.engine.export.{JRPdfExporterParameter, JRPdfExporter}
import net.sf.jasperreports.engine._
import net.sf.jasperreports.export.`type`.PdfaConformanceEnum
import net.sf.jasperreports.export._
import play.api.Logger
import java.io.OutputStream
import app.ConfigProperties._

/**
 * Generates a PDF from a DataSource.
 * It reads the compiled report template, generate a JasperPrint and writes to a stream.
 *
 * @author Jorge Migueis
 */
object PdfGenerator extends ReportGenerator {

  val context = DefaultJasperReportsContext.getInstance()
  val config = initConfig

  private def initConfig = {
    val config = new SimplePdfExporterConfiguration()
    config.setTagged(true)
    config.setPdfaConformance(PdfaConformanceEnum.PDFA_1A)
    config.setIccProfilePath(getProperty("icc.path","./profile.icc"))
    config.setMetadataTitle("")
    config.setMetadataAuthor("Carer's allowance digital service")

    config
  }

  private def setConfigTitle(title:String) = {
    val config = new SimplePdfExporterConfiguration()
    config.setTagged(this.config.isTagged)
    config.setPdfaConformance(this.config.getPdfaConformance)
    config.setIccProfilePath(this.config.getIccProfilePath)
    config.setMetadataTitle(title)
    config.setMetadataAuthor(this.config.getMetadataAuthor)
    config
  }
  override def exportReportToStream(print: Option[JasperPrint], stream: OutputStream, claimType:String): SuccessOrFailure = {
    try {
      if (print.isDefined) {
        val exporter = new JRPdfExporter(context);

        exporter.setExporterInput(new SimpleExporterInput(print.get))
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(stream))
        exporter.setConfiguration(setConfigTitle(claimType))

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
        Logger.info("classpath "+System.getProperty("java.class.path"))
        Logger.error(e.getMessage,e)
        GenerationFailure()
    }
  }
}
