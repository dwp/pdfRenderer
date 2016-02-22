package generators

import scala.xml.Elem
import generators.Helper._
import java.io.File
import com.itextpdf.text.pdf.parser._
import org.specs2.mutable.Specification
import play.Logger

trait PdfContentMatchingSpec extends Specification{

  val seperator = "\\r?\\n|\\r"
  val space = " "

  def deletAndGeneratePDF(pdfFileLocation: String, xml: Elem) = {
    deleteFile(pdfFileLocation)
    generatePDF(pdfFileLocation, xml)
  }

  def testOutputFileExists(pdfFileLocation: String, xml: Elem) = {
    deletAndGeneratePDF(pdfFileLocation, xml)
    val pdfFile = new File(pdfFileLocation)
    pdfFile.exists() must beTrue
  }

  def getPDFContent(pdfFileLocation: String): String = {

    val reader = new com.itextpdf.text.pdf.PdfReader(pdfFileLocation)

    val parser = new PdfReaderContentParser(reader)

    val content: Seq[String] = for (i <- 1 to reader.getNumberOfPages) yield {
      val strategy = parser.processContent(i, new SimpleTextExtractionStrategy())

      var text = strategy.getResultantText

      text = cleanPdfContent(text, i)

      text.trim
    }
    reader.close()

    content.mkString(" ").toLowerCase
      .replaceAll(seperator, space) //Replacing new lines for spaces
      .replaceAll(" service version : 0\\.[0-9]{2}  ","") //Removing the header from the pdf -> text conversion because it interfered with field values
  }

  def cleanPdfContent(text:String, pageNumber:Int):String = {
     var textArray = text.split(seperator)
     for (i <- 0 until textArray.length){
      val dataItem = textArray(i)
       if (pageNumber > 1 && (dataItem.startsWith("Date Received:") || dataItem.startsWith("Transaction:") || dataItem.startsWith("service version :"))){
         textArray.update(i, " ")
       }
       if (dataItem.startsWith("Page")){
         textArray.update(i, "")
       }
     }
     textArray.mkString(space)
  }

  def foundMustBeTrue(testData: Seq[String], totalContent: String) = {
    testData.forall(x => {
      Logger.trace(s"x : $x")
      var found = totalContent.toLowerCase.contains(x.toLowerCase)
      if (!found){
        found = matchIndividualContent (x.toLowerCase, totalContent.toLowerCase)
      }
      if (!found) {
        Logger.error("TotalContent " + totalContent)
        Logger.error("*** Generated ....:" + x.toLowerCase)
        Logger.error("*** Failed to find:" + x.toLowerCase)
        Logger.debug("*** End ***")
      }
      found
    })
  }

  def matchIndividualContent (data:String, totalContent: String):Boolean = {
    var matchFound = true
    var textAccumulator = ""

    var dataArray = data.split(" ")
    for (i <- 0 until dataArray.length-1){
      val dataItem = dataArray(i)
      textAccumulator = textAccumulator.concat(dataItem).concat(" ")
      var result = totalContent.toLowerCase.contains(textAccumulator)
      if (!result) {
        textAccumulator = textAccumulator.replace(dataItem,dataArray(dataArray.length-1))
        if (!totalContent.toLowerCase.contains(textAccumulator)){
          return false
        }
        return checkTailText(totalContent, dataArray, i)
      }
    }
    matchFound
  }

  def checkTailText(totalContent:String, dataArray:Array[String],i:Int):Boolean = {
    var tailText = ""
    for (j <- i until dataArray.length-1){
      tailText = tailText.concat(dataArray(j)).concat(" ")
    }
    return totalContent.toLowerCase.contains(tailText)
  }

  def testContentMatches(pdfFileLocation: String,
                         testCaseXml: Elem,
                         generateTestData: (Elem => Seq[String]),
                         matchFunction: ((Seq[String], String) => Boolean)) = {
    testOutputFileExists(pdfFileLocation, testCaseXml)
    val totalContent = getPDFContent(pdfFileLocation)
    println(totalContent)
    val testData = generateTestData(testCaseXml)
    println(testData)
    matchFunction(testData, totalContent) must beTrue
    deleteFile(pdfFileLocation)
  }
}
