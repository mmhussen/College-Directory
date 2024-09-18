package com.app.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.college.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long>{

}
