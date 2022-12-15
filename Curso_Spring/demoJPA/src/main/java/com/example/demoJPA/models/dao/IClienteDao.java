package com.example.demoJPA.models.dao;

import java.util.List;
import com.example.demoJPA.models.entity.ClienteEntity;

public interface IClienteDao {

	//Reemplazados por CRUD
	public List<ClienteEntity> findAll();
	public void save(ClienteEntity cliente);
	public ClienteEntity findOne(Long id);
	public void delete(Long id);
}
