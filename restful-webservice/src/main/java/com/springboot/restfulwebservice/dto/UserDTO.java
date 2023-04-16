package com.springboot.restfulwebservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Schema(description = "UserDto Model information")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
	
	@Schema(description = "User unique identifier")
	private Integer id;
	
	@Schema(description = "User full name")
	@NotEmpty(message = "User name should not be empty")
	private String name;
	
	@Schema(description = "User email address")
	@NotEmpty
	@Email(message = "Enter valid email address")
	private String emailAddress;
}
