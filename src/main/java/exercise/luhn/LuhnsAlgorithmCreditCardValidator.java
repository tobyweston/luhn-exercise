package exercise.luhn;


import java.util.List;

import static exercise.luhn.Functions.*;

public class LuhnsAlgorithmCreditCardValidator implements CreditCardNumberValidator {

	public Boolean validate(String number) throws CreditCardNumberValidationException {
		List<Integer> doubled = doubleEverySecondDigitReverseOrder(Long.parseLong(number));
		int sumOfDigits = sumOfSingleDigits(doubled);
		return isDivisibleByTenExactly(sumOfDigits);
	}
}
