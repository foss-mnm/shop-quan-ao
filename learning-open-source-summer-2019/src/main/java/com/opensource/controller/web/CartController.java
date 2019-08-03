package com.opensource.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.opensource.dto.CartDto;
import com.opensource.model.Cart;
import com.opensource.model.CartProduct;
import com.opensource.model.Product;
import com.opensource.repository.CartProductRepo;
import com.opensource.repository.CartRepository;
import com.opensource.repository.ProductRepository;

@Controller
public class CartController {

	public String getUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); // get username current loggin system
		return username;
	}
	
	public int subTotal;
	public int discount;
	public int total;
	
	@Autowired
	private CartProductRepo cartProRepo;

	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private ProductRepository proRepo;
	
	public List<CartDto> convert(List<CartProduct> list){	
		List<CartDto> resultList = new ArrayList<>();
		list.forEach((item)->{
			resultList.add(new CartDto(item));
		});	
		return resultList;
	}

	@GetMapping("/cart")
	public String cart(Model model) {	
		List<CartProduct> cartProduct = cartRepo.loadCart(getUsername());
		List<CartDto> list = convert(cartProduct);
		list.forEach((item)->{
			subTotal+= Float.parseFloat(item.getTotal());
		});
		discount = (int) (subTotal * 0.1);
		total = subTotal - discount;
		model.addAttribute("list", list);
		model.addAttribute("subTotal", subTotal);
		model.addAttribute("discount", discount);
		model.addAttribute("total", total);
		return "web/cart";
	}
	
	@GetMapping("/cart/add-product")
	public String addProduct(@RequestParam(name = "id")long id) {
		
		CartProduct cartProduct = cartRepo.check(id,getUsername());
		Product product = proRepo.getOne(id);
		Cart cart = cartRepo.getCart(getUsername());
		if(cartProduct==null) { // chua laco gi
			CartProduct entity = new CartProduct("1", cart, product);
			cartProRepo.save(entity);
		}else { // da co update lai so luong 
			try {
				cartRepo.update(cartProduct.getCartProductId());
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		return "redirect:/cart";
	}
}
