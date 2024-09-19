package com.app.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.college.model.Faculty;
import com.app.college.repository.FacultyRepository;
import com.app.college.services.FacultyService;

@RestController
@RequestMapping("api/faculty")
public class FacultyController {
	
	@Autowired
	FacultyRepository facultyRepository;
	
	@Autowired
	FacultyService facultyService;
	
	@PostMapping("createfaculty")
	public void createFaculty(@RequestBody Faculty faculty) {
		facultyRepository.save(faculty);
	}
	@GetMapping
	public ResponseEntity<List<Faculty>> getAllFaculty(){
		return ResponseEntity.ok(facultyRepository.findAll());
		
	}
	@PutMapping("updatefaculty{id}")
	public ResponseEntity<Faculty> updateFacultyDetails(@PathVariable Long id,@RequestBody Faculty faculty) {
		Faculty existingFaculty = facultyService.getFacultyById(id);
		
		if(faculty!=null) {
			existingFaculty.setCourses(faculty.getCourses());
			existingFaculty.setDepartment(faculty.getDepartment());
			existingFaculty.setPhotoUrl(faculty.getPhotoUrl());
			existingFaculty.setOfficeHours(faculty.getOfficeHours());
			
			return new ResponseEntity<>(facultyService.updateFaculty(existingFaculty), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		
	}

}
