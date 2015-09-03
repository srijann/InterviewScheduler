package com.nepal.service;

import java.util.List;

import com.nepal.beans.Consultant;

public interface ConsultantService {
	//Read Consultants
		List<Consultant> getAllConsultant();
		
		Consultant getConsultant(Long id);
}
