package com.opensource.repository;

public interface CustomQuery {
	
	String 	USER_CHECKDUPLICATE_USERNAME = 
			"select exists(select u from User u where u.username = :username)";
}
