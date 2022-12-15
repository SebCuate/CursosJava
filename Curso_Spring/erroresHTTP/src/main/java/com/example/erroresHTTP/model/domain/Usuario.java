package com.example.erroresHTTP.model.domain;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Setter @Getter @NoArgsConstructor
public class Usuario {

	private Integer id;
	private String nombre;
	private String apellido;
	
	
	public Usuario(Integer id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	
	
}
