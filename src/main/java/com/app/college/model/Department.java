package com.app.college.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table
@Entity(name="department")
public class Department {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer deptId;

	@Column(name="dept_name")
	private String deptName;
	
	@Column(name="dept_desc")
	private String deptDesc;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Faculty> faculties = new HashSet<>();

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<Courses> courses = new HashSet<>();

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptDesc() {
		return deptDesc;
	}

	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}

	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}

	public Department(Integer deptId, String deptName, String deptDesc, Set<Student> students, Set<Faculty> faculties,
			Set<Courses> courses) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptDesc = deptDesc;
		this.students = students;
		this.faculties = faculties;
		this.courses = courses;
	}
    
    
}
