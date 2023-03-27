package com.springboot.restfulwebservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restfulwebservice.entity.User;
import com.springboot.restfulwebservice.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

	private UserService service;

	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(service.createUser(user), HttpStatus.CREATED);
	}
}
