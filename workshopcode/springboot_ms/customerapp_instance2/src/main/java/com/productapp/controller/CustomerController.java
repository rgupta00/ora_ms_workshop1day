package com.productapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.Customer;

@RestController
public class CustomerController {
	
	@Value("${server.port}")
	private String portNo;
	
	@GetMapping(path = "customers/{id}")
	public Customer getById(@PathVariable  int id) {
		return new Customer(id, "rajat", "rajat@gmail.com", portNo);
	}

}
