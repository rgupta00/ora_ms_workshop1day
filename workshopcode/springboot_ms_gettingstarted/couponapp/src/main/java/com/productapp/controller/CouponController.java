package com.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.Coupon;
import com.productapp.service.CouponService;

@RestController
public class CouponController {
	
	private CouponService couponService;

	@Autowired
	public CouponController(CouponService couponService) {
		this.couponService = couponService;
	}
	
	@GetMapping(path = "coupons/{code}")
	public Coupon getByCode(@PathVariable String code) {
		return couponService.getByCode(code);
	}

}
