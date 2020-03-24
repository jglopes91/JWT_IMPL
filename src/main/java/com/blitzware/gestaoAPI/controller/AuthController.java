package com.blitzware.gestaoAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blitzware.gestaoAPI.dto.LoginRequestDTO;
import com.blitzware.gestaoAPI.dto.LoginResponseDTO;
import com.blitzware.gestaoAPI.security.JwtTokenProvider;

@RestController
@Controller
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtTokenProvider tokenProvider;

	@PostMapping("/")
	public ResponseEntity<LoginResponseDTO> doLogin(@RequestBody LoginRequestDTO dto) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<>(
				new LoginResponseDTO(tokenProvider.generateToken(authentication),
						SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString()),
				HttpStatus.OK);
	}
}
