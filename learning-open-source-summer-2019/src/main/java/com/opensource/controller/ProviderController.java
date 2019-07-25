package com.opensource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opensource.service.ProviderService;

@Controller
@RequestMapping("/admin")
public class ProviderController {
	
	@Autowired
	private ProviderService providerService;
	
	//Xem danh sach nha cung cap
	@GetMapping("/providers")
	public String loadListProviders(Model model) {
		model.addAttribute("providers", providerService.loadProviders());
		return "admin/providers";
	}
}
