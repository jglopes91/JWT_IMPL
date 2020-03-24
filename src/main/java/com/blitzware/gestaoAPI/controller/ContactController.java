package com.blitzware.gestaoAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blitzware.gestaoAPI.dto.ContactCreationRequestDTO;
import com.blitzware.gestaoAPI.dto.ContactCreationResponseDTO;
import com.blitzware.gestaoAPI.dto.ContactListResponseDTO;
import com.blitzware.gestaoAPI.service.ContactService;

@RestController
@Controller
@RequestMapping(value = "/api/contact", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ContactController {
	@Autowired
	ContactService contactService;

	@PostMapping("/")
	public ResponseEntity<ContactCreationResponseDTO> newContact(@RequestBody ContactCreationRequestDTO dto) {
		return new ResponseEntity<>(contactService.createNewContact(dto), HttpStatus.CREATED);

	}

	@GetMapping("/")
	public ResponseEntity<ContactListResponseDTO> retriveMyContacts() {
		return new ResponseEntity<>(contactService.getAllMyContacts(), HttpStatus.OK);
	}
}
