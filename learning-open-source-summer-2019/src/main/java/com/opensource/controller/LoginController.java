package com.opensource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping({"/","/index"})
	public String index() {
		return "test/index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "test/admin";
	}
	
	@GetMapping("/cart")
	public String cart() {
		return "test/cart";
	}
	
	@GetMapping("/403")
	public String errorPage() {
		return "403";
	}
}
