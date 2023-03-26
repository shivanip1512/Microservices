package com.shivani.springbootrestapi.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shivani.springbootrestapi.bean.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

//	private List<Student> students = List.of(new Student(1, "A", "B"), new Student(2, "C", "D"), new Student(3, "E", "F"));
	private List<Student> students = new ArrayList<>() {
		{
			add(new Student(1, "A", "B"));
			add(new Student(2, "C", "D"));
			add(new Student(3, "E", "F"));
		}
	};

	@GetMapping("/default")
	public ResponseEntity<Student> getStudent() {
//		return new ResponseEntity<Student>(new Student(1, "ABC", "XYZ"), HttpStatus.OK);
		return ResponseEntity.ok(new Student(1, "ABC", "XYZ"));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Student>> getStudents() {
		return ResponseEntity.ok().body(students);
	}

	// spring-boot rest endpoint with path-variable
	// http://localhost:8080/student/1
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id) {
		return ResponseEntity.ok(getStudentById(id));
	}

	private Student getStudentById(int id) {
		for (Student student : students) {
			if (student.getId() == id)
				return student;
		}
		return null;
	}

	private Student getStudentByIdAndFName(int id, String fname) {
		for (Student student : students) {
			if (student.getId() == id && student.getFirstName().equals(fname))
				return student;
		}
		return null;
	}

	// rest endpoint with request param
	// http://localhost:8080/student/query-arg?id=1&fname=Joe
	@GetMapping("/query-arg")
	public ResponseEntity<Student> studentReqParam(@RequestParam int id, @RequestParam("fname") String firstname) {
		return ResponseEntity.ok(getStudentByIdAndFName(id, firstname));
	}

	@PostMapping("/add")
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student s) {
		students.add(s);
		return new ResponseEntity<Student>(s, HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student s) {
		Student student = getStudentById(id);
		student.setFirstName(s.getFirstName());
		student.setLastName(s.getLastName());
		return ResponseEntity.ok(student);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		Student student = getStudentById(id);
		boolean removed = students.remove(student);
		return removed ? ResponseEntity.ok("Student deleted successfully."): new ResponseEntity<String>("Student deletion failed.", HttpStatus.BAD_REQUEST);
	}
}
