package com.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.process.GetProductProcess;
import com.prueba.process.TransactionProcess;

@RestController
@RequestMapping("/lifebank")
public class TransactionController {

	private TransactionProcess traProcess; 
	
	public TransactionController(TransactionProcess traProcess){
		this.traProcess = traProcess;
	}
	
	@GetMapping("/product/{accountID}")
	public ResponseEntity<?> productCliente(@RequestHeader("authorization") String authorization, @RequestParam String startDate, @RequestParam String endDate, @PathVariable String accountID) {
		return traProcess.process(authorization, startDate, endDate, accountID);
	} 
}
