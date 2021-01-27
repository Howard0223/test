package com.twcoding.model;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

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
	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy")
	private Date entrydate;
	
	public Employee() {
	}
	
	
	public Employee(String username, String password, String realname, String project, String phone, Identity identity,
			Department department, Date entrydate) {
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.project = project;
		this.phone = phone;
		this.identity = identity;
		this.department = department;
		this.entrydate = entrydate;
	}


	public Date getEntrydate() {
		return entrydate;
	}


	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
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
				+ project + ", phone=" + phone + ", identity=" + identity + ", department=" + department
				+ ", entrydate=" + entrydate + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((entrydate == null) ? 0 : entrydate.hashCode());
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((realname == null) ? 0 : realname.hashCode());
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
		if (department != other.department)
			return false;
		if (entrydate == null) {
			if (other.entrydate != null)
				return false;
		} else if (!entrydate.equals(other.entrydate))
			return false;
		if (identity != other.identity)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (realname == null) {
			if (other.realname != null)
				return false;
		} else if (!realname.equals(other.realname))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}




	public static enum Identity{
		employee,manager,boss
	}
	public static enum Department{
		HR,others
	}
}
