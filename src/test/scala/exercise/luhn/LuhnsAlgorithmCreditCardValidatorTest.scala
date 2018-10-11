package exercise.luhn

import exercise.luhn.LuhnsAlgorithmCreditCardValidator.{reverseAndDoubleEverySecondDigit, separateDigits, sumOfDigits, isDivisibleByTenExactly}
import org.hamcrest.CoreMatchers.is
import org.junit.Assert.assertThat
import org.junit.Test

class LuhnsAlgorithmCreditCardValidatorTest {

  @Test def doublesTheNumber() = {
    assertThat(reverseAndDoubleEverySecondDigit(0L), is(List(0)))
    assertThat(reverseAndDoubleEverySecondDigit(1L), is(List(1)))
    assertThat(reverseAndDoubleEverySecondDigit(21L), is(List(1, 4)))
    assertThat(reverseAndDoubleEverySecondDigit(121L), is(List(1, 4, 1)))
    assertThat(reverseAndDoubleEverySecondDigit(3121L), is(List(1, 4, 1, 6)))
    assertThat(reverseAndDoubleEverySecondDigit(1234567890L), is(List(0, 18, 8, 14, 6, 10, 4, 6, 2, 2)))
  }

  @Test def separateIntoDigits() = {
    assertThat(separateDigits(1L), is(List(1)))
    assertThat(separateDigits(21L), is(List(2, 1)))
    assertThat(separateDigits(321L), is(List(3, 2, 1)))
    assertThat(separateDigits(4321L), is(List(4, 3, 2, 1)))
  }

  @Test def sumIndividualDigits() = {
    assertThat(sumOfDigits(List()), is(0))
    assertThat(sumOfDigits(List(0)), is(0))
    assertThat(sumOfDigits(List(1, 0)), is(1))
    assertThat(sumOfDigits(List(1, 2)), is(3))
    assertThat(sumOfDigits(List(1, 2, 4)), is(7))
    assertThat(sumOfDigits(List(10, 2, 4)), is(7))
    assertThat(sumOfDigits(List(10, 12, 24)), is(10))
  }

  @Test def isANumberDivisibleByTenExactly() = {
    assertThat(isDivisibleByTenExactly(0), is(true))
    assertThat(isDivisibleByTenExactly(1), is(false))
    assertThat(isDivisibleByTenExactly(2), is(false))
    assertThat(isDivisibleByTenExactly(3), is(false))
    assertThat(isDivisibleByTenExactly(5), is(false))
    assertThat(isDivisibleByTenExactly(10), is(true))
    assertThat(isDivisibleByTenExactly(11), is(false))
    assertThat(isDivisibleByTenExactly(20), is(true))
  }

  @Test def isANegativeNumberDivisibleByTenExactly() = {
    assertThat(isDivisibleByTenExactly(-10), is(false))
    assertThat(isDivisibleByTenExactly(-1), is(false))
  }
}