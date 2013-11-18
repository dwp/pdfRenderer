import com.tzavellas.sse.guice.ScalaModule
import data_sources.{XmlDataSource, ReportDataSource}
import scala.xml.NodeSeq
import scala.language.implicitConversions

package object modules {

  object ProdModule extends ScalaModule {
    def configure() {
      //bind[ReportDataSource].to[XmlDataSource]
      //bind[Submitter].to[WebServiceSubmitter]
      //bind[TransactionIdService].to[PostgresTransactionIdService]
    }
  }

}

package object pdfService {

  object Implicits {

 implicit def xmlToDataSource(xml:NodeSeq ):ReportDataSource = new XmlDataSource(xml)
}
}
