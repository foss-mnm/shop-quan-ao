package com.opensource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensource.dto.UserInfoDto;
import com.opensource.model.User;
import com.opensource.model.UserInfo;
import com.opensource.repository.UserInfoRepository;
import com.opensource.repository.UserRepository;

@Service
public class UserInfoService {
	
	@Autowired
	private  UserInfoRepository userInfoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void updateUserInfoAdmin(UserInfoDto userInfoDto) {
		
		long adminId = userRepository.getUserIdWithRoleAdmin();
		User user = userRepository.findById(adminId).get();
		//Kiem tra xem admin nay co thong tin trong bang user_info hay chua
		boolean checkExists = userInfoRepository.existsById(adminId);
		
		if(checkExists) {
			userInfoRepository.updateUserInfo(userInfoDto.getFisrtName(), userInfoDto.getLastName(), userInfoDto.getEmail(), userInfoDto.getPhoneNumber(), adminId);
		}else {
			UserInfo userInfo = new UserInfo(adminId,userInfoDto.getLastName(),userInfoDto.getFisrtName(),userInfoDto.getEmail(),userInfoDto.getPhoneNumber(),"",user);
			userInfoRepository.save(userInfo);
		}
		
	}
	
	public UserInfoDto getAdminInfo() {
		long adminId = userRepository.getUserIdWithRoleAdmin();
		UserInfo userInfo = userInfoRepository.getOne(adminId);
		return new UserInfoDto(userInfo);
	}
	
	public void save(UserInfo u) {
		
	}
}
