package com.Group9.BookMyMovie.Validation;

public class ValidateCreditCard implements IValidatePayment  {

	@Override
	public boolean validate(String input) {
		boolean result=false;
		if(input.length()==12)
		{
			result=true;
			
		}
		return result;
	
	}

}
