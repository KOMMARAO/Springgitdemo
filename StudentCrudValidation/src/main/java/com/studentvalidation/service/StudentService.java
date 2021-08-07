package com.studentvalidation.service;

import java.util.List;
import java.util.Optional;

import com.studentvalidation.entity.Student;

public interface StudentService {

	public abstract void addStudent(Student student);

	public abstract void updateStudent(Student student);

	public abstract void removeStudent(int id);

	public abstract Optional<Student> getStudentById(int id);

	public abstract List<Student> getAllStudents();

	public abstract List<Student> getByMarks(double lowMarks, double highMarks);

	public abstract List<Student> getByName(String name);
}
