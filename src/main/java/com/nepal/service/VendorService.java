package com.nepal.service;

import java.util.List;

import com.nepal.beans.Vendor;

public interface VendorService {
	List<Vendor> getAllVendors();
	Vendor getVendor(Long id);
}
