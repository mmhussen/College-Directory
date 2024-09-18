package com.app.college.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.college.model.Faculty;
import com.app.college.model.Student;
import com.app.college.repository.StudentRepository;

public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student getStudentByName(String name,Long Id) {
		return studentRepository.getStudentByName(name, Id);
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	public Student updateStudent(Student existingStudent) {
		return studentRepository.save(existingStudent);
	}
	
}
