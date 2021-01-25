package com.twcoding.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.twcoding.dao.EmployeeDao;
import com.twcoding.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional
	@Override
	public List<Employee> findAllemp() {
		
		return employeeDao.findAllemp();
	}
	@Transactional
	@Override
	public Employee findEmpByusername(String username) {
		// TODO Auto-generated method stub
		return employeeDao.findEmpByusername(username);
	}
	@Transactional
	@Override
	public void saveemp(Employee emp) {
		employeeDao.saveemp(emp);
		
	}

}
