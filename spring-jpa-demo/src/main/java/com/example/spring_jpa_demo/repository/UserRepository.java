package com.example.spring_jpa_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_jpa_demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}
