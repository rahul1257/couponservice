package com.rahul.springcloud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rahul.springcloud.model.Coupon;
import com.rahul.springcloud.repos.CouponRepo;

@Controller
public class CouponController {

	@Autowired
	CouponRepo couponRepo;
	
	@GetMapping("/showCreateCoupon")
	public String showCreateCoupon() {
		return "createCoupon";
	}
	
	@PostMapping("/saveCoupon")
	public String saveCoupon(Coupon coupon) {
		couponRepo.save(coupon);
		return "createResponse";
	}
	
	@GetMapping("/showGetCoupon")
	public String showGetCoupon() {
		return "getCoupon";
	}
	
	@PostMapping("/getCoupon")
	public ModelAndView getCoupon(String code) {
		ModelAndView mav = new ModelAndView("couponDetails");
		Coupon coupon = couponRepo.findByCode(code);
		mav.addObject(coupon);
		return mav;
	}
	
}

