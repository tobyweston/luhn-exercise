package exercise.luhn;


public interface CreditCardNumberValidator {
	
	Boolean validate(String number) throws CreditCardNumberValidationException;

}
