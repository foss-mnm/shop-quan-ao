package com.opensource.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.opensource.service.ProductService;

@Controller
public class CartController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/cart")
	public String cart(Model model) {
		// Load Product
		
		
		model.addAttribute("selected_product", productService.loadProducts());
//		model.addAttribute("total", String.valueOf(price*quantity));
		
		return "web/cart";
	}
}
