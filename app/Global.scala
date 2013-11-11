import com.google.inject.Guice
import modules.ProdModule
import play.api._

object Global extends GlobalSettings {

  def module = ProdModule

  override def onStart(app: Application) {
    super.onStart(app)
    Logger.info("s2 Started") // used for operations, do not remove
  }

  override def onStop(app: Application) {
    super.onStop(app)
    Logger.info("s2 Stopped") // used for operations, do not remove
  }
}