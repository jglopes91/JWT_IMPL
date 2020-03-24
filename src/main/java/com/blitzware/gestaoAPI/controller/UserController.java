package com.blitzware.gestaoAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blitzware.gestaoAPI.dto.UserCreationRequestDTO;
import com.blitzware.gestaoAPI.dto.UserCreationResponseDTO;
import com.blitzware.gestaoAPI.service.UserService;

@RestController
@Controller
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/")
	public ResponseEntity<UserCreationResponseDTO> newUser(@RequestBody UserCreationRequestDTO dto) {
		return new ResponseEntity<>(userService.createNewUser(dto), HttpStatus.CREATED);
	}
}
