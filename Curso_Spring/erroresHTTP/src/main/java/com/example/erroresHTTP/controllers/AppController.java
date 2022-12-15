package com.example.erroresHTTP.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.erroresHTTP.errores.UsuarioNoEncontradoException;
import com.example.erroresHTTP.model.domain.Usuario;
import com.example.erroresHTTP.services.UsuarioService;

@Controller
public class AppController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/math")
	public String math() {
//		Integer a = 100/0;
		Integer a = Integer.parseInt("10X");
		return "index";
	}
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {
//		Usuario usuario = usuarioService.obtenerPorId(id);
//		if(usuario == null) {
//			throw new UsuarioNoEncontradoException(id.toString());
//		}
		Usuario usuario = usuarioService.obtenerPorIdOptional(id).orElseThrow(
				() -> new UsuarioNoEncontradoException(id.toString())
			);
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "detalle de usuario: ".concat(usuario.getNombre()));
		return "ver";
	}

}
