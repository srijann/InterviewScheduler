package com.nepal.service;

import java.util.List;

import com.nepal.beans.Consultant;


public interface ConsultantService {
	
	void addConsultant();
	Consultant getConsultantById(Long id);
	List<Consultant> getAllConsultants();
}
