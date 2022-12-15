package com.example.demodi.models.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Producto {

	private String nombre;
	private Double precio;
	
	public Producto(String nombre, Double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
}
