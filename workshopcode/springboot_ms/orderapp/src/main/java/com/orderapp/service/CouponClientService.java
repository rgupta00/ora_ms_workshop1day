package com.orderapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderapp.dto.Coupon;
import com.orderapp.dto.OrderRequest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@Service
public class CouponClientService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	//http://localhost:8080/orderapp/actuator/health
	
	
	
	@CircuitBreaker(fallbackMethod = "getCouponFallBack", name = "couponservice")
	public Coupon getCoupon(OrderRequest orderRequest ) {
		Coupon coupon=restTemplate
				.getForObject("http://COUPON-SERVICE/couponapp/coupons/"+
							orderRequest.getCouponCode(), Coupon.class);
		
		return coupon;
	}
	
	public Coupon getCouponFallBack(OrderRequest orderRequest, Exception ex ) {
		System.out.println("------------------------------------");
		System.out.println("getCouponFallBack is called");
		System.out.println("------------------------------------");
		System.out.println(ex.getMessage());
		Coupon coupon=new Coupon();
		coupon.setCouponCode("SUP10");
		coupon.setDiscountPercentage(10);
		
		return coupon;
	}

}
