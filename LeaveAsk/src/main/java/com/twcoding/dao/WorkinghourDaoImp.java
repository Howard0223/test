package com.twcoding.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.twcoding.model.workinghour;

@Repository
public class WorkinghourDaoImp implements WorkinghourDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public workinghour findworkhourByUsername(String username) {
		
		return sessionFactory.getCurrentSession().get(workinghour.class, username);
	}

	@Override
	public void saveworkinghour(workinghour hour) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(hour);
	}
}
