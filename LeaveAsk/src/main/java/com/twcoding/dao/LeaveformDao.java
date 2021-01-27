package com.twcoding.dao;

import java.util.List;

import com.twcoding.model.leaveform;

public interface LeaveformDao {
	List<leaveform> findAllLeaveform();
	leaveform findLeaveformById(Integer id);
}
