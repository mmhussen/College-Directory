package com.app.college.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Table
@Entity(name="faculty")
public class Faculty {
	
	@Id
	private Integer userId;

	@Column
	private String photoUrl;
	
	@Column
	private String officeHours;
	
	@OneToOne
    @JoinColumn
    private User user;

	@OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private Set<Courses> courses = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Faculty(Integer userId, String photoUrl, String officeHours, User user, Set<Courses> courses,
			Department department) {
		super();
		this.userId = userId;
		this.photoUrl = photoUrl;
		this.officeHours = officeHours;
		this.user = user;
		this.courses = courses;
		this.department = department;
	}
    
    
}
