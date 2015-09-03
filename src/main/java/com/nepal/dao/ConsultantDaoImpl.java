package com.nepal.dao;

import java.time.Year;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.Consultant;
import com.nepal.beans.EducationDetail;
import com.nepal.service.PersistenceService;

@Repository
public class ConsultantDaoImpl implements ConsultantDao {

	@Autowired
	PersistenceService persistenceService;
	
	@Transactional
	public List<Consultant> getAllConsultant() {
		saveConsultant();
		return listConsultants();
	}
	
	private void saveConsultant(){
		EducationDetail ed = new EducationDetail();
		//ed.setId(5L);
		ed.setGraduateYear(2009L);
		ed.setInstitutionName("Regis");
		ed.setLocation("Denver, CO");
		persistenceService.addEntity(ed);
		Consultant consultant = new Consultant();
		consultant.setName("Naresh");
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
	public List<Consultant> listConsultants(){
		return (List<Consultant>)persistenceService.listEntity(Consultant.class);
	}
	
	@Transactional( readOnly = true)
	public Consultant getConsultant(Long id) {
		return persistenceService.get(Consultant.class, id);
	}

	

	


	
	

}
