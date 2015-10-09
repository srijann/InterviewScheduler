package com.nepal.service;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.Client;
import com.nepal.beans.Consultant;
import com.nepal.beans.ConsultantClient;
import com.nepal.beans.EducationDetail;
import com.nepal.beans.Interview;
import com.nepal.beans.SalesRepresentative;
import com.nepal.beans.Vendor;

@Service
public class ConsultantServiceImpl implements ConsultantService {

	@Autowired
	PersistenceService persistenceService; 

	@Transactional
	public void addConsultant() {
	/*	long randomNum = Calendar.getInstance().getTimeInMillis();
		SalesRepresentative sr = new SalesRepresentative();
		sr.setName("Asim" + randomNum);
		sr.setPhone("" + randomNum);
		sr.setEmail(randomNum + "@gmail.com"); 
		persistenceService.addEntity(sr);*/
		
		
		Consultant cons = persistenceService.get(Consultant.class, 1L);
		System.out.println("cons: " + cons);
		
		/*EducationDetail ed = new EducationDetail();
		ed.setConsultant(cons);
		ed.setGraduateYear(2009L);
		ed.setInstitutionName("Columbia");
		ed.setLocation("Denver, CO");
		persistenceService.addEntity(ed);*/
		
		/*SalesRepresentative sr = persistenceService.get(SalesRepresentative.class, 2L);
		System.out.println("sales rep: " + sr);
		Consultant consultant = new Consultant();
		consultant.setSalesRep(sr);
		//consultant.setEducationDetail(ed);
		consultant.setName("Kushal");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1984);
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 28);
		consultant.setDob(cal.getTime());
		consultant.setEmail("nrs@hotmail.com");
		consultant.setSsn("443-30-8769");
		consultant.setPhone("303-344-4799");
		consultant.setYrsExp(6.5D);
		persistenceService.addEntity(consultant);*/
		
		Client client = persistenceService.get(Client.class, 2L);
		System.out.println("client:" + client);
		
	/*	ConsultantClient consultantClient = new ConsultantClient();
		consultantClient.setClient(client);
		consultantClient.setConsultant(cons);
		Calendar calender = Calendar.getInstance();
		calender.set(Calendar.YEAR, 2013);
		calender.set(Calendar.MONTH, 3);
		calender.set(Calendar.DAY_OF_MONTH, 07);
		Date startDate = calender.getTime();
		consultantClient.setStartDate(startDate);
		Calendar cr = Calendar.getInstance();
		cr.set(Calendar.YEAR, 2014);
		cr.set(Calendar.MONTH, 01);
		cr.set(Calendar.DAY_OF_MONTH, 07);
		Date endDate = calender.getTime();
		consultantClient.setEndDate(endDate);
		persistenceService.addEntity(consultantClient);*/
		
		
		Vendor vendor = persistenceService.get(Vendor.class, 3L);
		System.out.println("vendor:" + vendor);
		
		/*Vendor vendor = new Vendor();
		vendor.setVendorName("Nirish Consulting Company");
		vendor.setLocation("westminster");
		persistenceService.addEntity(vendor);*/
		
		/*Client client = new Client();
		client.setName("Wells Fargo");
		client.setLocation("Des moines");
		persistenceService.addEntity(client);*/
		
		Interview interview = new Interview();
		interview.setConsultant(cons);
		interview.setClient(client);
		interview.setVendor(vendor);
		interview.setType("Skype");
		Calendar cldr = Calendar.getInstance();
		cldr.set(Calendar.YEAR, 2015);
		cldr.set(Calendar.MONTH, 10);
		cldr.set(Calendar.DAY_OF_MONTH, 8); 
		cldr.set(Calendar.HOUR_OF_DAY, 03);  
		cldr.set(Calendar.MINUTE, 55);
		interview.setDateTime(cldr);
		persistenceService.addEntity(interview);
	}

	@Transactional
	public Consultant getConsultantById(Long id) {
		Consultant consultant = persistenceService.get(Consultant.class, id);
		/*Hibernate.initialize(consultant.getConsultantClient());
		Hibernate.initialize(consultant.getVendors());
		Hibernate.initialize(consultant.getInterview());
		Hibernate.initialize(consultant.getSalesRep());
		Hibernate.initialize(consultant.getEducationDetail());*/
		return consultant;
	}



}
