package com.example.demoForm.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequeridoValidator  implements ConstraintValidator<RequeridoIdentifier, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if(value.isBlank() || value.isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	
}
