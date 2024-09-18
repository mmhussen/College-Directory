package com.app.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.college.dto.LoginRequest;
import com.app.college.model.User;
import com.app.college.services.LoginValidatorService;

@RestController
@RequestMapping("api/users")
public class LoginController {
	
	@Autowired
	LoginValidatorService loginValidatorService;
	
	@PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            User user = loginValidatorService.validateUserCredentials(loginRequest.getUserId(), loginRequest.getPassword());

            if (user != null) {
                return ResponseEntity.ok().body(user);
            } else {
                // Authentication failed
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (Exception e) {
            // Handle any exception that may occur during the login process
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }

}
