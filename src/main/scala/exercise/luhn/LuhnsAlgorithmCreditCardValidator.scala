package exercise.luhn

class LuhnsAlgorithmCreditCardValidator extends CreditCardNumberValidator {

  def validate(number: String): Unit = { // Implement this method
    throw new UnsupportedOperationException
  }
}

object LuhnsAlgorithmCreditCardValidator {
  def reverseAndDoubleEverySecondDigit(number: Long): List[Int] = {
    separate(number)
      .reverse
      .zipWithIndex
      .map {
        case (value, index) if index % 2 == 0 => value
        case (value, _)                       => value * 2
      }
  }

  def separate(number: Long): List[Int] = {
    number.toString.map(_.asDigit).toList
  }

}