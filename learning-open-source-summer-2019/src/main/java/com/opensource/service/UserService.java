package com.opensource.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.opensource.dto.UserDto;
import com.opensource.model.Role;
import com.opensource.model.User;
import com.opensource.model.UserInfo;
import com.opensource.repository.RoleRepository;
import com.opensource.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public boolean checkUsername(String username) {
		if (userRepository.findUserByUsername(username) == null)
			return true;
		return false;
	}

	public void addUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		user.setEnabled(true);
		HashSet<Role> roles = new HashSet<>();
		roles.add(roleRepository.findRoleByRoleName("ROLE_MEMBER"));
		user.setRoles(roles);
		userRepository.save(user);
	}

	public void updateAdminLoginInfo(UserDto userDto) {
		long adminId = userRepository.getUserIdWithRoleAdmin();
		userRepository.updateAdminLoginInfo(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()),
				adminId);

	}

	public void save(UserInfo uf) {
		// TODO Auto-generated method stub
		
	}


}
