package com.example.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@RequestMapping(value={"/index", "/", "", "/home"}, method = RequestMethod.GET)
	public String index(Model model){
		
		model.addAttribute("titulo",textoIndex);
		return "index";
	}
	
	@RequestMapping(value={"/perfil"}, method = RequestMethod.GET)
	public String perfil(Model model){
		Usuario usuario = new Usuario("Sebas", "Cuate", "Sebas@Cuate.com");
		
		
		model.addAttribute("usuario", usuario);
//		model.addAttribute("titulo", "Hola " + usuario.getNombre() + " " + usuario.getApellido());
		model.addAttribute("titulo",textoPerfil);
		return "perfil";
	}
	
	@RequestMapping(value={"/listar"})
	public String listar(Model model){
		model.addAttribute("titulo", textoListar);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(
			new Usuario("1","2","1@2"),
			new Usuario("3","4","3@4"),
			new Usuario("5","6","5@6"),
			new Usuario("7","8","7@8")
				);
				
		return usuarios;
	}
		
}