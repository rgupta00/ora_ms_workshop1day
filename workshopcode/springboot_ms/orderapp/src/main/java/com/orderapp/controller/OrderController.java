package com.orderapp.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.orderapp.dto.Coupon;
import com.orderapp.dto.Customer;
import com.orderapp.dto.OrderRequest;
import com.orderapp.dto.OrderResponse;
import com.orderapp.dto.Product;

@RestController
public class OrderController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	//i want to create a post method ....
	@PostMapping(path = "orders")
	public ResponseEntity<OrderResponse> bookOrder(@RequestBody  OrderRequest orderRequest) {
		
		//call coupon service 
		Coupon coupon=restTemplate
				.getForObject("http://localhost:8085/couponapp/coupons/"+
							orderRequest.getCouponCode(), Coupon.class);
		
		
		//call product
		Product product=restTemplate
				.getForObject("http://localhost:8082/productapp/products/"+
							orderRequest.getProductId(), Product.class);
		//call customer
		Customer customer=restTemplate
				.getForObject("http://localhost:8081/customerapp/customers/"+
							orderRequest.getCustomerId(), Customer.class);
		
		//we need to create the order and asyn rabbitMQ ...
		
		double discountedPrice= product.getPrice()-product.getPrice()*coupon.getDiscountPercentage()/100;
		OrderResponse orderResponse=new OrderResponse();
		orderResponse.setId(UUID.randomUUID().toString());
		orderResponse.setCustomer(customer);
		orderResponse.setProduct(product);
		orderResponse.setOrderDate(new Date());
		
		
		orderResponse.setTotalPrice(discountedPrice*orderRequest.getQty());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
	}

}









