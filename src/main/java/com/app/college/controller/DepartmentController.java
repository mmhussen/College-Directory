package com.app.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.college.model.Department;
import com.app.college.repository.DepartmentRepository;

@RestController
@RequestMapping("api/dept")
public class DepartmentController {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@PostMapping("adddept")
	public void createDepartment(@RequestBody Department department) {
		departmentRepository.save(department);
	}

}
