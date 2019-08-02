package com.opensource.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.opensource.model.Product;
import com.opensource.service.ProductService;

@Controller
public class ProductSingleController {

	@Autowired
	private ProductService productService;

	@GetMapping("/product-single")
	public String product_single(Model model, 
			@RequestParam(name = "id",defaultValue="1") long id,
			@RequestParam(name="page", defaultValue="0")Integer page) {
		// Load Single Product
		Product product=productService.findOne(id);
		String name=product.getName();
		String price=String.valueOf(product.getPrice());
		String description=product.getDescription();
		String size=product.getSize();
		String quantity=product.getQuantity();
		
		model.addAttribute("product_name", name);
		model.addAttribute("product_price", price);
		model.addAttribute("product_description", description);
		model.addAttribute("product_size", size);
		model.addAttribute("product_quantity", quantity);
		model.addAttribute("product_img", product.getImage());
		
		// Load Others
		Pageable pages=PageRequest.of(page, 4);
		Page<Product> pageProduct=productService.loadProducts(pages,1L);
		
		model.addAttribute("four_products", pageProduct);
		
		return "web/product-single";
	}

}
