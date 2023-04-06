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

import com.springboot.restfulwebservice.entity.User;
import com.springboot.restfulwebservice.service.UserService;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Integer id) {
		User user = userService.getUser(id);
		HttpStatus httpStatus = getHttpStatusCode(user);
		return new ResponseEntity<User>(user, httpStatus);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAll(){
		List<User> users = userService.getAll();
		HttpStatus httpStatus = getHttpStatusCode(users);
		return new ResponseEntity<List<User>>(users, httpStatus);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer userId, @RequestBody User user) {
		user.setId(userId);
		User updatedUser = userService.updateUser(user);
		HttpStatus httpStatus = getHttpStatusCode(updatedUser);
		return new ResponseEntity<User>(updatedUser, httpStatus);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<User> deleteUser(@PathVariable Integer id){
		User deletedUser = userService.deleteUser(id);
		return new ResponseEntity<User>(deletedUser,getHttpStatusCode(deletedUser));
	}

	private HttpStatus getHttpStatusCode(Object obj) {
		return obj != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	}
}
