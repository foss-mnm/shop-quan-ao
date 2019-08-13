package com.opensource.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opensource.model.PaymentProduct;

public interface PaymentProductRepositoty extends JpaRepository<PaymentProduct, Long>{

}
