package com.nepal.controller;

import java.io.IOException;
import java.util.*;

import com.nepal.beans.Status;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
		List<Consultant> consultants = consultantService.getAllConsultants();
		return consultants;

	}
	
	@RequestMapping(value = "/editConsultant", method = RequestMethod.POST)
	public @ResponseBody String editConsultant(@RequestBody Consultant consultant){
		System.out.println("inside edit consultant" +  consultant);
		return null;
	}
	/*@RequestMapping(value = "/addConsultant", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)  
	 public @ResponseBody  
	 Status addEmployee(@RequestBody Consultant consultant) {  
	  try {  
	   ConsultantService.addEntity(consultant);  
	   return new Status(1, "Employee added Successfully !");  
	  } catch (Exception e) {  
	   // e.printStackTrace();  
	   return new Status(0, e.toString());  
	  }  */

}  



