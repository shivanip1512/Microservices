package com.springboot.restfulwebservice.service;

import java.util.List;

import com.springboot.restfulwebservice.entity.User;

public interface UserService {
	User createUser(User user);
	
	User getUser(Integer userId);
	
	List<User> getAll();
	
	User updateUser(User user);
	
	User deleteUser(Integer userId);
}
