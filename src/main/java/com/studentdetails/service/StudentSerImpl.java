package com.studentdetails.service;

import java.util.List;
import com.studentdetails.entity.Student;
import com.studentdetails.repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentSerImpl implements StudentSer {

	private StudentRepo studentRepo;

	@Autowired
	public StudentSerImpl(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
		
	}

	@Override
	public Student findById(int id) {
		return studentRepo.findById(id);
	}

	@Transactional
	@Override
	public Student deleteById(int id) {
       return  studentRepo.deleteById(id);		
	}


	
    @Transactional
	@Override
	public Student save(Student student) {
       Student result  =studentRepo.save(student);	
       return result;
	}
}
