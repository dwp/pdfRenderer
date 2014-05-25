package generators

import net.sf.jasperreports.engine.{JRExporterParameter, JasperPrint}
import java.io.OutputStream
import play.api.Logger
import net.sf.jasperreports.engine.export.{JRHtmlExporterParameter, HtmlExporter}


/**
 * Created by jmi on 07/04/2014.
 */
object HtmlGenerator extends ReportGenerator {

  def exportReportToStream(print: Option[JasperPrint], stream: OutputStream): SuccessOrFailure = {

    try {
      if (print.isDefined) {
        val exporter = new HtmlExporter()
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, print.get)
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream)
        //exporter.setParameter(JRHtmlExporterParameter.BETWEEN_PAGES_HTML, """<p style="page-break-before: always"></p>""")
        exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, true)
        exporter.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, true)
        exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, false)
        exporter.setParameter(JRHtmlExporterParameter.IS_WRAP_BREAK_WORD, true)
        exporter.setParameter(JRHtmlExporterParameter.SIZE_UNIT, JRHtmlExporterParameter.SIZE_UNIT_PIXEL)
        exporter.setParameter(JRHtmlExporterParameter.ZOOM_RATIO, 1.5F)
        exporter.exportReport
        Logger.debug("HMTL Generated.")
        GenerationSuccess()
      }
      else GenerationFailure()
    } catch {
      case e: Throwable => {
        Logger.error(e.getMessage,e)
        GenerationFailure()
      }
    }
  }

  def styleSheetForHtmlOutput = {
    """<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script><script>$(document).ready(function() {$('tr').filter(
          function(){
              return $(this).find('td').length == $(this).find('td:empty').length;
          }).attr('height', 0px)});</script>"""
  }

}
