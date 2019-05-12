package com.prueba.process;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.model.entity.Account;
import com.prueba.model.entity.Transaction;
import com.prueba.model.repository.GetProductClienteRepository;
import com.prueba.model.repository.TransactionsRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransactionProcess {

	private TransactionsRepository traRepo;
	private GetProductClienteRepository cliRepo;
	
	
	public TransactionProcess(TransactionsRepository traRepo, GetProductClienteRepository cliRepo) {
		this.traRepo = traRepo;
		this.cliRepo = cliRepo;
	}
	
	public ResponseEntity<?> process(String sch, String startDate, String endDate, String idAccount){
		
		ArrayList<String> cuenta = new ArrayList<String>();
		DecryptProcess decript = new DecryptProcess();
		List<Account> accountListResponse = new ArrayList<Account>();
		List<Transaction> traList = new ArrayList<Transaction>();
		LocalDate start;
		LocalDate end;
		
		try {
			log.info("descifrando sch");
			cuenta = decript.Decrypt(sch);
			
		} catch (Exception e) {
			log.info("ocurrio un error con el sch");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		 //obtengo la info del cliente y luego valido la cuenta a ver si pertenece a ese clietne
		accountListResponse = cliRepo.getInfo(cuenta.get(0));
		
		//llamada a funcion transforma fecha
		start = StringToDate(startDate);
		end = StringToDate(endDate);
		traList = traRepo.getInfo(idAccount, start, end);
		
		if(accountListResponse == null || accountListResponse.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
		}else {
			for(Account accountList : accountListResponse) {
				if(accountList.getCode().equals(idAccount) && accountList.getCodeCliente().equals(cuenta.get(0))) {
					
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
		}
		
		
		return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	public LocalDate StringToDate(String fecha) {
		 
		LocalDate localdate = null;
		
		try {
			localdate = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
		} catch (Exception e) {
			// TODO: handle exception
		}  
		return localdate;
	}
}
