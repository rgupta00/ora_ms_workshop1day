package com.orderapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderapp.dto.Coupon;
import com.orderapp.dto.Customer;
import com.orderapp.dto.OrderRequest;

@Service
public class CustomerClientService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Customer getCustomer(OrderRequest orderRequest) {
		Customer customer=restTemplate
				.getForObject("http://CUSTOMER-SERVICE/customerapp/customers/"+
							orderRequest.getCustomerId(), Customer.class);
		
		return customer;
	}
}
