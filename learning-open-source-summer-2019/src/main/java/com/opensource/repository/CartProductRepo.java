package com.opensource.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opensource.model.CartProduct;

public interface CartProductRepo extends JpaRepository<CartProduct, Long>{

}
