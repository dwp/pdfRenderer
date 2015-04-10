package generators

import java.io.{FileOutputStream, File}
import helpers.VersionExtractor

import scala.xml.Elem
import data_sources.XmlDataSource

object Helper {
  def deleteFile(fileLocation: String): Unit = {
    val pdfFile = new File(fileLocation)
    if (pdfFile.exists()) {
      pdfFile.delete()
    }
  }

  def generatePDF (pdfFileLocation: String, xml: Elem) = {
     generateFile(pdfFileLocation,xml,PdfGenerator)
  }

  def generateHTML (fileLocation: String, xml: Elem) = {
    generateFile(fileLocation,xml,HtmlGenerator)
  }

  private def generateFile(fileLocation:String, xml:Elem, generator: ReportGenerator) = {
    val dataSource = new XmlDataSource(xml)
    val print = generator.generateFrom(dataSource, VersionExtractor.extractVersionFrom(xml))
    val file = new FileOutputStream(fileLocation)
    generator.exportReportToStream(print, file, "")
  }

}
