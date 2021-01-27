package com.twcoding.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.twcoding.model.leaveform;

@Repository
public class LeaveformDaoImp implements LeaveformDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<leaveform> findAllLeaveform() {
		String hql = "FROM leaveform lf";
		Session session = sessionFactory.getCurrentSession();
		List<leaveform> li = session.createQuery(hql).list();
		System.out.println(li);
		return li;
	}

	@Override
	public leaveform findLeaveformById(Integer id) {
		return sessionFactory.getCurrentSession().get(leaveform.class, id);		
	}
	
	

}
