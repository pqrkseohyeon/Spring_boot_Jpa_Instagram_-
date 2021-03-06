package com.cos.instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.instagram.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);
}
