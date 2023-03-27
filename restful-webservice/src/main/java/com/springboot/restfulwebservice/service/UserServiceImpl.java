package com.springboot.restfulwebservice.service;

import org.springframework.stereotype.Service;

import com.springboot.restfulwebservice.entity.User;
import com.springboot.restfulwebservice.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

}
