package helpers

import javax.xml.bind.DatatypeConverter

import gov.dwp.carers.security.encryption.{NotEncryptedException, EncryptorAES}
import gov.dwp.exceptions.DwpRuntimeException
import play.api.Logger

import scala.xml.{Elem, Node}

/**
 * Decrypts a node of the XML provided and returns a new XML with the node decrypted.
 */
object XmlNodeDecryptor {

  /**
   * To be used when one wants to decrypt an optional node of an XML.
   * @param xml XML containing node to decrypt.
   * @param paths Path to the node to decrypt.
   * @return If the node does not exist it returns the original XML, otherwise returns a new XML with the node decrytped.
   */
  def decryptValueForOptionalNode(xml: Node, paths: List[String]): Node = {
    try {
      decryptValueForNode(xml, paths)
    } catch {
      case e:IndexOutOfBoundsException => xml
    }
  }

  /**
   * To be used when one wants to decrypt a mandatory node of an XML.
   * If the node does not exist it throws a runtime exception.
   * @param xml XML containing node to decrypt.
   * @param paths Path to the node to decrypt.
   * @return The new XML with the node decrytped.
   */
  def decryptValueForNode(xml: Node, paths: List[String]): Node = {

    val listNodes = scala.collection.mutable.ListBuffer(xml)
    for (path <- paths) {
      val nodeToAdd = listNodes.last \ path
      listNodes += nodeToAdd(0)
    }
    val decrypted = decryptString(listNodes.last.text)

    val decryptedNode = updateElemChildren(listNodes.last, scala.xml.Text(decrypted))
    updateParents(decryptedNode, listNodes.dropRight(1))

  }

  /**
   * Recursively updates the hierarchy of nodes upwards.
   */
  private def updateParents(newNode: Elem, parents: scala.collection.mutable.ListBuffer[Node]): Elem = {
    if (null != parents && !parents.isEmpty) {
      val parent = parents.last
      val updatedChildList = parent.child.map(node => if (node.label == newNode.label) newNode else node)
      val updatedNewNode = updateElemChildren(parent, updatedChildList: _*)
      updateParents(updatedNewNode, parents.dropRight(1))
    } else {
      newNode
    }
  }

  /**
   * Replaces the children of a node with the new provided children.
   * @param elem Node containing the children to replace. elem should be of type Elem.
   * @param node List of new children.
   * @return return clone of provided node with new children. If the parent node provided is not an Elem then return a new node of type error.
   */
  private def updateElemChildren(elem: Node, node: Node*) = {
    elem match {
      case Elem(prefix, label, attribs, scope, child@_*) => Elem(prefix, label, attribs, scope, true, node: _*)

      case _ => Logger.error(s"Could not update XML node children because node of unexpected type [${elem.xmlType()}].")
        <error>failed adding children</error>
    }
  }

  /**
   * Decrypt a text.
   * @param text text to decrypt.
   * @return A new string containing the text decrypted. If the text was not encrypted, it throws a DwpRuntimeException.
   */
   def decryptString(text: String) = {
    try {
      (new EncryptorAES).decrypt(DatatypeConverter.parseBase64Binary(text))
    } catch {
      case e: NotEncryptedException =>
        // Means field was not encrypted.
        Logger.warn("An XML node that should be encrypted was not encrypted.")
        text
      case e: DwpRuntimeException =>
        Logger.error("Could not decrypt node.")
        throw e
    }
  }

}
