package com.opensource.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.opensource.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query(value = CustomQuery.PRODUCT_LOAD_BY_CATEGORY,nativeQuery = true)
	public Page<Product> loadProducts(Pageable pagable,@Param("id") Long id);
	
}
