package com.app.college.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.college.model.User;
import com.app.college.repository.UserRepository;

public class LoginValidatorService {
	
	@Autowired
	UserRepository userRepository;
	
	 public User validateUserCredentials(Long userId, String password) {
	        User user = userRepository.findUserById(userId);
	        if (user != null && user.getPassword().equals(password)) {
	            return user;
	        }
	        return null;
	    }

}
