package com.app.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.college.model.Faculty;
import com.app.college.model.Student;
import com.app.college.services.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	@PostMapping("createstudent")
    public ResponseEntity<Student> createStudent(@RequestParam Student student) {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

	@GetMapping("/name/{name}/id/{id}")
    public ResponseEntity<?> getStudentByNameAndId(@PathVariable String name, @PathVariable Long id) {
        Student student = studentService.getStudentByName(name, id);

        if (student != null) {
            // Convert entity to DTO
            return ResponseEntity.ok().body(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
	}
	
	@PutMapping("updatestudent{id}")
	public ResponseEntity<Student> updateFacultyDetails(@PathVariable Long id,@RequestBody Student student) {
		Student existingStudent = studentService.getStudentById(id);
		
		if(existingStudent!=null) {
			existingStudent.setCourses(student.getCourses());
			existingStudent.setDepartment(student.getDepartment());
			existingStudent.setPhotoUrl(student.getPhotoUrl());
			existingStudent.setYear(student.getYear());
			
			return new ResponseEntity<>(studentService.updateStudent(existingStudent), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		
	}

}
