package com.opensource.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.opensource.model.ImportProduct;

public interface ImportRepository extends JpaRepository<ImportProduct, Long>{

	@Transactional
	@Modifying
	@Query(CustomQuery.UPDATE_IMPORT)
	void update(@Param("importId") long importId);
}
