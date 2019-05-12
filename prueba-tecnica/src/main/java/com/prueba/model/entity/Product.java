package com.prueba.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity(name = "pro_product")
@Data
public class Product {
	@Id
	@Column(name = "pro_code")		
	private Integer code;
	
	@Column(name="pro_product_type")
	private String proProduct;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="acc_id_produc")
	private Set<Account> proDetails;
}
