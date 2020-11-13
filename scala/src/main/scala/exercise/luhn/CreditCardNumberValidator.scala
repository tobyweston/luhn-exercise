package exercise.luhn

trait CreditCardNumberValidator {
  def validate(number: String): Either[ValidationError, Boolean]
}

case class ValidationError(reason: String)
