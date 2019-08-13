package com.opensource.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.opensource.dto.UserAccountDto;
import com.opensource.dto.UserDto;
import com.opensource.dto.UserInfoDto;
import com.opensource.model.User;
import com.opensource.repository.UserRepository;
import com.opensource.service.UserInfoService;
import com.opensource.service.UserService;

@Controller
@RequestMapping("/admin")
public class AccountController {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository user;

	private boolean usernameError = false;
	
	@GetMapping("/profile")
	public String showAdminInfo(Model model) {
		model.addAttribute("username_error", usernameError);
		try {
			model.addAttribute("adminInfo", userInfoService.getAdminInfo());
		}catch(Exception e) {
			model.addAttribute("adminInfo", new UserInfoDto());
		}
		return "admin/profile";
	}

	@PostMapping("/profile/update-profile-info")
	public String updateInfoAdmin(@Validated UserInfoDto userInfo,BindingResult result) {

		userInfoService.updateUserInfoAdmin(userInfo);
		return "redirect:/admin/profile";

	}

	@PostMapping("/profile/update-profile-login")
	public String updateLoginInfoAdmin(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {
		if(userService.checkUsername(username)) {
			userService.updateAdminLoginInfo(new UserDto(username, password));
			usernameError = false;
		}else {
			usernameError = true;
		}
		return "redirect:/admin/profile";
	}

	@GetMapping("/user")
	public String showUsersInfo(Model model) {
		List<UserAccountDto> rsList = new ArrayList<UserAccountDto>();
		List<User> list = user.loadUserInfo();
		list.forEach((item)->{
			rsList.add(new UserAccountDto(item));
		});
		list.forEach((item)->{
			System.err.println(item);
		});
		model.addAttribute("accounts",rsList);
		return "admin/user-info";
	}
}
