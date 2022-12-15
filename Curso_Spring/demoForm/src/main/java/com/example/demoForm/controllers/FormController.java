package com.example.demoForm.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demoForm.editors.NombreMayusEditor;
import com.example.demoForm.models.domain.Pais;
import com.example.demoForm.models.domain.Usuario;
import com.example.demoForm.validation.UsuarioValidator;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidator validador;
	
	@InitBinder
	//Inicializa un validador que esta disponible para todos los datos
	public void initBinder(WebDataBinder binder) {
//		binder.setValidator(validador); //Perdemos las anotaciones de validadores 
		binder.addValidators(validador); //Se agregan validadores
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);//si es estrico o tolerante (ahora esta como estricto)
		binder.registerCustomEditor(Date.class, "fechanac",new CustomDateEditor(dateFormat, false));
		
//		binder.registerCustomEditor(String.class,  new NombreMayusEditor());
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario("123.456.789.-K", "Sebas","Cuate","SebasCu","CUate","c@u.com", 999);
		model.addAttribute("titulo", "Resultado form");		
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	@PostMapping("/form")
	public String procesar(
			@Valid Usuario usuario,
			BindingResult result, //siempre despues del argumento a validar
			Model model
			,SessionStatus status
//		,@RequestParam String username,
//		@RequestParam String password,
//		@RequestParam String email
			) {
//		Usuario usuario = new Usuario(username, password, email);
		
		validador.validate(usuario, result);
		model.addAttribute("titulo", "Resultado form");
		if(result.hasErrors()) {
//			Map<String, String> errores = new HashMap<>();
//			result.getFieldErrors().forEach(err -> {
//				errores.put(err.getField(), 
//						"El campo ".concat(err.getField())
//						.concat(" ").concat(err.getDefaultMessage())
//					);
//			});
//			model.addAttribute("error", errores);
			
			return "form";
		}
				
		model.addAttribute("usuario", usuario);
//		model.addAttribute("username", username);
//		model.addAttribute("password", password);
//		model.addAttribute("email", email);	
		status.setComplete();
		return "resultado";
	}
	
	@ModelAttribute("paises")
	public List<String> paises(){
		return Arrays.asList("Mexico", "Peru", "Colombia");
	}
	
	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap(){
		Map<String, String> paises = new HashMap();
		paises.put("Mx", "Mexico");
		paises.put("Pe", "Paru");
		paises.put("Co", "Colombia");
		return paises;
	}
	
	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises(){
		return Arrays.asList(
		new Pais(1, "Mx", "Mexico"),
		new Pais(2, "Pe", "Paru"),
		new Pais(3, "Co", "Colombia")
		);
	}
}
