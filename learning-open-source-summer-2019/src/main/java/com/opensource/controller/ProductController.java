package com.opensource.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
//	@Autowired
//	private ProductService productService;
	
//	Controller quan ly san pham, nha cung cap, loai san pham, nhap hang, ban hang
	
	//Xem danh sach san pham
	@GetMapping("/products")
	public String loadListProducts(Model model) {
//		model.addAttribute("", productService.showAll());
		return "admin/products";
	}
	
	//Xem danh sach loai san pham
	@GetMapping("/categories")
	public String loadListCategories() {
		return "admin/categorys";
	}
	
	//Xem danh sach nhap hang
	@GetMapping("/import-bill")
	public String loadImportBillInfo() {
		return "admin/import-bill";
	}
	
	//Xem danh sach thong tin ban hang
	@GetMapping("/payment")
	public String loadPaymentInfo() {
		return "admin/payment";
	}
	
}
