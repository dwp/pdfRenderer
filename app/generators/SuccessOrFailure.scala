package generators

trait SuccessOrFailure

case class GenerationSuccess() extends SuccessOrFailure

case class GenerationFailure() extends SuccessOrFailure
