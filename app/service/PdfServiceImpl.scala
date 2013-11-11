package service

import generators.{PdfGenerator, ReportGenerator}
import java.io.{FileOutputStream, OutputStream}
import java.util.Date
import java.text.SimpleDateFormat

/**
 * TODO write description
 * @author Jorge Migueis
 */
trait PdfServiceImpl extends PdfService {

  protected def reportGenerator: ReportGenerator = PdfGenerator

  protected def outputStream: OutputStream = {
    new FileOutputStream(s"PDFGenerated_${new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())}.pdf")
  }
}
