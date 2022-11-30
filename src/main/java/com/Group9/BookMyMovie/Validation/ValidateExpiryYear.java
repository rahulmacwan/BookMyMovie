package com.Group9.BookMyMovie.Validation;
import java.util.Date;

public class ValidateExpiryYear implements IValidatePayment{

	@Override
	public boolean validate(String input) {
	    boolean result = false;
	    Integer year = new Date().getYear() + 1900;
	        System.out.println("year" + year);
	        if (input.length() == 4) {
	            if (Integer.valueOf(input) <= year) {
	                result = true;
	            }

	        }
	        return result;
	}

}
