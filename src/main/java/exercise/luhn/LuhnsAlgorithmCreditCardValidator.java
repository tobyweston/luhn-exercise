package exercise.luhn;


import java.util.List;
import java.util.function.IntUnaryOperator;
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
			if (number.length() != 11) throw new CreditCardNumberValidationException("Credit card numbers must contain 16 digits");
			return Long.parseLong(number);
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
					.map(index -> index % 2 == 0 ? values.get(index) : values.get(index) * 2)
					.boxed()
					.collect(toList());
			return doubled;
		}

		static List<Integer> separateDigits(Long number) {
			IntUnaryOperator toInteger = c -> Integer.parseInt(String.valueOf((char) c));

			return number.toString()
					.chars()
					.map(toInteger)
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
