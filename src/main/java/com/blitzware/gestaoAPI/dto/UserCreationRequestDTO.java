package com.blitzware.gestaoAPI.dto;

import lombok.Data;

@Data
public class UserCreationRequestDTO {
	private String username;
	private String password;
	private String email;
}
