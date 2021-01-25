package com.twcoding.service;

import java.util.List;

import com.twcoding.model.Employee;

public interface EmployeeService {
	List<Employee> findAllemp();
	Employee findEmpByusername(String username) ;
	void saveemp(Employee emp);
}
