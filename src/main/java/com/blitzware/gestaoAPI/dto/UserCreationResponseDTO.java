package com.blitzware.gestaoAPI.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UserCreationResponseDTO {
	private String email;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date createdAt;
}
