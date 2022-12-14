package com.example.demoHorario.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@Value("${config.horario.apertura}")
	private Integer apertura;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;

	@GetMapping({"/", "/index"})
	public String index(Model model) {
		model.addAttribute("titulo", "Bienvenido al servicio de atención a clientes, estas en horario de servicio");
		return "index";
	}
	
	@GetMapping("/cerrado")
	public String cerrado(Model model) {
		model.addAttribute("titulo", "Fuera del horario de atención");	
		model.addAttribute("mensaje", "Cerrado, por favor visitenos desde las " + apertura +" hrs. hasta las " + cierre + "hrs.");
		return "cerrado";
	}
}
