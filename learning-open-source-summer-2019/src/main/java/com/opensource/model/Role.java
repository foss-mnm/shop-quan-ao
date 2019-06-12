package com.opensource.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id",nullable = false)
	private long roleID;
	
	@Column(name = "role_name",nullable = false)
	private String roleName;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
	
	public Set<User> getUsers() {
		return users;
	}
	
	public Role() {}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Role(String name) {
		this.roleName = name;
	}

	public long getRoleID() {
		return roleID;
	}

	public void setRoleID(long roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}

