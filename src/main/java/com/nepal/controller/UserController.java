package com.nepal.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nepal.beans.User;
import com.nepal.service.PersistenceService;
import com.nepal.service.UserService;

@Controller
public class UserController {
private static Logger logger = Logger.getLogger(ConsultantController.class);
	
	@Autowired
	PersistenceService persistenceService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody User authenticateUser(){
		System.out.println("Inside User Controller");
		User user = userService.getUserByNameAndPwd("srijan", "kathmandu");
		System.out.println(user != null ? user.getId() : "No user with such un and pwd");
		return user;
		
	
	}
	
	@RequestMapping(value = "/signUpNewUser", method = RequestMethod.POST)
	public @ResponseBody User signUpNewUser(@RequestBody User user){
		
		System.out.println("Inside sign up new User Controller: " + user.getName());
		userService.addNewUser(user);
		return null;
		
	
	}
}
