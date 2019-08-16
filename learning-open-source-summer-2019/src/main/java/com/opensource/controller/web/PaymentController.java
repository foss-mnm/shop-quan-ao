package com.opensource.controller.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.opensource.model.Payment;
import com.opensource.model.PaymentProduct;
import com.opensource.model.Product;
import com.opensource.model.User;
import com.opensource.model.UserInfo;
import com.opensource.repository.PaymentProductRepositoty;
import com.opensource.repository.PaymentRepositoty;
import com.opensource.repository.ProductRepository;
import com.opensource.repository.UserInfoRepository;
import com.opensource.service.UserService;

@Controller
public class PaymentController {

	@Autowired
	private ProductRepository productServive;

	@Autowired
	private UserService userService;

	@Autowired
	private UserInfoRepository userInfoRepo;

	@Autowired
	private PaymentRepositoty paymentRepo;

	@Autowired
	private PaymentProductRepositoty ppRepo;

	public String getUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); // get username current loggin system
		return username;
	}

	@GetMapping("/payment")
	public String checkOut(@RequestParam(name = "id", defaultValue = "-1") Long productId, Model model,
			@RequestParam(name = "subTotal", defaultValue = "-1") int subTotal) {

		model.addAttribute("productId", productId);
		if (subTotal != -1) {
			model.addAttribute("price", subTotal);
			model.addAttribute("plus", (int) subTotal * 0.1);
			model.addAttribute("total", (int) subTotal * 0.9);
		} else {
			model.addAttribute("price", (int) productServive.getOne(productId).getPrice());
			model.addAttribute("plus", (int) productServive.getOne(productId).getPrice() * 0.1);
			model.addAttribute("total", (int) productServive.getOne(productId).getPrice() * 0.9);
		}
		return "web/checkout";
	}

	@PostMapping("/payment/payment")
	public String payment(@RequestParam(name = "id") Long id, @RequestParam(name = "fname") String fname,
			@RequestParam(name = "lname") String lname, @RequestParam(name = "address") String address,
			@RequestParam(name = "zip") String postcode, @RequestParam(name = "phone") String phone,
			@RequestParam(name = "email") String email, @RequestParam(name = "total") String total) {

		User user = userService.loadUserByUsername(getUsername());
		UserInfo userInfo = null;
		
		try {
			userInfo = new UserInfo(user.getUserID(), lname, fname, email, phone, user);
			userInfoRepo.save(userInfo);
		}catch(Exception e) {
			userInfo = userInfoRepo.getOne(user.getUserID());	
		}

		Product product = productServive.getOne(id);

		Date date = new Date();
		Payment payment = new Payment(total, date, address, postcode, 0, user);
		paymentRepo.save(payment);

		PaymentProduct pp = new PaymentProduct(product, payment);
		ppRepo.save(pp);

		return "redirect:/shop";
	}
}
