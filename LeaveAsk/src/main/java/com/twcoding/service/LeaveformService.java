package com.twcoding.service;

import java.util.List;

import com.twcoding.model.leaveform;

public interface LeaveformService {
	List<leaveform> findAllLeaveform();
	leaveform findLeaveformById(Integer id);
}
