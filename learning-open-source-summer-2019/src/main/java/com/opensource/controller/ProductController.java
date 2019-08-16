package com.opensource.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opensource.dto.PaymentDto;
import com.opensource.model.Payment;
import com.opensource.model.Product;
import com.opensource.repository.PaymentRepositoty;
import com.opensource.service.ProductService;

import javassist.expr.NewArray;

@Controller
@RequestMapping("/admin")
public class ProductController {

//	Controller quan ly san pham, nha cung cap, loai san pham, nhap hang, ban hang

	@Autowired
	private ProductService productService;

	// Xem danh sach san pham
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
	public String saveProduct(@RequestParam(name = "productId") Long id, @RequestParam(name = "image") String image,
			@RequestParam(name = "name") String name, @RequestParam(name = "size") String size,
			@RequestParam(name = "price") float price, @RequestParam(name = "quantity") String quantity,
			@RequestParam(name = "description") String description) {

		if (id == -1) {
			productService.saveProduct(new Product(name, size, price, description, quantity, image));
		} else {
			productService.saveProduct(new Product(id, name, size, price, description, quantity, image));
		}

		return "redirect:/admin/products";
	}

	@GetMapping("/delete-product")
	public String deleteProduct(@RequestParam(name = "id") Long id) {
		productService.deleteProduct(id);
		return "redirect:/admin/products";
	}

	// Xem danh sach loai san pham
	@GetMapping("/categories")
	public String loadListCategories() {
		return "admin/categorys";
	}

	// Xem danh sach nhap hang
	@GetMapping("/import-bill")
	public String loadImportBillInfo() {
		return "admin/import-bill";
	}

	@Autowired
	private PaymentRepositoty paymentRepositoty;

	// Xem danh sach thong tin ban hang
	@GetMapping("/payment")
	public String loadPaymentInfo(Model model) {
		List<Payment> loadPaymentInfo = paymentRepositoty.findAll();
		System.err.println(loadPaymentInfo);
		List<PaymentDto> list=new ArrayList<PaymentDto>();
		for(Payment item:loadPaymentInfo) {
			list.add(new PaymentDto(item));
		}
		
		model.addAttribute("payment", list);
		
		return "admin/payment";
	}
	
	@GetMapping("/save-payment")
	public String savePayment(@RequestParam(name = "paymentId") Long paymentId) {
		
		if ( paymentId >-1 ) {
			paymentRepositoty.update(paymentId);;
		}

		return "redirect:/admin/payment";
	}
}
