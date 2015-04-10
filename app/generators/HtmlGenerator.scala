package generators

import helpers.CarersWriter
import net.sf.jasperreports.engine.JasperPrint
import java.io.OutputStream
import net.sf.jasperreports.export.`type`.HtmlSizeUnitEnum
import net.sf.jasperreports.export._
import play.api.Logger
import net.sf.jasperreports.engine.export.HtmlExporter

object HtmlGenerator extends ReportGenerator {

  override def exportReportToStream(print: Option[JasperPrint], stream: OutputStream, claimType:String): SuccessOrFailure = {

    try {
      if (print.isDefined) {
        val exporter = new HtmlExporter()
        val lineWriter = new CarersWriter(stream)
        val reportConfiguration = new SimpleHtmlReportConfiguration
        reportConfiguration.setIgnorePageMargins(false)
        reportConfiguration.setRemoveEmptySpaceBetweenRows(true)
        reportConfiguration.setWrapBreakWord(true)
        reportConfiguration.setSizeUnit(HtmlSizeUnitEnum.POINT)
        val exporterConfiguration = new SimpleHtmlExporterConfiguration
        exporterConfiguration.setBetweenPagesHtml("""<p class="htmlPageBreak" style="page-break-after: always"></p>""")
        val exporterInput = new SimpleExporterInput(removeBlankPage(print.get))
        val writerExporter = new SimpleHtmlExporterOutput(lineWriter)
        exporter.setExporterInput(exporterInput)
        exporter.setExporterOutput(writerExporter)
        exporter.setConfiguration(reportConfiguration)
        exporter.setConfiguration(exporterConfiguration)
        exporter.exportReport()
        Logger.debug("HMTL Generated.")
        GenerationSuccess()
      }
      else {
        Logger.error("Received an empty print object to convert to HTML.")
        GenerationFailure()
      }
    } catch {
      case e: Throwable =>
        Logger.error(e.getMessage,e)
        GenerationFailure()
    }
  }

  /**
   * Remove the last empty page from the report
   * @param print
   * @return
   */
  def removeBlankPage (print:JasperPrint):JasperPrint = {
      var pages = print.getPages
      val lastPage = pages.get(pages.size()-1)
      if (null != lastPage && lastPage.getElements.size() == 0){
        pages.remove(lastPage)
      }
      print
  }
}