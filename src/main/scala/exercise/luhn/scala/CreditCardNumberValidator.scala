package exercise.luhn.scala

trait CreditCardNumberValidator {
  def validate(number: String): Either[ValidationError, Boolean]
}

case class ValidationError(reason: String)
