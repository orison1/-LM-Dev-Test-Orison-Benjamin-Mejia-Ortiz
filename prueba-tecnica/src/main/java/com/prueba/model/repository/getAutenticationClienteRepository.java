package com.prueba.model.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prueba.model.entity.Cliente;

public interface getAutenticationClienteRepository extends CrudRepository<Cliente, String>{
	
	@Query("select a "
			+ " from cli_cliente a "
			+ " where a.code = :usuario")
	public Cliente getAutentication(@Param("usuario") String usuario);
	
	@Modifying(clearAutomatically = true)
	@Transactional
    @Query("UPDATE cli_cliente c SET c.statusAccount = :status WHERE c.code = :cuenta")
    public int setStatus(@Param("status") String status, @Param("cuenta") String cuenta);

}