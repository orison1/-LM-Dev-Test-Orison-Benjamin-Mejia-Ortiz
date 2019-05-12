package com.prueba.model.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "acc_account")
@Data
public class Account {
	@Id
	@Column(name = "acc_code")		
	private String code;
	
	@Column(name = "acc_id_cliente")		
	private String codeCliente;
	
	@Column(name="acc_id_produc")     
	private Integer idProducto;     
	
	@ManyToOne(cascade = CascadeType.ALL)     
	@JoinColumn(name = "acc_id_produc", referencedColumnName = "pro_code", insertable = false, updatable = false)     
	@JsonIgnore     
	private Product producto;
	
	@Column(name="acc_fecha_ingreso")
	private Timestamp fechaIngreso;
	
	@Column(name="acc_limit_credit_card")
	private Double limitCredit;
	
	@Column(name="acc_avail_credit_card")
	private Double availCredit;
	
	@Column(name="acc_moth_cut_card")
	private Timestamp monthCout;
	
	@Column(name="acc_debit_loan")
	private Double debitLoan;
	
	@Column(name="acc_total_loan")
	private Double totalLoan;
	
	@Column(name="acc_interes_rate")
	private Double interesRate;
	
	@Column(name="acc_interes_amount")
	private Double interesAmount;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="tra_id_account")
	private Set<Transaction> traDetails;
}
