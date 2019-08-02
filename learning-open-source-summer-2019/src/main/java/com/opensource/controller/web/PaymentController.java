package com.opensource.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.opensource.model.UserInfo;
import com.opensource.repository.ProductRepository;
import com.opensource.service.UserService;

@Controller
public class PaymentController {
	
	@Autowired
	private ProductRepository p;
	
	@Autowired
	private UserService u;

	@GetMapping("/payment")
	public String checkOut(@RequestParam("id") Long productId,Model model) {
		
		model.addAttribute("productId", productId);
		model.addAttribute("price", p.getOne(productId).getPrice());
		model.addAttribute("plus",p.getOne(productId).getPrice()*0.1);
		model.addAttribute("total",p.getOne(productId).getPrice()*0.9);
		return "web/checkout";
	}
	
	@PostMapping("/payment/payment")
	public String payment(@RequestParam(name = "id")Long id,
			@RequestParam(name = "fname") String fname,
			@RequestParam(name = "lname") String lname,
			@RequestParam(name = "address") String address,
			@RequestParam(name = "zip") String zip,
			@RequestParam(name = "phone") String phone,
			@RequestParam(name = "email") String email) {
		
		UserInfo uf = new UserInfo(lname, fname, email, phone, null, null);
		u.save(uf);
		return "redirect:/shop";
	}
}
