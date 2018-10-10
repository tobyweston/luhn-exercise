package exercise.luhn;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LuhnsAlgorithmCreditCardValidatorTest {

	private final CreditCardNumberValidator validator = new LuhnsAlgorithmCreditCardValidator();

	@Test
	public void validCreditCardNumbersCanBeVerified() throws Exception {
		assertThat(validator.validate("49927398716"), is(true));
		assertThat(validator.validate("79927398713"), is(true));
	}

}
