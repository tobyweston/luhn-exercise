package exercise.luhn;


import java.util.List;

import static exercise.luhn.Functions.*;

public class LuhnsAlgorithmCreditCardValidator implements CreditCardNumberValidator {

	public Boolean validate(String number) throws CreditCardNumberValidationException {
		List<Integer> doubled = doubleEverySecondDigitReverseOrder(toLong(number));
		int sumOfDigits = sumOfSingleDigits(doubled);
		return isDivisibleByTenExactly(sumOfDigits);
	}

	private long toLong(String number) throws CreditCardNumberValidationException {
		try {
			if (number.length() != 11) throw new CreditCardNumberValidationException("Credit card numbers must contain 16 digits");
			return Long.parseLong(number);
		} catch (NumberFormatException e) {
			throw new CreditCardNumberValidationException("Credit card numbers must contain only numbers");
		}
	}
}
