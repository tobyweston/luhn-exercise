package exercise.luhn;


import java.util.List;
import java.util.stream.IntStream;

import static exercise.luhn.LuhnsAlgorithmCreditCardValidator.Functions.*;
import static java.util.Collections.reverse;
import static java.util.stream.Collectors.toList;

public class LuhnsAlgorithmCreditCardValidator implements CreditCardNumberValidator {

	public Boolean validate(String number) throws CreditCardNumberValidationException {
		List<Integer> doubled = reverseAndDoubleEverySecondDigit(toLong(number));
		int sumOfDigits = sumOfDigits(doubled);
		return isDivisibleByTenExactly(sumOfDigits);
	}

	private long toLong(String number) throws CreditCardNumberValidationException {
		try {
            String stripped = number.replace(" ", "");
            if (stripped.length() != 11) throw new CreditCardNumberValidationException("Credit card numbers must contain 11 digits");
			return Long.parseLong(stripped);
		} catch (NumberFormatException e) {
			throw new CreditCardNumberValidationException("Credit card numbers must contain only numbers");
		}
	}


	static class Functions {

		static List<Integer> reverseAndDoubleEverySecondDigit(Long number) {
			List<Integer> values = separateDigits(number);
			reverse(values);
			List<Integer> doubled = IntStream
					.range(0, values.size())
					.map(index -> isEven(index) ? values.get(index) : values.get(index) * 2)
					.boxed()
					.collect(toList());
			return doubled;
		}

        private static boolean isEven(int index) {
            return index % 2 == 0;
        }

        static List<Integer> separateDigits(Long number) {
            return number.toString()
					.chars()
					.map(Character::getNumericValue)
					.boxed()
					.collect(toList());
		}

		static Integer sumOfDigits(List<Integer> digits) {
			return digits
					.stream()
					.flatMapToInt(x -> separateDigits(Integer.toUnsignedLong(x)).stream().mapToInt(Integer::intValue))
					.sum();
		}


		static Boolean isDivisibleByTenExactly(Integer dividend) {
			if (dividend < 0) return false;
			return dividend % 10 == 0;
		}
	}
}
