package com.blitzware.gestaoAPI.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.blitzware.gestaoAPI.model.ContactModel;

public interface ContactRepository extends PagingAndSortingRepository<ContactModel, Long> {
	@Query(value = "SELECT * FROM tb_contact WHERE user.id = (SELECT id FROM tb_user WHERE str_email like :email)", nativeQuery = true)
	public List<ContactModel> findAllContactsPageable(@Param("email") String email, Pageable pageable);
}
