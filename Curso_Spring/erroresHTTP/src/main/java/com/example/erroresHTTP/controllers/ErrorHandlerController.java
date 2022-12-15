package com.example.erroresHTTP.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.erroresHTTP.errores.UsuarioNoEncontradoException;

@ControllerAdvice //Etiqueta para controlar errores, se mapea a una excepción
public class ErrorHandlerController {

	@ExceptionHandler({ArithmeticException.class})
	public String arithmeticException(Exception e, Model model) {
		model.addAttribute("error", "Error de aritmetica");
		model.addAttribute("message", e.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/arithmetic";
	}
	
	@ExceptionHandler({NumberFormatException.class})
	public String numberFormatException(Exception e, Model model) {
		model.addAttribute("error", "Error de formato de numero");
		model.addAttribute("message", e.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/arithmetic";
	}
	
	@ExceptionHandler({UsuarioNoEncontradoException.class})
	public String usuarioNoEncontrado(Exception e, Model model) {
		model.addAttribute("error", "Usuario No Encontrado");
		model.addAttribute("message", e.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());
		return "error/usuarioNoEncontrado";
	}
}
