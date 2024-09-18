package com.app.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.college.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findUserById(Long userId);

}
