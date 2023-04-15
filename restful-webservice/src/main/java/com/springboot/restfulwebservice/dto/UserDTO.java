package com.springboot.restfulwebservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
	
	private Integer id;
	@NotEmpty(message = "User name should not be empty")
	private String name;
	@NotEmpty
	@Email(message = "Enter valid email address")
	private String emailAddress;
}
