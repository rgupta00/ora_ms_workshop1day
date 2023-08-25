package com.orderapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderapp.dto.OrderRequest;
import com.orderapp.dto.Product;
@Service
public class ProductClientService {
	@Autowired
	private RestTemplate restTemplate;
	
	public Product getProduct(OrderRequest orderRequest ) {
		Product product=restTemplate
				.getForObject("http://PRODUCT-SERVICE/productapp/products/"+
							orderRequest.getProductId(), Product.class);
		return product;
	}
}
