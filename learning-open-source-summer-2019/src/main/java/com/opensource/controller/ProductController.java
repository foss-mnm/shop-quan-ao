package com.opensource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensource.model.Product;
import com.opensource.service.ProductService;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
//	Controller quan ly san pham, nha cung cap, loai san pham, nhap hang, ban hang
	
	@Autowired
	private ProductService productService;
	
	//Xem danh sach san pham
	@GetMapping("/products")
	public String loadListProducts(Model model) {
		model.addAttribute("products", productService.loadProducts());
		return "admin/products";
	}
	
	@GetMapping("/find-product")
	@ResponseBody
	public Product findProduct(Long id) {
		return productService.findOne(id);
	}
	
	@PostMapping("/save-product")
	public String saveProduct(@RequestParam(name="id")Long id,
			@RequestParam(name="name")String name) {
		
		return "redirect:/admin/products";
	}
	
	@GetMapping("/delete-product")
	public String deleteProduct(@RequestParam(name="id")Long id) {
		productService.deleteProduct(id);
		return "redirect:/admin/products";
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
