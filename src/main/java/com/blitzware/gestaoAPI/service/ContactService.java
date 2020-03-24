package com.blitzware.gestaoAPI.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blitzware.gestaoAPI.dto.ContactCreationRequestDTO;
import com.blitzware.gestaoAPI.dto.ContactCreationResponseDTO;
import com.blitzware.gestaoAPI.model.ContactModel;
import com.blitzware.gestaoAPI.repository.ContactRepository;

@Service
public class ContactService {
	@Autowired
	ContactRepository contactRepository;

	public ContactCreationResponseDTO createNewContact(ContactCreationRequestDTO dto) {
		return fillContactListResponseDTO(createAndSaveContact(dto));
	}

	private ContactModel createAndSaveContact(ContactCreationRequestDTO dto) {
		ContactModel contact = new ContactModel();
		contact.setCreatedAt(new Date());
		contact.setEmail(dto.getEmail());
		contact.setName(dto.getName());
		contact.setPhoneNumber(dto.getPhoneNumber());
		return contactRepository.save(contact);
	}

	private ContactCreationResponseDTO fillContactListResponseDTO(ContactModel contact) {
		ContactCreationResponseDTO dto = new ContactCreationResponseDTO();
		dto.setEmail(contact.getEmail());
		dto.setName(contact.getName());
		dto.setPhoneNumber(contact.getPhoneNumber());
		return dto;
	}

}
