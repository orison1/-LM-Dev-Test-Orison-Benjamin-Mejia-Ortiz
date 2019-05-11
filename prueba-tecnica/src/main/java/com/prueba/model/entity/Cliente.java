package com.prueba.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity(name = "cli_cliente")
@Data
public class Cliente {
	@Id
	@Column(name = "cli_code")		
	private String code;		

	@Column(name = "cli_first_name")
	private String name;

	@Column(name = "cli_last_name")
	private String lastName;
	
	@Column(name = "cli_mail")
	private String email;
	
	@Column(name = "cli_user")
	private String user;
	
	@Column(name = "cli_pass")
	private String pass;
	
	@Column(name = "cli_status_account")
	private String statusAccount;
	
	@Column(name = "cli_birthdate")
	private String birthdate; //fecha de nacimiento
	
	@OneToMany(mappedBy="cliCode")
	private Set<Login> cliDetails;
}
