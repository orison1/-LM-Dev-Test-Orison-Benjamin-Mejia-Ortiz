package com.prueba.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.prueba.model.entity.Account;

public interface GetProductClienteRepository extends CrudRepository<Account, String>{
	
	@Query(value = "select *  \r\n" + 
			"from lifebank.acc_account acc \r\n" +  
			"where acc.acc_id_cliente = :usuario" , nativeQuery = true)
	List<Account> getInfo(@Param("usuario") String usuario);
}
