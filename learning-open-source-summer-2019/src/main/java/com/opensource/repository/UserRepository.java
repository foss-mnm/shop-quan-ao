package com.opensource.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.opensource.model.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

	User findUserByUsername(String username);
	
	@Query(value = CustomQuery.USER_CHECKDUPLICATE_USERNAME,nativeQuery = true)
	boolean checkUsername(@Param("username")String username);
	
	
}