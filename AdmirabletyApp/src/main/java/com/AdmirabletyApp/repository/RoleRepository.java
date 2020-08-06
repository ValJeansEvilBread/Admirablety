package com.AdmirabletyApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AdmirabletyApp.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
}
