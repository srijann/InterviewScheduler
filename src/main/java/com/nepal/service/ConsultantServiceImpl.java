package com.nepal.service;

import java.util.Calendar;
import java.util.List;

import com.nepal.dao.ConsultantDao;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.Consultant;
import com.nepal.beans.EducationDetail;

@Service
public class ConsultantServiceImpl implements ConsultantService {

	@Autowired  
	ConsultantDao consultantDao; 
	@Autowired
	PersistenceService persistenceService; 
	
	@Transactional
	public Consultant getConsultantById(Long id) {
		Consultant consultant = persistenceService.get(Consultant.class, id);
		Hibernate.initialize(consultant.getConsultantClient());
		Hibernate.initialize(consultant.getVendors());
		return consultant;
	}
	@Transactional
	public List<Consultant> getAllConsultants(){
		List<Consultant> getAll = (List<Consultant>)persistenceService.listEntity(Consultant.class);
		return getAll;
	}
	@Transactional
	 public boolean addEntity(Consultant consultant) throws Exception {  
	  return consultantDao.addEntity(consultant);  
	 }  

	

}
