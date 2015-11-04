package utils

import org.specs2.execute.{Result, AsResult}
import org.specs2.mutable.Around
import play.api.test.{Helpers, FakeApplication}

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

abstract class WithApplication(val app: FakeApplication = FakeApplication()) extends Around with org.specs2.matcher.MustThrownExpectations with org.specs2.matcher.ShouldThrownExpectations {
  implicit def implicitApp = app
  override def around[T: AsResult](t: => T): Result = {
    Helpers.running(app)(AsResult.effectively(t))
  }
}