package com.blitzware.gestaoAPI.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {
	private String token;
	private String role;

	public LoginResponseDTO(String token, String role) {
		this.token = token;
		this.role = role;
	}
}
