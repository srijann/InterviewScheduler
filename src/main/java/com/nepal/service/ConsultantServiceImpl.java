package com.nepal.service;

import java.util.Calendar;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.Consultant;
import com.nepal.beans.EducationDetail;

@Service
public class ConsultantServiceImpl implements ConsultantService {

	@Autowired
	PersistenceService persistenceService; 
	
	@Transactional
	public void addConsultant() {
		EducationDetail ed = new EducationDetail();
		ed.setGraduateYear(2009L);
		ed.setInstitutionName("Columbia");
		ed.setLocation("Denver, CO");
		Consultant consultant = new Consultant();
		consultant.setName("Kushal");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1984);
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 28);
		consultant.setEducationDetail(ed);
		consultant.setDob(cal.getTime());
		consultant.setEmail("nrs@hotmail.com");
		consultant.setSsn("443-30-8769");
		consultant.setPhone("303-344-4799");
		consultant.setYrsExp(6.5D);
		persistenceService.addEntity(consultant);
	}

	@Transactional
	public Consultant getConsultantById(Long id) {
		Consultant consultant = persistenceService.get(Consultant.class, id);
		Hibernate.initialize(consultant.getConsultantClient());
		Hibernate.initialize(consultant.getVendors());
		return consultant;
	}

	

}
