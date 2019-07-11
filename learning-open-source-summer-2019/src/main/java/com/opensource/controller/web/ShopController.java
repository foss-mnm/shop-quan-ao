package com.opensource.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.opensource.service.ProductService;

@Controller
public class ShopController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/shop")
	public String shop() {
		return "web/shop";
	}
}
