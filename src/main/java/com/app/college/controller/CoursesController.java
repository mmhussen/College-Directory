package com.app.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.college.model.Courses;
import com.app.college.repository.CoursesRespository;

@RestController
@RequestMapping("api/courses")
public class CoursesController {
	
	@Autowired
	CoursesRespository coursesRespository;
	
	@PostMapping("addcourses")
	public void createCourses(@RequestBody Courses courses) {
		coursesRespository.save(courses);
	}

}
