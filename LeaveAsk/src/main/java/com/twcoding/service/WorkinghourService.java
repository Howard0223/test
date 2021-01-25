package com.twcoding.service;

import com.twcoding.model.workinghour;

public interface WorkinghourService {
	workinghour findworkhourByUsername(String username);
	void saveworkinghour(workinghour hour);
}
