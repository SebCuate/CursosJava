package com.example.demodi;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.demodi.models.domain.ItemFactura;
import com.example.demodi.models.domain.Producto;
import com.example.demodi.models.services.InterfServiceable;
import com.example.demodi.models.services.MyOtherService;
import com.example.demodi.models.services.MyService;

@Configuration
public class AppConfig {

//	FORMA 4, Constructor
	@Primary
	@Bean("miServicioSimple")
	public InterfServiceable registrarMiServicio() {
		return new MyService();
	}
	
	@Bean("miServicioComplejo")
	public InterfServiceable registrarMiOtroServicio() {
		return new MyOtherService();
	}
	
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		Producto producto1 = new Producto("Laptop", 500d);
		Producto producto2 = new Producto("Teclado", 100d);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 4);
		
		return Arrays.asList(linea1, linea2);
	}
	
	@Bean("itemsFacturaOficina")
	public List<ItemFactura> registrarItemsOficina(){
		Producto producto1 = new Producto("Monitor", 250d);
		Producto producto2 = new Producto("Laptop", 500d);
		Producto producto3 = new Producto("Impresora", 100d);
		Producto producto4 = new Producto("Escritorio", 300d);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 1);
		ItemFactura linea3 = new ItemFactura(producto3, 1);
		ItemFactura linea4 = new ItemFactura(producto4, 1);
		
		return Arrays.asList(linea1, linea2, linea3, linea4);
	}
}
