package mx.demo.cursoJPA.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import mx.demo.cursoJPA.models.entity.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{


}
