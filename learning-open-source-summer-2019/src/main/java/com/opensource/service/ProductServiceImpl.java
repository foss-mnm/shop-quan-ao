package com.opensource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.opensource.model.Product;
import com.opensource.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Page<Product> loadProducts(Pageable pages) {
		return productRepository.findAll(pages);
	}

	@Override
	public Product findOne(long id) {
		return productRepository.getOne(id);
	}
}
