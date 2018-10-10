package exercise.luhn

import exercise.luhn.LuhnsAlgorithmCreditCardValidator.separate
import org.hamcrest.CoreMatchers.is
import org.junit.Assert.assertThat
import org.junit.Test

class LuhnsAlgorithmCreditCardValidatorTest {

  @Test def separateANumber(): Unit = {
    assertThat(separate(1L), is(List(1)))
    assertThat(separate(21L), is(List(2, 1)))
    assertThat(separate(321L), is(List(3, 2, 1)))
    assertThat(separate(4321L), is(List(4, 3, 2, 1)))
  }

}