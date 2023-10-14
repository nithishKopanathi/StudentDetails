package com.studentdetails.service;

import java.util.List;

import com.studentdetails.entity.Student;

public interface StudentSer {

	List<Student> findAll();
	Student findById(int id);
	Student deleteById(int id);
	Student save(Student student);
}
