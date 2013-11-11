package service

import generators.{PdfGenerator, ReportGenerator}
import java.io.{FileOutputStream, OutputStream}
import java.util.Date

/**
 * TODO write description
 * @author Jorge Migueis
 */
trait PdfServiceImpl extends PdfService {

  protected def reportGenerator: ReportGenerator = PdfGenerator

  protected def outputStream: OutputStream = {
    new FileOutputStream("PDFGenerated_" + new Date())
  }
}
