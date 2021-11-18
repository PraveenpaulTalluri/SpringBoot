package com.app.student.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.student.model.Student;
import com.app.student.service.StudentService;

@RestController
@RequestMapping("/restApi")
public class StudentController {
	

	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentService studentservice;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents()
	{
		return ResponseEntity.ok().body(studentservice.getAllStudents());
	}
	
	@GetMapping("/orders/{admission_id}")
	public ResponseEntity<Student> getStudentByAdmissionId(@PathVariable(value = "admission_id") Integer admission_id)
	 {
		Student studentObj= null;
		log.info("Student admissionId is "+admission_id);
		studentObj= studentservice.findStudentByAdmissionId(admission_id);
		if(studentObj!=null) {
			return ResponseEntity.ok().body(studentObj);
		}else {
			return new ResponseEntity<Student>(studentObj, HttpStatus.NOT_FOUND);
		}
		
	}
	
	
}
