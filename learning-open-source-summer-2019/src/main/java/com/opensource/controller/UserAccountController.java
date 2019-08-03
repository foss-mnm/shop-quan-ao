package com.opensource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class UserAccountController {

	@GetMapping("/user-account")
	String userAccount() {
		return "admin/user-account";
	}
	
	
}
