package com.prueba.model.repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.prueba.model.entity.Transaction;

public interface TransactionsRepository extends CrudRepository<Transaction, String>{

	@Query(value = "select * \r\n" + 
			"from lifebank.tra_transaction tra join \r\n" + 
			"lifebank.acc_account acc on tra.tra_id_account = acc.acc_code\r\n" + 
			"where tra.tra_id_account = :account\r\n" + 
			"and tra.tra_date_trans between :startDate and :endDate" , nativeQuery = true)
	List<Transaction> getInfo(@Param("account") String account, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
