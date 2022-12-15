package com.example.demoJPA.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demoJPA.models.dao.IClienteDao;
import com.example.demoJPA.models.entity.ClienteEntity;
import com.example.demoJPA.models.service.IClienteService;

@Controller
@SessionAttributes("cliente")//Alternativa al hidden id, se guarda en una sesion el objeto cliente
public class ClienteController {

	//Siempre debe ser el tipo más generico
	@Autowired
//	private IClienteDao clienteDao; 
	private IClienteService clienteDao; //Implementación de una clase Service
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(
			@RequestParam(name = "page", defaultValue = "0") int page
			, Model model
			) {
		Pageable pageRequest = PageRequest.of(page, 4);
		
		Page<ClienteEntity> clientes = clienteDao.findAll(pageRequest);
		
		model.addAttribute("titulo", "listado de clientes");
//		model.addAttribute("titulo", clienteDao.findAll()); //Reemplazo por paginación
		model.addAttribute("titulo", clientes); //paginación
		return "listar";
	}
	
	@RequestMapping(value = "/form")
	public String crear(Model model) {
		
		ClienteEntity cliente = new ClienteEntity();
		model.addAttribute("titulo", "Formulario de Cliente");
		model.addAttribute("cliente", cliente);
		return "form";
	}
	
	@RequestMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id ,Model model) {
		
		ClienteEntity cliente;
		
		if(id > 0) {
			cliente = clienteDao.findOne(id);
		} else {
			return "redirect:/listar";
		}
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Editar cliente");
		return "form";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(
			@Valid //Usamos Valid para que haga las validaciones acorde a la
			@ModelAttribute("cliente") //se utiliza para mandar un objeto a otra vista de forma explicita
			ClienteEntity cliente 
			, BindingResult result //Objeto que nos ayuda a hacer las validaciones
			, Model model
			, SessionStatus status //Objeto que nos ayuda con el manejo de objetos en sesion
			) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de cliente");
			return "form";
		}
		
		clienteDao.save(cliente);
		status.setComplete();//Elimina el objeto cliente de la sesión
		return "redirect:listar";
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id ,Model model) {
		
		if(id > 0) 
			clienteDao.delete(id);
		
		return "redirect:/listar";
	}
	
	
}
