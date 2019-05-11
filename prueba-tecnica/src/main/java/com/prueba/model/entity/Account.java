package com.prueba.model.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "acc_account")
@Data
public class Account {
	@Id
	@Column(name = "acc_id_cliente")		
	private String code;
	
	@Column(name="pro_product_type")
	private String proProduct;
	
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
}
