package com.app.college.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table
@Entity(name="student")
public class Student {
	
	@Id
	private Integer userId;

	@Column(name="photo_url")
	private String photoUrl;
	
	@Column(name="year")
	private String year;

	@OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    
    @ManyToMany
    @JoinTable(name="studentCourse",joinColumns=@JoinColumn(name="student_id"),inverseJoinColumns = @JoinColumn(name="course_id"))
    private Set<Courses> courses = new HashSet<>();

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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}

	public Student(Integer userId, String photoUrl, String year, User user, Department department,
			Set<Courses> courses) {
		super();
		this.userId = userId;
		this.photoUrl = photoUrl;
		this.year = year;
		this.user = user;
		this.department = department;
		this.courses = courses;
	}

    
}
