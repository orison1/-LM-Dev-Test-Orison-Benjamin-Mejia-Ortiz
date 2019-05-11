package com.prueba.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.prueba.model.entity.Cliente;

public interface GetProductClienteRepository extends CrudRepository<Cliente, String>{

}
