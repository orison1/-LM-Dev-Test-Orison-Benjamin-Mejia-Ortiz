package com.prueba.process;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.model.PruebaProperties.accounType;
import com.prueba.model.entity.Account;
import com.prueba.model.repository.GetProductClienteRepository;
import com.prueba.pojo.product.response.Accounts;
import com.prueba.pojo.product.response.Ahorro;
import com.prueba.pojo.product.response.CreditCard;
import com.prueba.pojo.product.response.Prestamo;
import com.prueba.pojo.product.response.ProductResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GetProductProcess {
	
	private GetProductClienteRepository productClienteRepo; 
	
	@Autowired
	public GetProductProcess(GetProductClienteRepository productClienteRepo) {
		this.productClienteRepo = productClienteRepo;
	}
	
	public ResponseEntity<?> process(String sch) {
	
		ArrayList<String> cuenta = new ArrayList<String>();
		CreditCard creditCard;
		Ahorro ahorro;
		Prestamo prestamo;
		List<Account> accountListResponse = new ArrayList<Account>();
		List<Ahorro> ahorrotListResponse = new ArrayList<Ahorro>();
		List<CreditCard> credittListResponse = new ArrayList<CreditCard>();
		List<Prestamo> PrestamoListResponse = new ArrayList<Prestamo>();
		DecryptProcess decript = new DecryptProcess(); 
		ProductResponse response = new ProductResponse();
		
		if(!(sch.isEmpty())) {
			
			try {
				log.info("descifrando sch");
				cuenta = decript.Decrypt(sch);
			} catch (Exception e) {
				log.info("El token a expirado:" + e.getMessage());
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
				log.info("Obteniendo info de productos del cliente");
				accountListResponse = productClienteRepo.getInfo(cuenta.get(0));
				
				if(accountListResponse == null || accountListResponse.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
				}else {
					for(Account accountList : accountListResponse) {
						if(accountList.getIdProducto() == 1) {//si es 1 es cuenta de ahorro
							ahorro = new Ahorro();
							ahorro.setId(accountList.getIdProducto().toString());
							ahorro.setName(accounType.getPersonal());
							ahorrotListResponse.add(ahorro);
						}else if(accountList.getIdProducto() == 2) {//Tarjeta de credito
							creditCard = new CreditCard();
							creditCard.setId(accountList.getIdProducto().toString());
							creditCard.setName(accounType.getCard());
							credittListResponse.add(creditCard);
						}else if(accountList.getIdProducto() == 3) {//Prestamo
							prestamo = new Prestamo();
							prestamo.setId(accountList.getIdProducto().toString());
							prestamo.setName(accounType.getLoan());
							PrestamoListResponse.add(prestamo);
						}
						
					}
					
					response = validaListas(ahorrotListResponse,credittListResponse,PrestamoListResponse);
					
					return new ResponseEntity<>(response,HttpStatus.OK);
				}
		
		}else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
				
	} 
	
	public ProductResponse validaListas(List<Ahorro> ahorrotListResponse, List<CreditCard> credittListResponse,List<Prestamo> PrestamoListResponse) {
		
		ProductResponse response = new ProductResponse();
		Accounts accounts = new Accounts();
		
		if(ahorrotListResponse.size() >0) {
			accounts.setAhorro(ahorrotListResponse);	
		}
		if(credittListResponse.size() >0) {
			accounts.setCreditCard(credittListResponse);	
		}
		if(PrestamoListResponse.size()>0) {
			accounts.setPrestamo(PrestamoListResponse);
		}
		
		response.setAccounts(accounts);
		
		return response;
	}
}
