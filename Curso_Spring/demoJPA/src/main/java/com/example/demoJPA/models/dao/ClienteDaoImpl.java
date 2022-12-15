package com.example.demoJPA.models.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoJPA.models.entity.ClienteEntity;

@Repository //Componente de  persistencia, nos da errores más detallados, traduce los resultados 
//public class ClienteDaoImpl implements IClienteDao { //Reemplazado por CRUD
//public class ClienteDaoImpl implements CrudRepository<ClienteEntity, Long> {//Reemplazado para el paginator
public class ClienteDaoImpl implements PagingAndSortingRepository<ClienteEntity, Long> { //Paginator
	

	@Override
	public <S extends ClienteEntity> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ClienteEntity> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ClienteEntity> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<ClienteEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<ClienteEntity> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ClienteEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends ClienteEntity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<ClienteEntity> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ClienteEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/*
	 * Reemplazado por un CRUD Repository
	 * 
	//Un Entitymanager se encarga de manejar el ciclo de vida del bean 
	//en este caso, maneja los DAOs
	@PersistenceContext //Avisa que se debe de inyectar un EM acorde a la configuracion
	private EntityManager em; 
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)//Envuelve el resultado en una trasaccion, solo queremos leer
	public List<ClienteEntity> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public ClienteEntity findOne(Long id) {
		return em.find(ClienteEntity.class, id);
	}
	
	@Override
	@Transactional
	public void save(ClienteEntity cliente) {
		if(cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente); //Actualiza
		}else {
			em.persist(cliente); //Inserta
		}
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(findOne(id));
	}
	*/
}
