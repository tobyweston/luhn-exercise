package exercise.luhn;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LuhnsAlgorithmCreditCardValidatorTest {

	@Rule public ExpectedException exception = ExpectedException.none();

	private final CreditCardNumberValidator validator = new LuhnsAlgorithmCreditCardValidator();

	@Test
	public void validCreditCardNumbersCanBeVerified() throws Exception {
		assertThat(validator.validate("49927398716"), is(true));
		assertThat(validator.validate("79927398713"), is(true));
	}

	@Test
	public void invalidCreditCardNumbers() throws Exception {
		exception.expect(CreditCardNumberValidationException.class);
		exception.expectMessage("Credit card numbers must contain only numbers");
		assertThat(validator.validate("4992739871x"), is(true));
	}

}
