package com.nepal.dao;

import java.util.List;

import com.nepal.beans.Consultant;

public interface ConsultantDao {
	
	//Read Consultants
	List<Consultant> getAllConsultant();
	public boolean addEntity(Consultant consultant) throws Exception; 
	void deleteConsultant(Consultant consultant);

}
