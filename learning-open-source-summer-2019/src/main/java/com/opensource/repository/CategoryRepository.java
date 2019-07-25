package com.opensource.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.opensource.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
