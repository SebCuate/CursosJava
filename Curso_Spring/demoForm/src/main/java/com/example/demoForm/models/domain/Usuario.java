package com.example.demoForm.models.domain;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demoForm.validation.RegexIdentifier;
import com.example.demoForm.validation.RequeridoIdentifier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

//	@Pattern(regexp = "([\\d]{3}[.,]){3}[-][A-Z]{1}")
	@RegexIdentifier
	private String identificador;

//	@NotBlank(message = "El nombre no puede estar vacio")
	@RequeridoIdentifier
	private String nombre;

//	@NotBlank
	@RequeridoIdentifier
	private String apellido;

	@NotBlank
	@Size(min = 3, max = 15)
	private String username;

	@NotBlank
	private String password;

	@Email
	@NotBlank
	private String email;

	@NotNull
	@Min(1)
	@Max(1000)
	private Integer cuenta;

	@NotNull
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechanac;
	
	@NotBlank
	private Pais pais;
	
	public Usuario() {
	}

	public Usuario(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Usuario(String identificador, String nombre, String apellido, String username, String password,
			String email) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Usuario(String identificador, String nombre, String apellido, String username, String password, String email,
			Integer cuenta) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.password = password;
		this.email = email;
		this.cuenta = cuenta;
	}
	
	public Usuario(String identificador, String nombre, String apellido, String username, String password, String email,
			Integer cuenta, Date fechaNac) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.password = password;
		this.email = email;
		this.cuenta = cuenta;
		this.fechanac = fechaNac;
	}
	
	public Usuario(String identificador, String nombre, String apellido, String username, String password, String email,
			Integer cuenta, Date fechaNac, String pais) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.password = password;
		this.email = email;
		this.cuenta = cuenta;
		this.fechanac = fechaNac;
		this.pais = new Pais(pais);
	}

}
