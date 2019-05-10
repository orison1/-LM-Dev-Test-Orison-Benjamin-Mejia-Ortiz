package com.prueba.process;

import org.springframework.stereotype.Service;

import com.prueba.model.entity.AunteticationCliente;
import com.prueba.model.repository.getAutenticationClienteRepository;
import com.prueba.pojo.auntetication.request.AuntRequest;
import com.prueba.pojo.auntetication.response.AuntResponse;

@Service
public class AutenticaClienteProcess {

	private getAutenticationClienteRepository aunCliente;
	
	public AutenticaClienteProcess(getAutenticationClienteRepository aunCliente) {
		this.aunCliente = aunCliente;
	} 
	
	public AuntResponse process(AuntRequest request) {
		
		AunteticationCliente auntCliente = new AunteticationCliente(); 
		AuntResponse response = new AuntResponse();
		
		auntCliente = aunCliente.getAutentication(request.getUser(), request.getPass());
		if(auntCliente.getUser().equals(request.getUser()) && auntCliente.getPass().equals(request.getPass())) {
			response.setTokenSession("llamada a funcion que genera token");
		}
		
		return response;
	}
	
	
}
