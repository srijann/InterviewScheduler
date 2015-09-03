package com.nepal.service;

import java.util.List;

import org.hibernate.Session;

public interface PersistenceService {
	
	Session getSession();
	<T> T get(Class<T> entityClass, Long id);
	<T> List<T> listEntity(Class<T> entityClass);
	void addEntity(Object entity);
}
