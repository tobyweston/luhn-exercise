package exercise.luhn

import exercise.luhn.LuhnsAlgorithmCreditCardValidator.{reverseAndDoubleEverySecondDigit, separateDigits}
import org.hamcrest.CoreMatchers.is
import org.junit.Assert.assertThat
import org.junit.Test

class LuhnsAlgorithmCreditCardValidatorTest {

  @Test def doublesTheNumber(): Unit = {
    assertThat(reverseAndDoubleEverySecondDigit(0L), is(List(0)))
    assertThat(reverseAndDoubleEverySecondDigit(1L), is(List(1)))
    assertThat(reverseAndDoubleEverySecondDigit(21L), is(List(1, 4)))
    assertThat(reverseAndDoubleEverySecondDigit(121L), is(List(1, 4, 1)))
    assertThat(reverseAndDoubleEverySecondDigit(3121L), is(List(1, 4, 1, 6)))
    assertThat(reverseAndDoubleEverySecondDigit(1234567890L), is(List(0, 18, 8, 14, 6, 10, 4, 6, 2, 2)))
  }

  @Test def separateIntoDigits(): Unit = {
    assertThat(separateDigits(1L), is(List(1)))
    assertThat(separateDigits(21L), is(List(2, 1)))
    assertThat(separateDigits(321L), is(List(3, 2, 1)))
    assertThat(separateDigits(4321L), is(List(4, 3, 2, 1)))
  }

}