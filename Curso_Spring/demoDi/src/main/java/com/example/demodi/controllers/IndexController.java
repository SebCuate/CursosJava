package com.example.demodi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demodi.models.services.InterfServiceable;

@Controller
public class IndexController {
	
//	FORMA 1: Field Injection
	@Autowired
	@Qualifier("miServicioComplejo")
	private InterfServiceable servicio;
	
//	FORMA 2: Setter Injection
//	@Autowired
//	public IndexController(InterfServiceable servicio) {
//		super();
//		this.servicio = servicio;
//	}

	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("objeto", servicio.operacion());
		return "index";
	}

//	FORMA 3 Interface Injection
//	@Autowired
//	public void setServicio(InterfServiceable servicio) {
//		this.servicio = servicio;
//	}
	
	
	
}
