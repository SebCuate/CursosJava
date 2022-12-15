package com.example.demoJPA.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Setter @Getter
public class ClienteEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre", length = 30)
	@NotEmpty
	@Size(min = 1, max = 30)
	private String nombre;
	
	@Column(name = "apellido", length = 30)
	@NotEmpty
	private String apellido;
	
	@Column(name = "email", length = 30)
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@PrePersist//Se llama justo antes de insertar el registro
	public void prePersist() {
		this.createAt = new Date();
	}
	
}
