package com.example.demoForm.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//Con esta linea indicamos que clase usara para validar los campos anotados
@Constraint(validatedBy = RequeridoValidator.class) 

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface RequeridoIdentifier {

	String message() default "No puede estar vacio";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
