package com.nepal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.Consultant;
import com.nepal.dao.ConsultantDao;

public class ConsultantServiceImpl implements ConsultantService {

	@Autowired
	PersistenceService persistanceService;

		@Transactional( readOnly = true)
	public List<Consultant> getAllConsultant() {

		return null;
	}

	@Transactional( readOnly = true)
	public Consultant getConsultant(Long id) {

		return null;
	}

}
