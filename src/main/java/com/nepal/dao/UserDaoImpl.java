package com.nepal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nepal.beans.User;
import com.nepal.service.PersistenceService;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	PersistenceService persistenceService;

	@Transactional
	public List<User> getAllUsers() {
		return listUsers();
	}

	@Transactional
	public List<User> listUsers(){
		return (List<User>) persistenceService.listEntity(User.class);
	}

	@Transactional
	public void addUser(User user) {
		persistenceService.addEntity(user);
	}

	@Transactional
	public void deleteUser(User user) {
		persistenceService.deleteEntity(user);
	}

}
