package com.nepal.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.Vendor;
import com.nepal.service.PersistenceService;

@Repository
public class VendorDaoImpl implements VendorDao {

	@Autowired
	PersistenceService persistenceService;
	
	@Transactional
	public List<Vendor> getAllVendors() {
		saveVendor();
		Query query = persistenceService.getSession().getNamedQuery("getAllVendors");
        @SuppressWarnings("unchecked")
		List<Vendor> vendorList = (List<Vendor>)query.list();
		return vendorList;
	}

	private void saveVendor() {
		Vendor vendor = new Vendor();
		vendor.setLocation("Denver");
		vendor.setVendorName("Kushal INC");
		persistenceService.addEntity(vendor);
	}

	@Transactional( readOnly = true)
	public Vendor getVendor(Long id) {
		return persistenceService.get(Vendor.class, id);
	}

}
