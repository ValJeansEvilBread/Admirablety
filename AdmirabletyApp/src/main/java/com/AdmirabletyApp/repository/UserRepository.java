package com.AdmirabletyApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AdmirabletyApp.model.User;


@Repository
public interface UserRepository extends JpaRepository <User, Long> {
	User findByUsername(String username);

}