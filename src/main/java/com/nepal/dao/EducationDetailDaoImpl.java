package com.nepal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.EducationDetail;
import com.nepal.service.EducationDetailService;
import com.nepal.service.PersistenceService;

public class EducationDetailDaoImpl implements EducationDetailService {
	
	@Autowired
	PersistenceService persistenceService;
	

	

}
