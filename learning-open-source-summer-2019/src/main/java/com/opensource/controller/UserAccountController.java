package com.opensource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opensource.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserAccountController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user-account")
	String userAccount(Model model) {
		model.addAttribute("customers", userService.customer());
		return "admin/user-account";
	}
	
	
}
