package com.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.pojo.auntetication.request.AuntRequest;
import com.prueba.pojo.auntetication.response.AuntResponse;
import com.prueba.process.AutenticaClienteProcess;

@RestController
@RequestMapping("/aunt")
public class AuntClienteController {

	private AutenticaClienteProcess auntProcess;
	
	@Autowired
	public AuntClienteController(AutenticaClienteProcess auntProcess){
		this.auntProcess = auntProcess;
	}
	
	@PostMapping("/cliente")
	public ResponseEntity<?> auntCliente(@RequestBody AuntRequest request) {
		return auntProcess.process(request);
	} 
}
