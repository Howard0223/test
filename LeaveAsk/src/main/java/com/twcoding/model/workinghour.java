package com.twcoding.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name = "workinghour",
	uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class workinghour {
	@Id
	@Column
	private String username;
	@Column
	private	Time toworktime;
	@Column
	private Time offworktime;
	@Column
	private Time lunchhour;
	@Column
	private Time afternoonworktime;
	
	public workinghour() {
	}

	public workinghour(String username, Time toworktime, Time offworktime, Time lunchhour, Time afternoonworktime) {
		this.username = username;
		this.toworktime = toworktime;
		this.offworktime = offworktime;
		this.lunchhour = lunchhour;
		this.afternoonworktime = afternoonworktime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Time getToworktime() {
		return toworktime;
	}

	public void setToworktime(Time toworktime) {
		this.toworktime = toworktime;
	}

	public Time getOffworktime() {
		return offworktime;
	}

	public void setOffworktime(Time offworktime) {
		this.offworktime = offworktime;
	}

	public Time getLunchhour() {
		return lunchhour;
	}

	public void setLunchhour(Time lunchhour) {
		this.lunchhour = lunchhour;
	}

	public Time getAfternoonworktime() {
		return afternoonworktime;
	}

	public void setAfternoonworktime(Time afternoonworktime) {
		this.afternoonworktime = afternoonworktime;
	}

	@Override
	public String toString() {
		return "workinghour [username=" + username + ", toworktime=" + toworktime + ", offworktime=" + offworktime
				+ ", lunchhour=" + lunchhour + ", afternoonworktime=" + afternoonworktime + "]";
	}
	
	
	
}
