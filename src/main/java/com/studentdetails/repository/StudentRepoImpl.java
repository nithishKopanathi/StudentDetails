package com.studentdetails.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studentdetails.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentRepoImpl implements StudentRepo{
    
	//EntityManager for db operations
    private EntityManager entityManager;
    @Autowired
	public StudentRepoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> result = entityManager.createQuery("from Student" , Student.class);
		return result.getResultList();
	}

	@Override
	public Student findById(int id) {
        Student student= entityManager.find(Student.class, id)	;

		return student;
	}

	@Override
	public Student deleteById(int id) {
        Student student= entityManager.find(Student.class, id)	;
         entityManager.remove(student);
         return student;
	}

	@Override
	public Student save(Student student) {
      Student result=entityManager.merge(student)	;	
      return result;
	}
}
