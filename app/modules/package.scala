import data_sources.{XmlDataSource, ReportDataSource}
import scala.xml.NodeSeq
import scala.language.implicitConversions

package object pdfService {

  object Implicits {

 implicit def xmlToDataSource(xml:NodeSeq ):ReportDataSource = new XmlDataSource(xml)
}
}
