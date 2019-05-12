package com.prueba.model.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "tra_transaction")
@Data
public class Transaction {

	@Id
	@Column(name = "tra_code")		
	private String code;
	
	@Column(name = "tra_date_trans")		
	private Timestamp tranDate;
	
	@Column(name = "tra_amount")		
	private Double tranAmount;
	
	@Column(name = "tra_descrip_transac")		
	private String tranDescription;
	
	@Column(name="tra_id_account")     
	private String idAccount;
	
	@ManyToOne(cascade = CascadeType.ALL)     
	@JoinColumn(name = "tra_id_account", referencedColumnName = "acc_code", insertable = false, updatable = false)     
	@JsonIgnore     
	private Account account;
	
}
