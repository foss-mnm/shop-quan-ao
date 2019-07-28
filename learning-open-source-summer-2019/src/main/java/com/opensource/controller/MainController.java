package com.opensource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.opensource.model.Product;
import com.opensource.service.ProductService;
import com.opensource.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "login/register";
	}
	
	
	@Autowired
	private ProductService productService;
	
	@GetMapping({"/","/home"})
	public String homePage(Model model,
			@RequestParam(name="page", defaultValue="0")Integer page) {
		// Load Others
		Pageable pages=PageRequest.of(page, 4);
		Page<Product> pageProduct=productService.loadProducts(pages);
		
		model.addAttribute("four_products", pageProduct);
		
		return "web/index";
	}
	
	//Xem danh sach san pham
	@GetMapping("/products")
	public String loadListProducts(Model model) {
		model.addAttribute("products", productService.loadProducts());
		return "admin/products";
	}
	
	@GetMapping("/403")
	public String errorPage() {
		return "login/403";
	}

	@PostMapping("/submit-register")
	public String submitRegister(@RequestParam(name = "name") String username,
			@RequestParam(name = "re_pass") String password,Model model) {

		if(userService.checkUsername(username)) {
			userService.addUser(username, password);
			return "redirect:/login";
		}else {
			model.addAttribute("error", true);
			return "redirect:/register";
		}
	}
}
