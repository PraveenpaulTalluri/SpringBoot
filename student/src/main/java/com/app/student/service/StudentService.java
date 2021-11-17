package com.app.student.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.student.model.Student;
import com.app.student.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentrepository;

	public List<Student> getAllStudents() 
	{
		return studentrepository.findAll();
	}
}
