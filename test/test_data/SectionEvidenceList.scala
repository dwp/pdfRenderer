package test_data

import scala.xml.Elem


case class SectionEvidenceList(xml:Elem) {

  val rootPath = xml \\ "DWPCATransaction" \\ "DWPCAClaim" \\ "EvidenceList"

  val address = (rootPath \\ "RecipientAddress" \\ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val postCode = rootPath \\ "RecipientAddress" \\ "PostCode"

  val evidenceList: Seq[String] = {
    (rootPath \\ "Evidence").
      map(x => {
      Seq((x \\ "Title").text,
         (x \\ "Content").map(v => v.text).reduce((total,cur) => total + " " + cur)
      )
    }).flatten
  }
}
