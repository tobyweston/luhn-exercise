package exercise.luhn;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.concurrent.Callable;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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
		assertThat(validator.validate("49927398711"), is(false));
		assertThat(validator.validate("79927398711"), is(false));
	}

	@Test
	public void creditCardNumbersContainingNonNumerics() throws Exception {
		exception.expect(CreditCardNumberValidationException.class);
		exception.expectMessage("Credit card numbers must contain only numbers");
		validator.validate("4992739871x");
	}

	@Test
	public void creditCardNumbersAreIncorrectLength() throws Exception {
		assertThrows(() -> validator.validate(""), "Credit card numbers must contain 16 digits");
		assertThrows(() -> validator.validate("1"), "Credit card numbers must contain 16 digits");
		assertThrows(() -> validator.validate("x"), "Credit card numbers must contain 16 digits");
		assertThrows(() -> validator.validate("499273987161"), "Credit card numbers must contain 16 digits");
	}

	private <V> void assertThrows(Callable<V> function, String expectedMessage) throws Exception {
		try {
			function.call();
			fail("Expected exception to be raised");
		} catch (CreditCardNumberValidationException e) {
			assertThat(e.getMessage(), is(expectedMessage));
		}
	}
}
