package com.opensource.dto;

import com.opensource.model.UserInfo;

public class UserInfoDto {
	
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	//get data
	public UserInfoDto(UserInfo user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.phoneNumber = user.getPhone();
	}
	
	
	public UserInfoDto() {
		super();
	}


	//receive data
	public UserInfoDto(String fisrtName, String lastName, String email, String phoneNumber) {
		this.firstName = fisrtName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getFisrtName() {
		return firstName;
	}
	public void setFisrtName(String fisrtName) {
		this.firstName = fisrtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
