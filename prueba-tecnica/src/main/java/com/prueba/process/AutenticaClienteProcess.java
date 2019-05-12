package com.prueba.process;

import java.net.InetAddress;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.model.PruebaProperties.status;
import com.prueba.model.entity.Cliente;
import com.prueba.model.repository.ValidaLoginRepository;
import com.prueba.model.repository.getAutenticationClienteRepository;
import com.prueba.pojo.auntetication.request.AuntRequest;
import com.prueba.pojo.auntetication.response.AuntResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AutenticaClienteProcess {

	private getAutenticationClienteRepository aunClienteRepo;
	private getShaProcess shaProcess;
	private ValidaLoginRepository validaLoginRepo;
	
	public AutenticaClienteProcess(getAutenticationClienteRepository aunClienteRepo, getShaProcess shaProcess, ValidaLoginRepository validaLoginRepo) {
		this.aunClienteRepo = aunClienteRepo;
		this.shaProcess = shaProcess;
		this.validaLoginRepo = validaLoginRepo;
	} 
	
	public ResponseEntity<?> process(AuntRequest request) {
		
		Cliente auntCliente = new Cliente(); 
		AuntResponse response = new AuntResponse();
		String password = "";
		int countLogin = 0;
		EncriptProcess encript = new EncriptProcess(); 
		
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			//valida login
			countLogin = validaLoginRepo.getInfo(request.getUser());
			if(countLogin == 5) {
				//actualizo estado para bloquear la cuenta, seteo erro 400 y termino flujo
				aunClienteRepo.setStatus(status.getLocked(), request.getUser());
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}else {
				auntCliente = aunClienteRepo.getAutentication( request.getUser());
				password = shaProcess.getSha512(request.getPass(),request.getUser());
				
				if(auntCliente.getCode().equals(request.getUser()) && auntCliente.getPass().equals(password)) {
					response.setTokenSession(encript.EncryptJWT(request, inetAddress.getHostAddress()));
					return new ResponseEntity<>(response,HttpStatus.OK);
				}else {
					return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
				}	
			}
			
		} catch (Exception e) {
			log.info("Error en Cliente" + e.getMessage());
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
	
	}
		
}
