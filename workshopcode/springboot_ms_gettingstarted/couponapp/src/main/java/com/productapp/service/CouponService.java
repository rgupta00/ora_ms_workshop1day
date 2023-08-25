package com.productapp.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.productapp.dto.Coupon;

@Service
public class CouponService {

	//SUP10
	public Coupon getByCode(String couponCode) {
		Coupon coupon=null;
		if(couponCode.equalsIgnoreCase("SUP10"))
			coupon=new Coupon(1, couponCode, 10, new Date());
		else if(couponCode.equalsIgnoreCase("SUP20"))
			coupon=new Coupon(1, couponCode, 20, new Date());
		else if(couponCode.equalsIgnoreCase("SUP15"))
			coupon=new Coupon(1, couponCode, 15, new Date());
		else
			coupon=new Coupon(1, couponCode, 2, new Date());
		
		return coupon;
	}
}
