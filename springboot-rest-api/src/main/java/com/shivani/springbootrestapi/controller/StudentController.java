package com.shivani.springbootrestapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	// spring-boot rest endpoint with path-variable
	// http://localhost:8080/student/1
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable int id) {
		return new Student(id, "Joe", "Smith");
	}

	// rest endpoint with request param
	// http://localhost:8080/student/query-arg?id=1&fname=Joe
	@GetMapping("/query-arg")
	public Student studentReqParam(@RequestParam int id, @RequestParam("fname") String firstname) {
		return new Student(id, firstname, "Watson");
	}

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student s) {
		System.out.println(s);
		return s;
	}

	@PutMapping("{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student s) {
		return new Student(id, s.getFirstName(), s.getLastName());
	}
}
