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

import com.opensource.dto.ImportProductDto;
import com.opensource.dto.PaymentDto;
import com.opensource.model.ImportProduct;
import com.opensource.model.Payment;
import com.opensource.model.Product;
import com.opensource.repository.ImportRepository;
import com.opensource.repository.PaymentRepositoty;
import com.opensource.service.ImportService;
import com.opensource.service.ProductService;

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

	@Autowired
	private ImportRepository importRepository;
	@Autowired
	private ImportService importService;
	
	@GetMapping("/find-import")
	@ResponseBody
	public ImportProduct findImport(Long id) {
		return importService.findOne(id);
	}
	
	@GetMapping("/delete-import")
	public String deleteImport(@RequestParam(name = "id") Long id) {
		productService.deleteProduct(id);
		return "redirect:/admin/products";
	}
	
	// Xem danh sach nhap hang
	@GetMapping("/import-bill")
	public String loadImportBillInfo(Model model) {
		List<ImportProduct> loadImport = importRepository.findAll();
		System.err.println(loadImport);
		List<ImportProductDto> list=new ArrayList<ImportProductDto>();
		for(ImportProduct item:loadImport) {
			list.add(new ImportProductDto(item));
		}
		
		model.addAttribute("import", list);
		
		return "admin/import-bill";
	}
	
	@PostMapping("/save-import")
	public String saveImport(@RequestParam(name = "importId") long importId) {
		importRepository.update(importId);
//		if (importId == -1) {
//			importRepository.update(importId);
//		} 
//		else {
//			productService.saveProduct(new Product(importId, name, size, price, description, quantity, image));
//		}

		return "redirect:/admin/products";
	}

	@Autowired
	private PaymentRepositoty paymentRepositoty;

	// Xem danh sach thong tin ban hang
	@GetMapping("/payment")
	public String loadPaymentInfo(Model model) {
		List<Payment> loadPaymentInfo = paymentRepositoty.findAll();
		List<PaymentDto> list=new ArrayList<PaymentDto>();
		for(Payment item:loadPaymentInfo) {
			list.add(new PaymentDto(item));
		}
		
		model.addAttribute("payment", list);
		
		return "admin/payment";
	}
	
	//Thong tin don hang
	@GetMapping("/save-payment")
	public String savePayment(@RequestParam(name = "paymentId") long paymentId) {
		
		try {
			if ( paymentId >0 ) {
				paymentRepositoty.update(paymentId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/admin/payment";
	}
}
