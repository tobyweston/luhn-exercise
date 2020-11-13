package exercise.luhn.java;

public class CreditCardNumberValidationException extends Exception {

	public CreditCardNumberValidationException(String reason) {
		super(reason);
	}
}
