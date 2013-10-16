import data_sources.{XmlDataSource, ReportDataSource}
import com.tzavellas.sse.guice.ScalaModule

package object modules {
  object ProdModule extends ScalaModule {
    def configure() {
      //bind[ReportDataSource].to[XmlDataSource]
      //bind[Submitter].to[WebServiceSubmitter]
      //bind[TransactionIdService].to[PostgresTransactionIdService]
    }
  }
}
