import play.api._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    super.onStart(app)
    Logger.info("PDFService Started") // used for operations, do not remove
  }

  override def onStop(app: Application) {
    super.onStop(app)
    Logger.info("PDFService Stopped") // used for operations, do not remove
  }
}