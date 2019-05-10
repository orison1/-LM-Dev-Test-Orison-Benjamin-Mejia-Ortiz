package com.prueba.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prueba.model.entity.AunteticationCliente;

public interface getAutenticationClienteRepository extends CrudRepository<AunteticationCliente, String>{
	
	@Query("select a "
			+ " from aun_cliente a "
			+ " where a.user = :usuario and a.pass = :contra")
	public AunteticationCliente getAutentication(@Param("usuario") String usuario, @Param("contra") String contra);
}
