package com.springboot.restfulwebservice.mapper;

import com.springboot.restfulwebservice.dto.UserDTO;
import com.springboot.restfulwebservice.entity.User;

public class UserMapper {

	/**
	 * Converts User JPA to UserDto
	 * @param user
	 * @return returns userDto
	 */
	public static UserDTO mapToUserDto(User user) {
		return new UserDTO(user.getId(), user.getName(), user.getEmail());
	}

	/**
	 * Converts UserDto to User JPA
	 * @param userDTO
	 * @return returns user
	 */
	public static User mapToUser(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmailAddress());
	}
}
