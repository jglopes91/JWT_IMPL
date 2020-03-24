package com.blitzware.gestaoAPI.dto;

import lombok.Data;

@Data
public class ContactCreationRequestDTO {
	private String name;
	private String email;
	private String phoneNumber;
}
