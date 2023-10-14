package com.studentdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentdetails.entity.Student;
import com.studentdetails.service.StudentSer;


@RestController
@RequestMapping("/student")
public class StudentController {

	private StudentSer studentSer;
	Student student = new Student();

	@Autowired
	public StudentController(StudentSer studentSer) {
		this.studentSer = studentSer;
	}
	
	@GetMapping("/get")
	public List<Student> findAll(){
		return studentSer.findAll();
	}

	@GetMapping("/get/{id}")
	public Student findById(@PathVariable int id){
		return studentSer.findById(id);
	}
	
	@PutMapping("/put")
	public Student update(@RequestBody Student student) {
		return studentSer.save(student);
	}
	@PostMapping("/post")
	public Student save(@RequestBody Student student) {
		student.setId(0);
		return studentSer.save(student);
	}

	@DeleteMapping("/delete/{id}")
	public Student deleteById(@PathVariable int id) {
		 return studentSer.deleteById(id);
	}
}
