package com.blitzware.gestaoAPI.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blitzware.gestaoAPI.model.UserModel;
import com.blitzware.gestaoAPI.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserModel user = userRepository.findByEmail(email).orElse(null);
		if (user == null) {
			throw new UsernameNotFoundException("Usuario nao encontrado");
		}

		return UserPrincipal.create(user);
	}

	@Transactional
	public UserDetails findById(Long id) {
		UserModel user = userRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado com o id : " + id));
		return UserPrincipal.create(user);
	}
}