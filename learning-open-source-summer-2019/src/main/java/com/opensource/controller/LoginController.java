package com.opensource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "login/register";
	}
	
	@GetMapping("/403")
	public String errorPage() {
		return "login/403";
	}
}
