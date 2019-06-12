package com.opensource.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.opensource.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
		
	Role findRoleByRoleName(String roleName);
}
