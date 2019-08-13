package com.opensource.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
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
	
	@Query(value = CustomQuery.USER_FIND_USER_ID_WITH_ROLE_ADMIN,nativeQuery = true)
	long getUserIdWithRoleAdmin();
	
	//2 anotation @Transaction @Modifying bat buoc phai co khi them, sua, xoa voi custom-query
	@Transactional
	@Modifying
	@Query(CustomQuery.USER_UPDATE_ADMIN_LOGIN_DATA)
	void updateAdminLoginInfo(@Param("username")String username,
			@Param("password")String password,@Param("userID")long userID);
	
	@Query(value = CustomQuery.USER_CHECK_EXISTED_OTHER_ADMIN,nativeQuery = true)
	int checkAdminName();
	
	@Query(value = CustomQuery.USER_LOAD_USER_INFO,nativeQuery = true)
	List<User> loadUserInfo();
	
}