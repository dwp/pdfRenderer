package helpers

import play.api.Logger

import scala.xml.NodeSeq

/**
 * Extract version number from XML.
 */
object VersionExtractor {

  /**
   * Extract the version number from XML provided. If there was no version, returns None.
   * @param xml XML to parse and look for version number.
   * @return version number or None if could not find it.
   */
  def extractVersionFrom(xml: NodeSeq): Option[String] = {
    try {
      val node = xml \\ "Version"
      if (node.isEmpty) None
      else {
        if (node.text.matches("""^[0-9.]+$""")) Some(node.text) else {
          Logger.warn(s"Invalid version ${node.text}.")
          None
        }
      }
    } catch {
      case e:Throwable =>
        Logger.error(s"Error while looking for a version. Probably invalid XML. ${e.getMessage}")
        None
    }
  }

}
