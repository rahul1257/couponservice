package com.rahul.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rahul.springcloud.model.User;
import com.rahul.springcloud.repos.UserRepo;
import com.rahul.springcloud.security.SecurityService;

@Controller
public class UserController {

	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String showLoginPage() {
		return "login";
	}
	
	@GetMapping("/showReg")
	public String showRegistrationPage() {
		return "registerUser";
	}
	
	@PostMapping("/registerUser")
	public String registerUser( User user) {
		System.out.println("user: "+user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		return "login";
	}
	
	@PostMapping("/login")
	public String login(String email, String password) {
		Boolean loginResponse = securityService.login(email, password);
		if(loginResponse) return "index";
		
		return "login";
	}
	
}
