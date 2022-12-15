package com.example.demodi.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
//@Component("miServicioSimple")
public class MyService implements InterfServiceable{
	
	@Override
	public String operacion() {	
		return "Resultado de un proceso importante...";
	}
	
}
