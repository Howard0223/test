package com.twcoding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.twcoding.dao.WorkinghourDao;
import com.twcoding.model.workinghour;

@Service
public class WorkinghourServiceImp implements WorkinghourService {

	@Autowired
	WorkinghourDao workinghourDao;
	
	@Transactional
	@Override
	public workinghour findworkhourByUsername(String username) {
		// TODO Auto-generated method stub
		return workinghourDao.findworkhourByUsername(username);
	}
	@Transactional
	@Override
	public void saveworkinghour(workinghour hour) {
		// TODO Auto-generated method stub
		workinghourDao.saveworkinghour(hour);
	}
	
}
