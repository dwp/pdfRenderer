package utils


trait TestUtils {

  def buildQuestion (question :String, answer :String) :String = {
    question + " " + answer
  }

  def buildOther (question :String, answer :String, other :String) :String = {
    !other.isEmpty match {
      case true => buildQuestion(question, answer) + " " + other
      case _ => buildQuestion(question, answer)
    }
  }

  def buildAmount (question :String, currency :String, amount :String) :String = {
    question + " " + amount + " " + currency
  }

}
