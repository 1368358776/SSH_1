package com.bjtxt.ssh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDao {
	
	private SessionFactory sessionFactory;
	
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
