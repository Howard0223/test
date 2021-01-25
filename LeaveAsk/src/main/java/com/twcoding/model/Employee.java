package com.twcoding.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Employee",
	uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class Employee {
	@Id
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String realname;
	@Column
	private String project;
	@Column
	private String phone;
	@Column
	@Enumerated(EnumType.STRING)
	private Identity identity;
	@Column
	@Enumerated(EnumType.STRING)
	private Department department;
	
	
	public Employee() {
	}
	public Employee(String username, String password, String realname, String project, Identity identity,
			Department department) {
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.project = project;
		this.identity = identity;
		this.department = department;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + ", realname=" + realname + ", project="
				+ project + ", phone=" + phone + ", identity=" + identity + ", department=" + department + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public enum Identity{
		employee,manager
	}
	public enum Department{
		HR,others
	}
}
