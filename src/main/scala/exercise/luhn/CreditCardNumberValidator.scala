package exercise.luhn

trait CreditCardNumberValidator {
  def validate(number: String): Boolean
}
