package com.prueba.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "aun_cliente")
@Data
public class AunteticationCliente {
	@Id
	@Column(name = "aun_code")		
	private Integer code;		

	@Column(name = "aun_user")
	private String user;

	@Column(name = "aun_pass")
	private String pass;
}
