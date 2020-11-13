package exercise.luhn;

public class CreditCardNumberValidationException extends Exception {

	public CreditCardNumberValidationException(String reason) {
		super(reason);
	}
}
