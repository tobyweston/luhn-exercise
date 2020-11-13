package exercise.luhn.java;


public interface CreditCardNumberValidator {
	
	Boolean validate(String number) throws CreditCardNumberValidationException;

}
