package service

import generators.{PdfGenerator, ReportGenerator}
import java.io.OutputStream

/**
 * TODO write description
 * @author Jorge Migueis
 */
trait PdfServiceImpl extends PdfService {

  protected def reportGenerator: ReportGenerator = PdfGenerator

  protected def outputStream: OutputStream = {
    null
  }
}
