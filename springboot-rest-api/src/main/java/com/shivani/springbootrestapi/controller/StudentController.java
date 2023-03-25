package com.shivani.springbootrestapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/students")
	public List<Student> getStudents() {
		return List.of(new Student(1, "A", "B"), new Student(2, "C", "D"), new Student(3, "E", "F"));
	}
	
	//spring-boot rest endpoint with path-variable
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable int id) {
		return new Student(id, "Joe", "Smith");
	}
}
