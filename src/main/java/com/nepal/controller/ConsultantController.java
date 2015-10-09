package com.nepal.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nepal.beans.Consultant;
import com.nepal.service.ConsultantService;
import com.nepal.service.PersistenceService;

@Controller
public class ConsultantController {

	private static Logger logger = Logger.getLogger(ConsultantController.class);
	
	@Autowired
	PersistenceService persistenceService;
	
	@Autowired
	ConsultantService consultantService;
	
	@RequestMapping(value = "/consultants", method = RequestMethod.GET)
	public @ResponseBody String getConsultants() throws JsonProcessingException{
		Consultant consultant = consultantService.getConsultantById(2L);
		System.out.println("before json conversion : \n" + consultant);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(consultant);
		System.out.println("after json conversion : \n" + jsonString);
		return jsonString;
		
	}
	
}

