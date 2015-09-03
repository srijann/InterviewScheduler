package com.nepal.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nepal.dao.ConsultantDao;
import com.nepal.dao.VendorDao;

@Controller
//@RequestMapping("/")
public class IndexController {
	private static Logger logger = Logger.getLogger(IndexController.class);

	@Autowired
	VendorDao vendorDao;
	
	@Autowired
	ConsultantDao consultantDao;
	
	
	@RequestMapping("/")
	public String getIndexPage() {
		System.out.println("HELLO NARESH BRO!!!");
		logger.error(consultantDao.getAllConsultant());
		logger.error("From Own Controller");
		System.out.println(vendorDao.getAllVendors());
		logger.error(vendorDao.getVendor(1L));
		return "index";
	}
}
