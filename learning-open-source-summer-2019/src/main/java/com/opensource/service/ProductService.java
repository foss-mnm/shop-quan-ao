package com.opensource.service;

import java.util.List;

import com.opensource.model.Product;

public interface ProductService {

	List<Product> loadProducts();
	Product findOne(long id);
}
