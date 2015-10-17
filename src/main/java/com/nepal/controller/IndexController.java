package com.nepal.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nepal.beans.User;
import com.nepal.beans.Vendor;
import com.nepal.dao.VendorDao;
import com.nepal.service.ConsultantService;
import com.nepal.service.UserService;

@Controller
//@RequestMapping("/")
public class IndexController {
	private static Logger logger = Logger.getLogger(IndexController.class);

	@Autowired
	VendorDao vendorDao;
	
	@Autowired
	ConsultantService consultantService;
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/")
	public String getIndexPage() {
		/*System.out.println("HELLO NARESH BRO!!!");
		logger.error(consultantDao.getAllConsultant());
		logger.error("From Own Controller");
		System.out.println(vendorDao.getAllVendors());
		Vendor vendor = new Vendor();
		vendor.setLocation("Broomfield");
		vendor.setVendorName("Nirish INC");
		vendorDao.addVendor(vendor);
		vendorDao.getAllVendors();
		vendorDao.deleteVendor(vendor);*/
		//consultantService.addConsultant();
		
	/*	System.out.println("Inside User Controller");
		User user = userService.getUserByNameAndPwd("srijan", "kathmandu");
		System.out.println(user != null ? user.getId() : "No user with such un and pwd");*/
		return "index";
	}
	
	/*@RequestMapping("/consultant")
	public @ResponseBody String getConsultants() {
		System.out.println("consultants");
		return "****ConsultantController****";
	}*/
	
}
