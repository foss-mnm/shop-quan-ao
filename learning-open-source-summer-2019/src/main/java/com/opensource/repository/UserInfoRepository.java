package com.opensource.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.opensource.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	@Transactional
	@Modifying
	@Query(CustomQuery.USERINFO_UPDATE_USER_INFO)
	void updateUserInfo(@Param("firstName") String firstName, @Param("lastName") String lastName,
			@Param("email") String email, @Param("phone") String phone, @Param("userId") long userId);
	
}
