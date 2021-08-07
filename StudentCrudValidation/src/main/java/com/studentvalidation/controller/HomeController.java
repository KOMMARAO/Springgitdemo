package com.studentvalidation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import com.studentvalidation.entity.Student;
import com.studentvalidation.exception.StudentNotFoundException;
import com.studentvalidation.service.StudentService;

@RestController
@RequestMapping("/")
public class HomeController {

	@Autowired
	StudentService service; // injecting the bean for service layer class using autowired annotation

	@PostMapping("/addstudent") // url to add student is -> http://localhost:8081/addstudent
	public ResponseEntity<String> addingUrl(@RequestBody Student addition) {
		service.addStudent(addition); // calling the serive layer class object
		return new ResponseEntity<>("Student details added successfully", new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/updatestudent") // put method to url to update the details of student
	public ResponseEntity<String> updatingUrl(@RequestBody Student updation) {
		service.updateStudent(updation);
		return new ResponseEntity<>("Student details updated successfully", new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	// @PathVariable is used to assign variables to the id variable from the url
	public ResponseEntity<String> removingUrl(@PathVariable("id") int id) {
		service.removeStudent(id);
		return new ResponseEntity<>("Student details deleted successfully", new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/getstudent/{id}") // url to get the student based on id
	// @PathVariable is used to assign variables to the id variable from the url
	public Optional<Student> gettingByIdUrl(@PathVariable("id") int id) throws StudentNotFoundException {
		Optional<Student> student = service.getStudentById(id);
		if (student.isPresent()) {
			return student;
		} else
			throw new StudentNotFoundException("Student with that id is not present");
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Student>> gettingAllUrl() {
		List<Student> students = service.getAllStudents();
		return new ResponseEntity<>(students, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/bymarks/{low}/{high}")
	public ResponseEntity<List<Student>> byMarks(@PathVariable("low") double lowMarks,
			@PathVariable("high") double highMarks) {
		List<Student> stu = service.getByMarks(lowMarks, highMarks);
		return new ResponseEntity<>(stu, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/byname/{id}")
	public ResponseEntity<List<Student>> byName(@PathVariable("id") String name) {
		List<Student> stu = service.getByName(name);
		return new ResponseEntity<>(stu, new HttpHeaders(), HttpStatus.OK);
	}
}
