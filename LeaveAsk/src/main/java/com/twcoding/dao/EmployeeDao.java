package com.twcoding.dao;

import java.util.List;

import com.twcoding.model.Employee;

public interface EmployeeDao {
	List<Employee> findAllemp();
	Employee findEmpByusername(String username);
	void saveemp(Employee emp);
}
