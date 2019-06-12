package com.opensource.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opensource.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

	User findUserByUsername(String username);
}