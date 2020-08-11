package com.shivi.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shivi.flightreservation.repos.FlightRepository;
import com.shivi.flightreservation.repos.UserRepository;
import com.shivi.flightreservation.services.SecurityService;
import com.shivi.flightreservation.entities.User;

@CrossOrigin
@Controller
public class UserController {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	private SecurityService securityservice;
	
	@RequestMapping(value="/showReg",method=RequestMethod.POST)
	public void showRegistrationPage(@RequestBody User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		System.out.println("runnsianvge  sftunatction is working");
		
	}
	
	
	@RequestMapping(value= "/registerUser", method=RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		userRepository.save(user);
		return "login/login";	
	}
	
	@RequestMapping("/showLogin")
	public void showLoginPage(@RequestBody User user) {
		System.out.println("success satyaaaaaaaaa");
		
	}
	

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("email")String email,@RequestParam("password")String password, ModelMap modelmap) {
	User user=userRepository.findByEmail(email);
	
	boolean loginResponse=securityservice.login(email,password);
	if(loginResponse) {
		return "login/findFlights";
	}
	else {
		modelmap.addAttribute("msg","Invalid Username or Password");
	}
		return "login/login";
	}
	

	
	
	
}
