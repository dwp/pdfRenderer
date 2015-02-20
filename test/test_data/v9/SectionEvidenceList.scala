package test_data.v9

import scala.xml.Elem


case class SectionEvidenceList(xml:Elem) {

  val rootPath = xml \ "DWPCATransaction" \ "DWPCAClaim" \ "EvidenceList"

  val address:Seq[String] = {
    val lines = (rootPath \ "RecipientAddress" \ "Answer" \ "Line")

    val elems = (for( elements <- lines; element <- elements.child )yield { element.text.trim })(collection.breakOut)
    elems
  }

  val postCode = rootPath \ "RecipientAddress" \ "Answer" \ "PostCode"

  val evidenceList: Seq[String] = {
    val evidences = rootPath \\ "Evidence"

    val elems = (for( elements <- evidences; element <- elements.child )yield { element.text.trim })(collection.breakOut)
    elems
  }
}
