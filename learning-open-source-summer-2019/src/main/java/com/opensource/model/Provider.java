package com.opensource.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provider")
public class Provider implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "Provider [providerId=" + providerId + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + "]";
	}

	public Provider() {
		super();
	}

	public Provider(long providerId, String name, String address, String phone, String email) {
		super();
		this.providerId = providerId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	@Id
	@GeneratedValue
	@Column(name = "provider_id")
	private long providerId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
}
