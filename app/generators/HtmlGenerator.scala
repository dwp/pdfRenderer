package generators

import helpers.CarersWriter
import net.sf.jasperreports.engine.{JRExporterParameter, JasperPrint}
import java.io.OutputStream
import play.api.Logger
import net.sf.jasperreports.engine.export.{JRHtmlExporterParameter, HtmlExporter}

object HtmlGenerator extends ReportGenerator {

  override def exportReportToStream(print: Option[JasperPrint], stream: OutputStream): SuccessOrFailure = {

    try {
      if (print.isDefined) {
        val exporter = new HtmlExporter()
        val lineWriter = new CarersWriter(stream)
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, removeBlankPage(print.get))
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream)
        exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, lineWriter)
        exporter.setParameter(JRHtmlExporterParameter.BETWEEN_PAGES_HTML, """<p class="htmlPageBreak" style="page-break-after: always"></p>""")
        exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, true)
        exporter.setParameter(JRHtmlExporterParameter.FRAMES_AS_NESTED_TABLES, false)
        exporter.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, false)
        exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, false)
        exporter.setParameter(JRHtmlExporterParameter.IS_WRAP_BREAK_WORD, true)
        exporter.setParameter(JRHtmlExporterParameter.SIZE_UNIT, JRHtmlExporterParameter.SIZE_UNIT_POINT)
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