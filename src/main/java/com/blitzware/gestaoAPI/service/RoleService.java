package com.blitzware.gestaoAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blitzware.gestaoAPI.model.RoleModel;
import com.blitzware.gestaoAPI.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;

	public RoleModel getByRoleName(String roleName) {
		return roleRepository.findByRoleName(roleName).orElseThrow(null);
	}
}
