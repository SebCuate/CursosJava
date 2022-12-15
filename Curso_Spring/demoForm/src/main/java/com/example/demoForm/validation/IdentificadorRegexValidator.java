package com.example.demoForm.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentificadorRegexValidator implements ConstraintValidator<RegexIdentifier, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if(value.matches("([\\d]{3}[.,]){3}[-][A-Z]{1}")) {
			return true;
		}
		
		return false;
	}	
	
}
