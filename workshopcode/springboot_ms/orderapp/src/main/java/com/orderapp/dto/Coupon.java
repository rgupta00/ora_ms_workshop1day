package com.orderapp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
	private int id;
	private String couponCode;
	private int discountPercentage;
	private Date expiredOn;

}
