package com.app.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.student.model.Student;
import com.app.student.service.StudentService;

@RestController
@RequestMapping("/restApi")
public class StudentController {
	@Autowired
	StudentService studentservice;
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents()
	{
		return ResponseEntity.ok().body(studentservice.getAllStudents());
	}
}
