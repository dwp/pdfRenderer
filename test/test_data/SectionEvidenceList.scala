package test_data

import scala.xml.Elem


case class SectionEvidenceList(xml:Elem) {

  val rootPath = xml \ "DWPCATransaction" \ "DWPCAClaim" \ "EvidenceList"

  val address = (rootPath \ "RecipientAddress" \ "Answer" \ "Line").map(x => x.text).filterNot(x => x.isEmpty).mkString(" ")

  val postCode = rootPath \ "RecipientAddress" \ "Answer" \ "PostCode"

  val evidenceList: Seq[String] = {
    val evidences = rootPath \\ "Evidence"

    val elems = (for( elements <- evidences; element <- elements.child )yield { element.text.trim })(collection.breakOut)
    elems
  }
}
