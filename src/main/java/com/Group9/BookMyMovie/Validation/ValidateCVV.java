package com.Group9.BookMyMovie.Validation;

public class ValidateCVV implements IValidatePayment {

	@Override
	public boolean validate(String input) {
		boolean result=false;
		if(input.length()==3)
		{
			
			result=true;
		}
		
		return  result;
	}

}
