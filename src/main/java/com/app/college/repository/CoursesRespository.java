package com.app.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.college.model.Courses;

public interface CoursesRespository extends JpaRepository<Courses, Long>{
	

}
