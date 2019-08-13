package com.opensource.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opensource.model.Payment;

public interface PaymentRepositoty extends JpaRepository<Payment, Long>{

}
