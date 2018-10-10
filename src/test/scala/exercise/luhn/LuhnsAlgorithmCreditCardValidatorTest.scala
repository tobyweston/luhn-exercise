package exercise.luhn

import exercise.luhn.LuhnsAlgorithmCreditCardValidator.{doubleEverySecondDigitReverseOrder, separate}
import org.hamcrest.CoreMatchers.is
import org.junit.Assert.assertThat
import org.junit.Test

class LuhnsAlgorithmCreditCardValidatorTest {

  @Test def doublesTheNumber(): Unit = {
    assertThat(doubleEverySecondDigitReverseOrder(0L), is(List(0)))
    assertThat(doubleEverySecondDigitReverseOrder(1L), is(List(1)))
    assertThat(doubleEverySecondDigitReverseOrder(21L), is(List(4, 1)))
    assertThat(doubleEverySecondDigitReverseOrder(121L), is(List(1, 4, 1)))
    assertThat(doubleEverySecondDigitReverseOrder(3121L), is(List(6, 1, 4, 1)))
    assertThat(doubleEverySecondDigitReverseOrder(1234567890L), is(List(2, 2, 6, 4, 10, 6, 14, 8, 18, 0)))
  }

  @Test def separateANumber(): Unit = {
    assertThat(separate(1L), is(List(1)))
    assertThat(separate(21L), is(List(2, 1)))
    assertThat(separate(321L), is(List(3, 2, 1)))
    assertThat(separate(4321L), is(List(4, 3, 2, 1)))
  }

}