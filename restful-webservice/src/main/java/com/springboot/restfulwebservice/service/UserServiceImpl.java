package com.springboot.restfulwebservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.restfulwebservice.dto.UserDTO;
import com.springboot.restfulwebservice.entity.User;
import com.springboot.restfulwebservice.mapper.UserMapper;
import com.springboot.restfulwebservice.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;

	@Override
	public UserDTO createUser(UserDTO userDto) {
		User user = UserMapper.mapToUser(userDto);
		User savedUser = userRepository.save(user);
		return UserMapper.mapToUserDto(savedUser);
	}

	@Override
	public UserDTO getUser(Integer userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		return optionalUser.isPresent() ? UserMapper.mapToUserDto(optionalUser.get()) : null;
	}

	@Override
	public List<UserDTO> getAll() {
		List<User> users = userRepository.findAll();
		return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
	}

	@Override
	public UserDTO updateUser(UserDTO user) {
		UserDTO existingUserDto = getUser(user.getId());
		if (existingUserDto != null) {
			existingUserDto.setName(user.getName());
			existingUserDto.setEmail(user.getEmail());
			userRepository.save(UserMapper.mapToUser(existingUserDto));
		}
		return existingUserDto;
	}

	@Override
	public UserDTO deleteUser(Integer userId) {
		UserDTO userDto = getUser(userId);
		if (userDto != null)
			userRepository.deleteById(userId);
		return userDto;
	}

}
