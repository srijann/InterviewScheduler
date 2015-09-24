package com.nepal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public @ResponseBody List<Consultant> getConsultants(){
		System.out.println(consultantService.getConsultantById(5L));
		return null;
		
	}
	
}

