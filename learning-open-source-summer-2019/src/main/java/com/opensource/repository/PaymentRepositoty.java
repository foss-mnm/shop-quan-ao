package com.opensource.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.opensource.model.Payment;

public interface PaymentRepositoty extends JpaRepository<Payment, Long>{

	@Transactional
	@Modifying
	@Query(CustomQuery.UPDATE_PAYMENT_STATUS)
	void update(@Param("paymentId") long paymentId);
}
