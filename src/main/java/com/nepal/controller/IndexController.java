package com.nepal.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nepal.beans.Vendor;
import com.nepal.dao.VendorDao;
import com.nepal.service.ConsultantService;

@Controller
//@RequestMapping("/")
public class IndexController {
	private static Logger logger = Logger.getLogger(IndexController.class);

	@Autowired
	VendorDao vendorDao;
	
	@Autowired
	ConsultantService consultantService;
	
	
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
		consultantService.addConsultant();
		return "index";
	}
	
	/*@RequestMapping("/consultant")
	public @ResponseBody String getConsultants() {
		System.out.println("consultants");
		return "****ConsultantController****";
	}*/
	
}
