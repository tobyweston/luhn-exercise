package exercise.luhn

class LuhnsAlgorithmCreditCardValidator extends CreditCardNumberValidator {

  def validate(number: String): Unit = { // Implement this method
    throw new UnsupportedOperationException
  }
}

object LuhnsAlgorithmCreditCardValidator {

  def separate(number: Long): List[Int] = {
    number.toString.map(_.asDigit).toList
  }

}