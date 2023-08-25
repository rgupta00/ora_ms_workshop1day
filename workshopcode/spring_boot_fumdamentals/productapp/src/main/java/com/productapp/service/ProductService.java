package com.productapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.productapp.dto.Product;

@Service
public class ProductService {
	
	public List<Product> getAll(){
		return List.of(new Product(1, "dell laptop", 67800.00),new Product(2, "laptop cool pad", 1800.00));
	}
	
	public Product getById(int id) {
		return getAll().stream().filter(p-> p.getId()==id).collect(Collectors.toList()).get(0);					
	}

}
