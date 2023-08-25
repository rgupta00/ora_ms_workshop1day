package com.productapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.Product;
import com.productapp.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
public class ProductController {
	
	private ProductService productService;
	private Logger logger=LoggerFactory.getLogger(ProductController.class);
	
	
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(path = "products")
	public List<Product> getAll() {
		return productService.getAll();
	}

	@GetMapping(path = "products/{id}")
	public Product getById(@PathVariable  int id) {
		logger.info("getProduct is called for id "+ id +" ");
		return productService.getById(id);
	}
}






