package com.example.demoJPA.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoJPA.models.dao.IClienteDao;
import com.example.demoJPA.models.entity.ClienteEntity;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
//	private IClienteDao clienteDao; //Reemplazado por CRUD
	private CrudRepository<ClienteEntity, Long> clienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<ClienteEntity> findAll() {
		return ((ClienteServiceImpl) clienteDao).findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ClienteEntity findOne(Long id) {
		return clienteDao.findById(id).get();
	}
	
	@Override
	@Transactional
	public void save(ClienteEntity cliente) {
		clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
//		clienteDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ClienteEntity> findAll(Pageable pageable) {
		
		return null;
	}
	
	

}
