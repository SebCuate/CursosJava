package com.example.erroresHTTP.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.erroresHTTP.model.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	private List<Usuario> lista;
	
	
	public UsuarioServiceImpl() {
		this.lista = new ArrayList<Usuario>();
		this.lista.add(new Usuario(1, "1", "1"));
		this.lista.add(new Usuario(2, "2", "2"));
		this.lista.add(new Usuario(3, "3", "3"));
		this.lista.add(new Usuario(4, "4", "4"));
		this.lista.add(new Usuario(5, "5", "5"));
		this.lista.add(new Usuario(6, "6", "6"));
		this.lista.add(new Usuario(7, "7", "7"));
		this.lista.add(new Usuario(8, "8", "8"));
		this.lista.add(new Usuario(9, "9", "9"));
	}

	@Override
	public List<Usuario> listar() {
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado = null;
		for(Usuario u : this.lista) {
			if(u.getId().equals(id)) {
				resultado = u;
				break;
			}
		}
		return resultado;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario = this.obtenerPorId(id);
		return Optional.ofNullable(usuario);
	}	
	
}
