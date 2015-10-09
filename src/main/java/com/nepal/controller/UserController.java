package com.nepal.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nepal.service.PersistenceService;

@Controller
public class UserController {
private static Logger logger = Logger.getLogger(ConsultantController.class);
	
	@Autowired
	PersistenceService persistenceService;
	
	/*@Autowired
	UserService userService;*/
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody String getUserInfo() throws JsonProcessingException{
		return null;
	
	}
}
