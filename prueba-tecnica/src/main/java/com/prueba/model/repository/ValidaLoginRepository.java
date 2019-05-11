package com.prueba.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prueba.model.entity.Cliente;
import com.prueba.model.entity.Login;

public interface ValidaLoginRepository extends CrudRepository<Login, String>{
	@Query(value = "select count(log_id_cliente) from log_control where log_id_cliente = :usuario" , nativeQuery = true)
	int getInfo(@Param("usuario") String usuario);
}
