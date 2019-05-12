package com.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.pojo.product.request.ProductRequest;
import com.prueba.process.GetProductProcess;

@RestController
@RequestMapping("/lifebank")
public class ProductClienteController {
	
	private GetProductProcess productProcess;
	
	@Autowired
	public ProductClienteController(GetProductProcess productProcess){
		this.productProcess = productProcess;
	}
	
	@GetMapping("/product")
	public ResponseEntity<?> productCliente(@RequestHeader("authorization") String authorization) {
		return productProcess.process(authorization);
	} 
}
