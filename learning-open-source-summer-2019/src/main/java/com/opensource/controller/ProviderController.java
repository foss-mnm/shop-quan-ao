package com.opensource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensource.model.Provider;
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
	
	@GetMapping("/find-provider")
	@ResponseBody
	public Provider findProvider(Long id) {
		return providerService.getProvider(id);
	}
	
	@PostMapping("/save-provider")
	public String saveProvider(@RequestParam(name = "id")Long id,
			@RequestParam(name = "name") String name,
			@RequestParam(name = "address") String address,
			@RequestParam(name = "phone") String phone,
			@RequestParam(name = "email") String email) {
		if(id==-1) { // tao moi
			providerService.saveProvider(
					new Provider(name, address, phone, email));
		}else {
			providerService.saveProvider(new Provider(id,name, address, phone, email)); // sua info
		}
		return "redirect:/admin/providers";
	}
	
	@GetMapping("/delete-provider")
	public String deleteProvider(@RequestParam(name = "id")Long id) {
		providerService.deleteProvider(id);
		return "redirect:/admin/providers";
	}
	
	
}
