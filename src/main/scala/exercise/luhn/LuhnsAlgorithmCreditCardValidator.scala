package exercise.luhn

import exercise.luhn.LuhnsAlgorithmCreditCardValidator._

class LuhnsAlgorithmCreditCardValidator extends CreditCardNumberValidator {

  def validate(number: String) = {
    val doubled = reverseAndDoubleEverySecondDigit(number.toLong)
    val sum = sumOfDigits(doubled)
    isDivisibleByTenExactly(sum)
  }
}

object LuhnsAlgorithmCreditCardValidator {
  def reverseAndDoubleEverySecondDigit(number: Long): List[Int] = {
    separateDigits(number)
      .reverse
      .zipWithIndex
      .map {
        case (value, index) if index % 2 == 0 => value
        case (value, _)                       => value * 2
      }
  }

  def separateDigits(number: Long): List[Int] = {
    number.toString.map(_.asDigit).toList
  }

  def sumOfDigits(digits: List[Int]) = {
    if (digits.isEmpty) 0 else separateDigits(digits.mkString.toLong).sum
  }

  def isDivisibleByTenExactly(dividend: Int) = {
    if (dividend < 0) false else dividend % 10 == 0

  }

}