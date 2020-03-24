package com.blitzware.gestaoAPI.dto;

import lombok.Data;

@Data
public class ContactCreationResponseDTO {
	private String email;
	private String phoneNumber;
	private String name;
}
