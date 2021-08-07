package com.studentvalidation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentvalidation.dao.StudentDao;
import com.studentvalidation.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;

	@Override
	public void addStudent(Student student) {
		// calling the dao layer to add the student details to the database
		dao.save(student);
	}

	@Override
	public void updateStudent(Student student) {
		// calling the dao layer method to update the details
		dao.save(student);
	}

	@Override
	public void removeStudent(int id) {
		// calling dao layer's remove method to remove the student details by id
		dao.deleteById(id);
	}

	@Override
	public Optional<Student> getStudentById(int id) {
		// calling dao layer's method to get the student based on the id
		return dao.findById(id);
	}

	@Override
	public List<Student> getAllStudents() {
		// getting the list of all students in the database
		return dao.findAll();
	}

	@Override
	public List<Student> getByMarks(double lowMarks, double highMarks) {
		
		return dao.getByMarks(lowMarks, highMarks);
	}

	@Override
	public List<Student> getByName(String name) {
		return dao.getByName(name);
	}

}
