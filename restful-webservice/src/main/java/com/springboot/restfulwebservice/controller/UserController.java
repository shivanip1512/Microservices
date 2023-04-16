package com.springboot.restfulwebservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restfulwebservice.dto.UserDTO;
import com.springboot.restfulwebservice.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Tag(name = "CRUD REST API for User Resource")
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

	private UserService userService;

	@Operation(
			summary = "Create User",
			description = "Create User REST API is used to save user in database")
	@ApiResponse(
			responseCode = "201",
			description = "HTTP Status 201 Created")
	@PostMapping("/save")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
		return new ResponseEntity<UserDTO>(userService.createUser(userDTO), HttpStatus.CREATED);
	}

	@Operation(
			summary = "Get User by ID",
			description = "Get User REST API is used to retreive user based on id")
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 OK")
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {
		UserDTO userDTO = userService.getUser(id);
//		HttpStatus httpStatus = getHttpStatusCode(userDTO);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

	@Operation(
			summary = "Get all users",
			description = "Get all user REST API is used to retreive all users from database")
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 OK")
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAll() {
		List<UserDTO> userDtos = userService.getAll();
		return new ResponseEntity<List<UserDTO>>(userDtos, HttpStatus.OK);
	}

	@Operation(
			summary = "Update User by ID",
			description = "Update User REST API is used to update user based on id")
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 OK")
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Integer userId, @Valid @RequestBody UserDTO userDto) {
		userDto.setId(userId);
		UserDTO updatedUserDto = userService.updateUser(userDto);
		return new ResponseEntity<UserDTO>(updatedUserDto, HttpStatus.OK);
	}

	@Operation(
			summary = "Delete User by ID",
			description = "Delete User REST API is used to delete user based on id")
	@ApiResponse(
			responseCode = "200",
			description = "HTTP Status 200 OK")
	@DeleteMapping("{id}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable Integer id) {
		UserDTO deletedUserDto = userService.deleteUser(id);
		return new ResponseEntity<UserDTO>(deletedUserDto, HttpStatus.OK);
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
