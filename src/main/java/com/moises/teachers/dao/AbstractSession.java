 package com.moises.teachers.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractSession {
	
	@Autowired
	private EntityManager sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.unwrap(Session.class);
	}
	
	
}
