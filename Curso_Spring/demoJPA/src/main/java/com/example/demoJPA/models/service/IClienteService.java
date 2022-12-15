package com.example.demoJPA.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demoJPA.models.entity.ClienteEntity;

public interface IClienteService {

	public List<ClienteEntity> findAll();
	
	public Page<ClienteEntity> findAll(Pageable pageable);

	public void save(ClienteEntity cliente);

	public ClienteEntity findOne(Long id);

	public void delete(Long id);

}
