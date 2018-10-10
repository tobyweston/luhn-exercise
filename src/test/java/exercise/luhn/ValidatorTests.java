package exercise.luhn;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class ValidatorTests {

	@Test
	public void testExample() throws CreditCardNumberValidationException {
        CreditCardNumberValidatorImpl validator = new CreditCardNumberValidatorImpl();
        Assert.assertThat(validator.validate("XXXXX"), is(true));
	}

}
