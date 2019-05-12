package com.prueba.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity(name = "log_control")
@Data
public class Login {
	@Id
	@Column(name = "log_code")		
	private String code;
	
	@Column(name="log_id_cliente")
	private String clienteId;
	
	@ManyToOne
	@JoinColumn(name = "cli_code")
	private Cliente cliCode;
	
	
}
