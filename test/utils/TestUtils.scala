package utils


trait TestUtils {

  def buildQuestion (question :String, answer :String) :String = {
    question + " " + answer
  }

  def buildOther (question :String, answer :String, other :String) :String = {
    val otherLabel = "Other"
    answer match {
      case "Other" => buildQuestion(question, answer) + " " + buildQuestion("Other", other)
      case _ => buildQuestion(question, answer)
    }
  }

  def buildAmount (question :String, currency :String, amount :String) :String = {
    question + " " + amount + " " + currency
  }

}
