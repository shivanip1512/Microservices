package com.springboot.restfulwebservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.springboot.restfulwebservice.dto.UserDTO;
import com.springboot.restfulwebservice.entity.User;

@Mapper
public interface AutoUserMapper {
	
	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

	@Mapping(source = "email", target = "emailAddress")
	UserDTO maptoUserDTO(User user);
	
	@Mapping(target = "email", source = "emailAddress")
	User mapToUser(UserDTO userDTO);
	
}
