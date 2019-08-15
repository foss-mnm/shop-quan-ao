package com.opensource.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.opensource.dto.UserDto;
import com.opensource.model.Cart;
import com.opensource.model.Role;
import com.opensource.model.User;
import com.opensource.repository.CartRepository;
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
	
	@Autowired
	private CartRepository cartRepo;

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
		
		Cart userCart = new Cart();
		userCart.setUser(user);
		cartRepo.save(userCart);
		
	}

	public void updateAdminLoginInfo(UserDto userDto) {
		long adminId = userRepository.getUserIdWithRoleAdmin();
		userRepository.updateAdminLoginInfo(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword()),
				adminId);

	}

	
	public User loadUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}

	public List<User> customer(){
		return userRepository.customer();
	}
	
//	public List<?> infoPayment(){
//		return userRepository.infoPayment();
//	}
}
