package com.example.demodi.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Component
//Singleton por default
@RequestScope
//@SessionScope //similar al singleton, en el contexto de Sesion
//@ApplicationScope //similar al singleton, pero en el contexto Servlet
public class Factura implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Value("${factura.descripcion}")
	private String descripcion;
	
	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("itemsFacturaOficina")
	private List<ItemFactura> items;
	
	@PostConstruct
	public void init() {
		cliente.setNombre("Aby");
		cliente.setApellido("Ortega de " + cliente.getApellido());
	}
	
	@PreDestroy
	public void preDes() {
		System.out.println("Factura Destruida");
	}

}
