package com.wlopera.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wlopera.jwt.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByName(String userName);
}