package com.springboot.restfulwebservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.restfulwebservice.dto.UserDTO;
import com.springboot.restfulwebservice.entity.User;
import com.springboot.restfulwebservice.exception.ResourceAlreadyExistException;
import com.springboot.restfulwebservice.exception.ResourceNotFoundException;
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
		
		Optional<User> userByEmail = userRepository.findByEmail(userDto.getEmailAddress());
		
		if(userByEmail.isPresent()) {
			throw new ResourceAlreadyExistException("Email Already Exists for User");
		}
		
		
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
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		// return optionalUser.isPresent() ? UserMapper.mapToUserDto(optionalUser.get()) : null;
		// return optionalUser.isPresent() ? modelMapper.map(optionalUser.get(), UserDTO.class) : null;
		return AutoUserMapper.MAPPER.maptoUserDTO(user);
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
		User repoUser = userRepository.findById(user.getId()).orElseThrow(()->new ResourceNotFoundException("User", "id", user.getId()));
		repoUser.setName(user.getName());
		repoUser.setEmail(user.getEmailAddress());
		User savedUser = userRepository.save(repoUser);
		// return UserMapper.mapToUserDto(savedUser);
		// return modelMapper.map(savedUser, UserDTO.class);
		return AutoUserMapper.MAPPER.maptoUserDTO(savedUser);
	}

	@Override
	public UserDTO deleteUser(Integer userId) {
		UserDTO userDto = getUser(userId);
		userRepository.deleteById(userId);
		return userDto;
	}

}
