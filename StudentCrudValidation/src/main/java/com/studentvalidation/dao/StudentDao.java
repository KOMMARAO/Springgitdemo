package com.studentvalidation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentvalidation.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

	@Query("select s from Student s where marks between ?1 and ?2")
	public List<Student> getByMarks(double lowMarks, double highMarks);

	@Query("select s from Student s where s.fname = ?1")
	public List<Student> getByName(String name);

}
