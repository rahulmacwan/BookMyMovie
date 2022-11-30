package com.Group9.BookMyMovie.Validation;

public class ValidateExpiryMonth implements IValidatePayment {

	@Override
	public boolean validate(String input) {
		Integer month=Integer.valueOf(input);
		boolean result=false;
		if(month>=1 && month<=12)
		{
			result=true;
		}
		
		return result;
	}

}
