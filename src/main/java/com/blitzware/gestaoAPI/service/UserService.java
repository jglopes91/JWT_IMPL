package com.blitzware.gestaoAPI.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blitzware.gestaoAPI.config.APIConstraints;
import com.blitzware.gestaoAPI.dto.UserCreationRequestDTO;
import com.blitzware.gestaoAPI.dto.UserCreationResponseDTO;
import com.blitzware.gestaoAPI.model.UserModel;
import com.blitzware.gestaoAPI.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleService roleService;
	
	public UserCreationResponseDTO createNewUser(UserCreationRequestDTO dto) {
		UserModel user = saveUser(dto);
		return fillUserResponseDTO(user);
	}

	private UserCreationResponseDTO fillUserResponseDTO(UserModel user) {
		UserCreationResponseDTO response = new UserCreationResponseDTO();
		response.setEmail(user.getEmail());
		response.setCreatedAt(user.getCreatedAt());
		return response;
	}
	@Transactional
	private UserModel saveUser(UserCreationRequestDTO dto) {
		UserModel user = new UserModel();
		user.setCreatedAt(new Date());
		user.setPassword(dto.getPassword());
		user.setEnable(true);
		user.setRole(roleService.getByRoleName(APIConstraints.ROLE_USER));
		user.setFullName(dto.getUsername());
		user.setEmail(dto.getEmail());
		userRepository.save(user);
		return user;
	}
}
