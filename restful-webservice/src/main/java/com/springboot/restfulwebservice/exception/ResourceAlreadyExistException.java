package com.springboot.restfulwebservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceAlreadyExistException extends RuntimeException {
	
	private String message;
	
	public ResourceAlreadyExistException(String message) {
		super(message);
	}

}
