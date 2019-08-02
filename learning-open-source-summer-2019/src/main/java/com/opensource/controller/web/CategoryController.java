package com.opensource.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.opensource.model.Category;
import com.opensource.model.Product;
import com.opensource.service.CategoryService;
import com.opensource.service.ProductService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/shop")
	public String loadCatergories(Model model,
			@RequestParam(name="page", defaultValue="0")Integer page,
			@RequestParam(name="id", defaultValue="0")Long categoryId) {
		
		List<Category> listCategory = categoryService.loadCategories();
		if(categoryId==0) {
			categoryId = listCategory.get(0).getCategoryId();
		}
		
		model.addAttribute("category_name", listCategory);
		
		//Pagination
		Pageable pages=PageRequest.of(page, 9);
		Page<Product> pageProduct=productService.loadProducts(pages,categoryId);
		model.addAttribute("page_product", pageProduct);
		
		int current = pageProduct.getNumber() + 1;
		long total = pageProduct.getTotalPages();
		long totalElement = pageProduct.getTotalElements();
		long begin = 1;
		long end = 1;
		if (current > 3 && total > 4) {
			begin = Math.max(1, current);
		}
		if (total != 0) {
			end = Math.min(begin + 2, total);
		}
		if (current == total - 3) {
			end = total;
		}
		boolean extra = false;
		boolean checkLast = false;
		if (total > 3 && current < total - 3) {
			extra = true;
		}
		if (total > 4 && current < total - 3) {
			checkLast = true;
		}
		String baseUrl = "/shop?page=";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", total);
		model.addAttribute("totalElement", totalElement);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("chambers", pages);
		model.addAttribute("extra", extra);
		model.addAttribute("checkLast", checkLast);
		//End Pagination
		
		return "web/shop";
	}
}
