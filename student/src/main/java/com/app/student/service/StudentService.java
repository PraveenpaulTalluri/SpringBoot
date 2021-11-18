package com.app.student.service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.student.exception.ResourceNotFoundException;
import com.app.student.controller.StudentController;
import com.app.student.model.Student;
import com.app.student.repository.StudentRepository;

@Service
public class StudentService {
	

	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private StudentRepository studentrepository;

	public List<Student> getAllStudents() 
	{
		return studentrepository.findAll();
	}
	
	public Student findStudentByAdmissionId(Integer admission_id)
	{
		
		Student student=null;
		try {
			student = studentrepository.findById(admission_id).orElseThrow(() -> new ResourceNotFoundException("student not found for this id :: " + admission_id));
		} catch (ResourceNotFoundException e) {
			log.error("Error while fetching Student for admissionId "+admission_id+ " :: " +e.getMessage());
		}
		return student;
	}
}
