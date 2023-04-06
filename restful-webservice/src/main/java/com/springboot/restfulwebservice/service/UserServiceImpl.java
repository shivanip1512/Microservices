package com.springboot.restfulwebservice.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public User getUser(Integer userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		User existingUser = getUser(user.getId());
		if (existingUser != null) {
			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			userRepository.save(existingUser);
		}
		return existingUser;
	}

	@Override
	public User deleteUser(Integer userId) {
		User user = getUser(userId);
		if (user != null)
			userRepository.deleteById(userId);
		return user;
	}

}
