package com.springboot.restfulwebservice.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.springboot.restfulwebservice.dto.UserDTO;
import com.springboot.restfulwebservice.entity.User;
import com.springboot.restfulwebservice.exception.ErrorDetails;
import com.springboot.restfulwebservice.exception.ResourceNotFoundException;
import com.springboot.restfulwebservice.service.UserService;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		return new ResponseEntity<UserDTO>(userService.createUser(userDTO), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {
		UserDTO userDTO = userService.getUser(id);
//		HttpStatus httpStatus = getHttpStatusCode(userDTO);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> getAll() {
		List<UserDTO> userDtos = userService.getAll();
		HttpStatus httpStatus = getHttpStatusCode(userDtos);
		return new ResponseEntity<List<UserDTO>>(userDtos, httpStatus);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Integer userId, @RequestBody UserDTO userDto) {
		userDto.setId(userId);
		UserDTO updatedUserDto = userService.updateUser(userDto);
		HttpStatus httpStatus = getHttpStatusCode(updatedUserDto);
		return new ResponseEntity<UserDTO>(updatedUserDto, httpStatus);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable Integer id) {
		UserDTO deletedUserDto = userService.deleteUser(id);
		return new ResponseEntity<UserDTO>(deletedUserDto, getHttpStatusCode(deletedUserDto));
	}

	private HttpStatus getHttpStatusCode(Object obj) {
		return obj != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	}
	
	/*
	 * @ExceptionHandler(ResourceNotFoundException.class) public
	 * ResponseEntity<ErrorDetails>
	 * handleResourceNotFoundException(ResourceNotFoundException exception,
	 * WebRequest webRequest){ ErrorDetails errorDetails = new
	 * ErrorDetails(LocalDateTime.now(), exception.getMessage(),
	 * webRequest.getDescription(false), "USER_NOT_FOUND"); return new
	 * ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND); }
	 */
}
