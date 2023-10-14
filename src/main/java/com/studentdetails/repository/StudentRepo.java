package com.studentdetails.repository;

import java.util.List;

import com.studentdetails.entity.Student;

public interface StudentRepo {

	List<Student> findAll();
	Student findById(int id);
	Student deleteById(int id);
	Student save(Student student);
}
