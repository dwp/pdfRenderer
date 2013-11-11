package generators

import java.io.{FileOutputStream, File}
import scala.xml.Elem
import data_sources.XmlDataSource

object Helper {
  def deletePdfFile(pdfFileLocation: String): Unit = {
    val pdfFile = new File(pdfFileLocation)
    if (pdfFile.exists()) {
      pdfFile.delete()
    }
  }

  def generatePDF (pdfFileLocation: String, xml: Elem) = {
    val dataSource = new XmlDataSource(xml)
    val print = PdfGenerator.generateFrom(dataSource)
    val file = new FileOutputStream(pdfFileLocation)
    PdfGenerator.exportReportToStream(print, file)
  }


}
