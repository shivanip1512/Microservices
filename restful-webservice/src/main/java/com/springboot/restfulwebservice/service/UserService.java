package com.springboot.restfulwebservice.service;

import java.util.List;

import com.springboot.restfulwebservice.dto.UserDTO;

public interface UserService {
	UserDTO createUser(UserDTO user);
	
	UserDTO getUser(Integer userId);
	
	List<UserDTO> getAll();
	
	UserDTO updateUser(UserDTO user);
	
	UserDTO deleteUser(Integer userId);
}
