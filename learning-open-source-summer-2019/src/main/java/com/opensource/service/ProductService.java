package com.opensource.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.opensource.model.Product;

public interface ProductService {

	Page<Product> loadProducts(Pageable pages);

	Product findOne(long id);
}
