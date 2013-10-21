package generators

import java.io.File

/**
 * Created with IntelliJ IDEA.
 * User: valtechuk
 * Date: 21/10/2013
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
object Helper {
  def deletePdfFile(pdfFileLocation: String): Unit = {
    val pdfFile = new File(pdfFileLocation)
    if (pdfFile.exists()) {
      pdfFile.delete()
    }
  }
}
