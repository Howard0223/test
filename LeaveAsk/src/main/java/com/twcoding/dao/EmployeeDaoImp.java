package com.twcoding.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.twcoding.model.Employee;

@Repository
public class EmployeeDaoImp implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Employee> findAllemp() {
		String hql = "FROM Employee e";
		Session session = sessionFactory.getCurrentSession();
		List<Employee> li = session.createQuery(hql).list();
		System.out.println(li);
		return li;

	}

	@Override
	public Employee findEmpByusername(String username) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Employee.class, username);
	}

	@Override
	public void saveemp(Employee emp) {
		// TODO Auto-generated method stub
		//sessionFactory.getCurrentSession().save(emp);
		sessionFactory.getCurrentSession().update(emp);
	}

}