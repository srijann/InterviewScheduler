package com.nepal.service;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.Vendor;


@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	PersistenceService persistenceService; 
	
	
	@Transactional
	public List<Vendor> getAllVendors(){
		List<Vendor> getAll = (List<Vendor>)persistenceService.listEntity(Vendor.class);
		return getAll;
	}

	

}
