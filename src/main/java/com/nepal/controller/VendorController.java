package com.nepal.controller;

import java.io.IOException;
import java.util.*;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nepal.beans.Vendor;
import com.nepal.service.VendorService;
import com.nepal.service.PersistenceService;

@Controller
public class VendorController {

	private static Logger logger = Logger.getLogger(VendorController.class);
	
	@Autowired
	PersistenceService persistenceService;
	
	@Autowired
	VendorService vendorService;
	
	@RequestMapping(value = "/vendors", method = RequestMethod.GET)
	public @ResponseBody String getVendor() throws JsonGenerationException, JsonMappingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(vendorService.getAllVendors());
		System.out.println("NOT JSON: \n" + jsonString);
		return jsonString;
		
	}
	
}

