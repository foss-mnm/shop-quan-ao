package com.opensource.service;

import java.util.List;

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
	public Product findOne(Long id) {
		return productRepository.getOne(id);
	}

	@Override
	public List<Product> loadProducts() {
		return productRepository.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
