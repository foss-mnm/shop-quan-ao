package com.opensource.config;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.opensource.model.Role;
import com.opensource.model.User;
import com.opensource.repository.RoleRepository;
import com.opensource.repository.UserRepository;

@Component
public class DataInit implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// Roles
		if (roleRepository.findRoleByRoleName("ROLE_ADMIN") == null) {
			roleRepository.save(new Role("ROLE_ADMIN"));
		}
		
		if (roleRepository.findRoleByRoleName("ROLE_MEMBER") == null) {
			roleRepository.save(new Role("ROLE_MEMBER"));
		}
		
		// Admin account
		if (userRepository.findUserByUsername("admin@gmail.com") == null) {
			User admin = new User();
			admin.setUsername("admin@gmail.com");
			admin.setPassword(passwordEncoder.encode("123456"));
			admin.setEnabled(true);
			HashSet<Role> roles = new HashSet<>();
			roles.add(roleRepository.findRoleByRoleName("ROLE_ADMIN"));
			roles.add(roleRepository.findRoleByRoleName("ROLE_MEMBER"));
			admin.setRoles(roles);
			userRepository.save(admin);
		}
		
		// Member account
		if (userRepository.findUserByUsername("member@gmail.com") == null) {
			User user = new User();
			user.setUsername("member@gmail.com");
			user.setPassword(passwordEncoder.encode("123456"));
			user.setEnabled(true);
			HashSet<Role> roles = new HashSet<>();
			roles.add(roleRepository.findRoleByRoleName("ROLE_MEMBER"));
			user.setRoles(roles);
			userRepository.save(user);
		}
	}
}
