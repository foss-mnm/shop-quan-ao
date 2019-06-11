package com.opensource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opensource.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	User findUserByUsername(String username);
}