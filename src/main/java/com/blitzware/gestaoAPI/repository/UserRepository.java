package com.blitzware.gestaoAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blitzware.gestaoAPI.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
	@Query(value = "SELECT * FROM tb_user WHERE str_email LIKE :email", nativeQuery = true)
	Optional<UserModel> findByEmail(@Param("email") String email);
}
