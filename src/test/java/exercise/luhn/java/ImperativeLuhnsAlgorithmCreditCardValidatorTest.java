package exercise.luhn.java;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ImperativeLuhnsAlgorithmCreditCardValidatorTest {

	private final CreditCardNumberValidator validator = new ImperativeLuhnsAlgorithmCreditCardValidator();

	@Test
	public void validCreditCardNumbersCanBeVerified() throws Exception {
		assertThat(validator.validate("49927398716"), is(true));
		assertThat(validator.validate("79927398713"), is(true));
	}

	@Test
	public void invalidCreditCardNumbers() throws Exception {
		assertThat(validator.validate("49927398711"), is(false));
		assertThat(validator.validate("79927398711"), is(false));
	}


}