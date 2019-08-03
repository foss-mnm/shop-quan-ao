package com.opensource.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.opensource.model.Cart;
import com.opensource.model.CartProduct;

public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query(CustomQuery.CART_LOAD_LIST_PRODUCT)
	List<CartProduct> loadCart(@org.springframework.data.repository.query.Param("username") String username);

	@Query(CustomQuery.CART_CHECK_EXISTED_PRODUCT)
	CartProduct check(@org.springframework.data.repository.query.Param("id") Long productId,
			@org.springframework.data.repository.query.Param("username") String username);

	@Transactional
	@Modifying
	@Query(CustomQuery.CART_UPDATE_QUANTITY)
	void update(@org.springframework.data.repository.query.Param("id") Long cartProductId);

	@Query(CustomQuery.CART_GET_CART)
	Cart getCart(@org.springframework.data.repository.query.Param("username") String username);
}
