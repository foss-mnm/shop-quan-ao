package com.opensource.dto;

import com.opensource.model.User;

public class UserAccountDto {
	
	private String username;
	private String status;
	private String fname;
	private String lname;
	private String phone;
	private String email;
	
	
	public UserAccountDto(User user) {
		super();
		this.username = user.getUsername();
		this.status = "Đang hoạt động";
		this.fname = "";
		this.lname = "";
		this.phone = "";
		this.email = "";
	}
	@Override
	public String toString() {
		return "UserAccountDto [username=" + username + ", status=" + status + ", fname=" + fname + ", lname=" + lname
				+ ", phone=" + phone + ", email=" + email + "]";
	}
	public UserAccountDto() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
