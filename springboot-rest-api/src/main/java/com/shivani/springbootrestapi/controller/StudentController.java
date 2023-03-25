package com.shivani.springbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivani.springbootrestapi.bean.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/default")
	public Student getStudent() {
		return new Student(1, "ABC", "XYZ");
	}

}
