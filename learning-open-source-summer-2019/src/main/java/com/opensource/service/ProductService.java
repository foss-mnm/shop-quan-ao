package com.opensource.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.opensource.model.Product;

public interface ProductService {

	Page<Product> loadProducts(Pageable pages);
	List<Product> loadProducts();

	Product findOne(Long id);
	
	void saveProduct(Product product);
	
	void deleteProduct(Long id);
}
