package com.app.student.serviceTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.app.student.model.Student;
import com.app.student.repository.StudentRepository;
import com.app.student.service.StudentService;


@SpringBootTest
class Springbootrest1ApplicationTests {
	@Autowired
	private StudentService studentService;

	@MockBean
	private StudentRepository studentRepository;

	@Test
	public void getStudentsList()throws Exception {

		List<Student> studentsList=new ArrayList<>();
		studentsList.add(new Student(1,"abc","Class-IV A","RJY"));
		studentsList.add(new Student(2,"bcd","Class-IV B","vjy"));
		studentsList.add(new Student(3,"cde","Class-IV C","VZG"));
		
		when(studentRepository.findAll()).thenReturn(studentsList);
		
		List<Student> studentsListResult=studentService.getAllStudents();
		assertEquals(studentsList.size(),studentsListResult.size());
	}

}
