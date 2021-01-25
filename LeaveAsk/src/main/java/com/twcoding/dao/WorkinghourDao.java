package com.twcoding.dao;

import com.twcoding.model.Employee;
import com.twcoding.model.workinghour;

public interface WorkinghourDao {
	workinghour findworkhourByUsername(String username);
	void saveworkinghour(workinghour hour);
}
