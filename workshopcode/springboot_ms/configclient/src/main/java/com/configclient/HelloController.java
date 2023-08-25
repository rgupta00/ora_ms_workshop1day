package com.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Value("${my.key: not found}")
	private String value;
	
	@GetMapping(path = "hello")
	public String hello() {
		return "hello "+ value;
	}

}
