package com.twcoding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.twcoding.dao.LeaveformDao;
import com.twcoding.model.leaveform;

@Service
public class LeaveformServiceImp implements LeaveformService {

	@Autowired
	private LeaveformDao leaveformDao;
	@Transactional
	@Override
	public List<leaveform> findAllLeaveform() {	
		return leaveformDao.findAllLeaveform();
	}
	@Transactional
	@Override
	public leaveform findLeaveformById(Integer id) {

		return leaveformDao.findLeaveformById(id);
	}

}
