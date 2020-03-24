package com.blitzware.gestaoAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.blitzware.gestaoAPI.model.RoleModel;

public interface RoleRepository extends CrudRepository<RoleModel, Long> {
	@Query(value = "SELECT * FROM tb_roles WHERE str_role_name LIKE :roleName", nativeQuery = true)
	public Optional<RoleModel> findByRoleName(@Param("roleName") String roleName);
}