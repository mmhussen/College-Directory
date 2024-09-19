package com.app.college.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table
@Entity(name="courses")
public class Courses {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer courseId;
	
	@Column
	private String courseTitle;

	@Column
	private String courseDesc;
	
	@ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Courses(Integer courseId, String courseTitle, String courseDesc, Faculty faculty, Set<Student> students,
			Department department) {
		super();
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.courseDesc = courseDesc;
		this.faculty = faculty;
		this.students = students;
		this.department = department;
	}
    
    
	
	
}
