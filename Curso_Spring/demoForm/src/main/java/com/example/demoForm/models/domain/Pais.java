package com.example.demoForm.models.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class Pais {

	private Integer id;
	private String codigo;
	private String nombre;
	
	public Pais(String pais) {
	}
	
	public Pais(int i, String codigo, String nombre) {
		super();
		this.id = i;
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
}