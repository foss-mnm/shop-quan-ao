package com.opensource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping({"/","/home"})
	public String homePage() {
		return "web/index";
	}
}
