package com.prueba.process;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prueba.model.entity.Account;
import com.prueba.model.entity.Transaction;
import com.prueba.model.repository.GetProductClienteRepository;
import com.prueba.model.repository.TransactionsRepository;
import com.prueba.pojo.product.response.CreditCard;
import com.prueba.pojo.response.ResponseTransactions;
import com.prueba.pojo.transaction.CreditCardResponse;
import com.prueba.pojo.transaction.LoanResponse;
import com.prueba.pojo.transaction.SavingAccountResponse;

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
		List<com.prueba.pojo.transaction.Transaction> traResponseList = new ArrayList<com.prueba.pojo.transaction.Transaction>();
		LocalDate start;
		LocalDate end;
		int comparacion;
		com.prueba.pojo.transaction.Transaction transac;
		CreditCardResponse creditResponse = new CreditCardResponse(); 
		LoanResponse loanResponse = new LoanResponse();
		SavingAccountResponse savingResponse = new SavingAccountResponse();
		
		if(!(sch.isEmpty())) {
			
			try {
				log.info("descifrando sch");
				cuenta = decript.Decrypt(sch);
				
			} catch (Exception e) {
				log.info("El token a expirado:" + e.getMessage());
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			 //obtengo la info del cliente y luego valido la cuenta a ver si pertenece a ese clietne
			accountListResponse = cliRepo.getInfo(cuenta.get(0));
			
			//llamada a funcion transforma fecha
			start = StringToDate(startDate);
			end = StringToDate(endDate);
			comparacion = start.compareTo(end);
			long meses = ChronoUnit.MONTHS.between(start, end);
			
			if(accountListResponse == null || accountListResponse.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
			}else {
				for(Account accountList : accountListResponse) {
					if(accountList.getCode().equals(idAccount) && accountList.getCodeCliente().equals(cuenta.get(0))) {
						if(comparacion == 0 || comparacion < 0){//la fecha de inicio es menor que la final
							if(meses < 3) {//es menos de tres meses
								traList = traRepo.getInfo(idAccount, start, end);
								for(Transaction tra: traList) {
									transac = new com.prueba.pojo.transaction.Transaction();
									transac.setId(tra.getCode());
									transac.setDate(tra.getIdAccount());
									transac.setDescription(tra.getTranDescription());
									transac.setAmount(tra.getTranAmount());
									traResponseList.add(transac);
								}
								
								switch(traList.get(0).getAccount().getIdProducto()) {
								case 1:
									savingResponse.setId(traList.get(0).getAccount().getCode());//cuenta
									savingResponse.setEndDate(endDate);
									savingResponse.setStartDate(startDate);
									savingResponse.setTransactions(traResponseList);
									return new ResponseEntity<>(savingResponse,HttpStatus.OK);
								case 2:
									creditResponse.setId(traList.get(0).getAccount().getCode());
									creditResponse.setStartDate(startDate);
									creditResponse.setEndDate(endDate);
									creditResponse.setLimit(traList.get(0).getAccount().getLimitCredit());
									creditResponse.setAvailable(traList.get(0).getAccount().getAvailCredit());
									creditResponse.setInterestRate(traList.get(0).getAccount().getInteresRate());
									creditResponse.setInterestAmount(traList.get(0).getAccount().getInteresAmount());
									creditResponse.setMonthlyCut(traList.get(0).getAccount().getMonthCout());
									creditResponse.setTransactions(traResponseList);
									return new ResponseEntity<>(creditResponse,HttpStatus.OK);
								case 3:
									loanResponse.setId(traList.get(0).getAccount().getCode());
									loanResponse.setStartDate(startDate);
									loanResponse.setEndDate(endDate);
									loanResponse.setTotal(traList.get(0).getAccount().getTotalLoan());
									loanResponse.setDebt(traList.get(0).getAccount().getDebitLoan());
									loanResponse.setInterestRate(traList.get(0).getAccount().getInteresRate());
									loanResponse.setInterestAmount(traList.get(0).getAccount().getInteresAmount());
									loanResponse.setTransactions(traResponseList);
									return new ResponseEntity<>(loanResponse,HttpStatus.OK);
								}
								
							}else {
								return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
							}	
						}else {
							return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
						}
					}else {
						return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					}
				}
			}
			
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
			
		}else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
	}
		
	public LocalDate StringToDate(String fecha) {
		 
		LocalDate localdate = null;
		
		try {
			localdate = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.ENGLISH));
		} catch (Exception e) {
			// TODO: handle exception}
		}  
		return localdate;
	}
}
