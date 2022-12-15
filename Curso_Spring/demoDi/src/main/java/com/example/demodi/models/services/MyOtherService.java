package com.example.demodi.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
//@Component("miServicioComplejo")
public class MyOtherService implements InterfServiceable{
	
	@Override
	public String operacion() {
		return "My other Service";
	}

}
