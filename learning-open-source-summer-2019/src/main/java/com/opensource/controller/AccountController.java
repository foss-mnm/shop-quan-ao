package com.opensource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AccountController {

	@GetMapping("/profile")
	public String showAdminInfo() {
		return "admin/profile";
	}
	
	@GetMapping("/user")
	public String showUsersInfo() {
		return "admin/user-info";
	}
}
