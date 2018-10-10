package exercise.luhn;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class LuhnsAlgorithmCreditCardValidatorTest {

	@Test
	public void testExample() throws CreditCardNumberValidationException {
        CreditCardNumberValidator validator = new LuhnsAlgorithmCreditCardValidator();
        Assert.assertThat(validator.validate("XXXXX"), is(true));
	}

}
