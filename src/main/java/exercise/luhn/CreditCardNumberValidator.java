package exercise.luhn;


public interface CreditCardNumberValidator {
	
	public void validate(String number) throws CreditCardNumberValidationException;

}
