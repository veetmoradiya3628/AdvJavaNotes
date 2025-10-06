package com.example.spring_jpa_demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring_jpa_demo.entity.User;
import com.example.spring_jpa_demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
