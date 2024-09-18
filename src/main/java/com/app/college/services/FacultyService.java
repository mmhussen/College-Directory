package com.app.college.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.college.model.Faculty;
import com.app.college.repository.FacultyRepository;

public class FacultyService {
	
	@Autowired
	FacultyRepository facultyRepository;
	
	public Faculty getFacultyById(Long id) {
		return facultyRepository.findById(id).orElse(null);
	}
	public Faculty updateFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

}
