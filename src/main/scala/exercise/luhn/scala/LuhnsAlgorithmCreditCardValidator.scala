package exercise.luhn.scala

import exercise.luhn.scala.LuhnsAlgorithmCreditCardValidator._

import scala.util.Try

class LuhnsAlgorithmCreditCardValidator extends CreditCardNumberValidator {

  def validate(number: String): Either[ValidationError, Boolean] = {
    for {
      candidate <- toLong(number)
      doubled   <- Right(reverseAndDoubleEverySecondDigit(candidate))
      sum       <- Right(sumOfDigits(doubled))
    } yield isDivisibleByTenExactly(sum)
  }
}

object LuhnsAlgorithmCreditCardValidator {
  def reverseAndDoubleEverySecondDigit(number: Long): List[Int] = {
    separateDigits(number)
      .reverse
      .zipWithIndex
      .map {
        case (value, index) if isEven(index) => value
        case (value, _)                      => value * 2
      }
  }

  private def isEven(index: Int) = index % 2 == 0

  def separateDigits(number: Long): List[Int] = {
    number.toString.map(_.asDigit).toList
  }

  def sumOfDigits(digits: List[Int]) = {
    if (digits.isEmpty) 0 else separateDigits(digits.mkString.toLong).sum
  }

  def isDivisibleByTenExactly(dividend: Int) = {
    if (dividend < 0) false else dividend % 10 == 0
  }

  private def toLong(number: String) = {
    if (number.length != 11) Left(ValidationError("Credit card numbers must contain 11 digits"))
    else Try(number.toLong).toEither.left.map(toError)
  }

  private val toError: Throwable => ValidationError = {
    case _: NumberFormatException => ValidationError("Credit card numbers must contain only numbers")
  }

}