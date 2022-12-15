package com.example.demodi.models.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemFactura {
	
	private Producto producto;
	private Integer cantidad;
	

	public ItemFactura(Producto producto, Integer cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}
	
	public Double calcularImporte() {
		return cantidad * producto.getPrecio();
	}

}
