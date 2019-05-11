package com.prueba.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "pro_product")
@Data
public class Product {
	@Id
	@Column(name = "pro_code")		
	private Integer code;
	
	@Column(name="pro_product_type")
	private String proProduct;
}
