package com.springboot.restfulwebservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.restfulwebservice.dto.UserDTO;
import com.springboot.restfulwebservice.entity.User;
import com.springboot.restfulwebservice.mapper.AutoUserMapper;
import com.springboot.restfulwebservice.mapper.UserMapper;
import com.springboot.restfulwebservice.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private ModelMapper modelMapper;

	@Override
	public UserDTO createUser(UserDTO userDto) {
		System.out.println("userDto : "+userDto);
		// User user = UserMapper.mapToUser(userDto);
		// User user = modelMapper.map(userDto, User.class);
		User user = AutoUserMapper.MAPPER.mapToUser(userDto);

		User savedUser = userRepository.save(user);

		// return UserMapper.mapToUserDto(savedUser);
		// return modelMapper.map(savedUser, UserDTO.class);
		return AutoUserMapper.MAPPER.maptoUserDTO(savedUser);
	}

	@Override
	public UserDTO getUser(Integer userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		// return optionalUser.isPresent() ? UserMapper.mapToUserDto(optionalUser.get()) : null;
		// return optionalUser.isPresent() ? modelMapper.map(optionalUser.get(), UserDTO.class) : null;
		return optionalUser.isPresent() ? AutoUserMapper.MAPPER.maptoUserDTO(optionalUser.get()) : null;
	}

	@Override
	public List<UserDTO> getAll() {
		List<User> users = userRepository.findAll();
		// return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
		// return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
		return users.stream().map(user -> AutoUserMapper.MAPPER.maptoUserDTO(user)).collect(Collectors.toList());
	}

	@Override
	public UserDTO updateUser(UserDTO user) {
		UserDTO existingUserDto = getUser(user.getId());
		if (existingUserDto != null) {
			existingUserDto.setName(user.getName());
			existingUserDto.setEmailAddress(user.getEmailAddress());
			// userRepository.save(UserMapper.mapToUser(existingUserDto));
			// userRepository.save(modelMapper.map(existingUserDto, User.class));
			userRepository.save(AutoUserMapper.MAPPER.mapToUser(existingUserDto));
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
