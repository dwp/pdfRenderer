import com.google.inject.Guice
import modules.ProdModule
import play.api._

object Global extends GlobalSettings {

  def module = ProdModule

  override def onStart(app: Application) {
    super.onStart(app)
    Logger.info("PDFService Started") // used for operations, do not remove
  }

  override def onStop(app: Application) {
    super.onStop(app)
    Logger.info("PDFService Stopped") // used for operations, do not remove
  }
}