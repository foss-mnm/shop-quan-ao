package com.opensource.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.opensource.model.Product;
import com.opensource.service.ProductService;

@Controller
public class ProductSingleController {

	@Autowired
	private ProductService productService;

	@GetMapping("/product-single")
	public String product_single(Model model, 
			@RequestParam(name = "id") long id) {
		Product product=productService.findOne(id);
		String name=product.getName();
		model.addAttribute("product_name", name);
		return "web/product-single";
	}

}
