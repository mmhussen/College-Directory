package com.app.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.college.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Student getStudentByName(String studentName,Long id);

}
