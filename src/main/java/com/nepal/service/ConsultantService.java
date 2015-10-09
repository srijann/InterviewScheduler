package com.nepal.service;

import java.util.List;

import com.nepal.beans.Consultant;


public interface ConsultantService {
	
	public boolean addEntity(Consultant consultant) throws Exception;  
	Consultant getConsultantById(Long id);
	List<Consultant> getAllConsultants();
}
