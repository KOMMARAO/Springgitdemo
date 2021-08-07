package com.studentvalidation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student {

	@Id
	@GeneratedValue
	@Column(length = 10)
	private int id;
	@Column(length = 10)
	@NotNull
	@NotBlank
	@Size(min = 3, message = "first names must be greater than 3 characters")
	private String fname;
	@Column(length = 10)
	@NotNull
	@NotBlank
	@Size(min = 3, message = "last name must be greater than 3 characters")
	private String lname;
	@Column(length = 10)
	private String location;
	@Column(length = 10)
	private String education;
	@Column(length = 10)
	@Min(value = 36, message = "marks must be greater than 36")
	private double marks;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", location=" + location + ", education="
				+ education + ", marks=" + marks + "]";
	}

}
