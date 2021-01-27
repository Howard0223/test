package com.twcoding.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "leaveform",
	uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class leaveform {
	@Id
	@Column
	private Integer id;
	@Column
	private String username;
	@Column
	@Enumerated(EnumType.STRING)
	private TYPE type;
	@Column
	private Timestamp begin_leavedate;
	@Column
	private Timestamp end_leavedate;
	@Column
	private Timestamp interview_time;
	@Column
	private String interview_client;
	@Column
	private String interview_address;
	@Column
	private Boolean manager_check;
	@Column
	private Boolean pass;
	@Column
	private String nopass_describe;
	@Column
	private String proof_file;
	@Column
	private Timestamp apply_date;
	@Column
	private Timestamp check_date;
	
	
	public leaveform() {
		
	}
	


	


	public leaveform(Integer id, String username, TYPE type, Timestamp begin_leavedate, Timestamp end_leavedate,
			Timestamp interview_time, String interview_client, String interview_address, Boolean manager_check,
			Boolean pass, String nopass_describe, String proof_file, Timestamp apply_date, Timestamp check_date) {

		this.id = id;
		this.username = username;
		this.type = type;
		this.begin_leavedate = begin_leavedate;
		this.end_leavedate = end_leavedate;
		this.interview_time = interview_time;
		this.interview_client = interview_client;
		this.interview_address = interview_address;
		this.manager_check = manager_check;
		this.pass = pass;
		this.nopass_describe = nopass_describe;
		this.proof_file = proof_file;
		this.apply_date = apply_date;
		this.check_date = check_date;
	}






	public Timestamp getApply_date() {
		return apply_date;
	}






	public void setApply_date(Timestamp apply_date) {
		this.apply_date = apply_date;
	}






	public Timestamp getCheck_date() {
		return check_date;
	}






	public void setCheck_date(Timestamp check_date) {
		this.check_date = check_date;
	}






	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public TYPE getType() {
		return type;
	}



	public void setType(TYPE type) {
		this.type = type;
	}



	public Timestamp getBegin_leavedate() {
		return begin_leavedate;
	}



	public void setBegin_leavedate(Timestamp begin_leavedate) {
		this.begin_leavedate = begin_leavedate;
	}



	public Timestamp getEnd_leavedate() {
		return end_leavedate;
	}



	public void setEnd_leavedate(Timestamp end_leavedate) {
		this.end_leavedate = end_leavedate;
	}



	public Timestamp getInterview_time() {
		return interview_time;
	}



	public void setInterview_time(Timestamp interview_time) {
		this.interview_time = interview_time;
	}



	public String getInterview_client() {
		return interview_client;
	}



	public void setInterview_client(String interview_client) {
		this.interview_client = interview_client;
	}



	public String getInterview_address() {
		return interview_address;
	}



	public void setInterview_address(String interview_address) {
		this.interview_address = interview_address;
	}



	public Boolean getManager_check() {
		return manager_check;
	}



	public void setManager_check(Boolean manager_check) {
		this.manager_check = manager_check;
	}



	public Boolean getPass() {
		return pass;
	}



	public void setPass(Boolean pass) {
		this.pass = pass;
	}



	public String getNopass_describe() {
		return nopass_describe;
	}



	public void setNopass_describe(String nopass_describe) {
		this.nopass_describe = nopass_describe;
	}



	public String getProof_file() {
		return proof_file;
	}



	public void setProof_file(String proof_file) {
		this.proof_file = proof_file;
	}



	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apply_date == null) ? 0 : apply_date.hashCode());
		result = prime * result + ((begin_leavedate == null) ? 0 : begin_leavedate.hashCode());
		result = prime * result + ((check_date == null) ? 0 : check_date.hashCode());
		result = prime * result + ((end_leavedate == null) ? 0 : end_leavedate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((interview_address == null) ? 0 : interview_address.hashCode());
		result = prime * result + ((interview_client == null) ? 0 : interview_client.hashCode());
		result = prime * result + ((interview_time == null) ? 0 : interview_time.hashCode());
		result = prime * result + ((manager_check == null) ? 0 : manager_check.hashCode());
		result = prime * result + ((nopass_describe == null) ? 0 : nopass_describe.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((proof_file == null) ? 0 : proof_file.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		leaveform other = (leaveform) obj;
		if (apply_date == null) {
			if (other.apply_date != null)
				return false;
		} else if (!apply_date.equals(other.apply_date))
			return false;
		if (begin_leavedate == null) {
			if (other.begin_leavedate != null)
				return false;
		} else if (!begin_leavedate.equals(other.begin_leavedate))
			return false;
		if (check_date == null) {
			if (other.check_date != null)
				return false;
		} else if (!check_date.equals(other.check_date))
			return false;
		if (end_leavedate == null) {
			if (other.end_leavedate != null)
				return false;
		} else if (!end_leavedate.equals(other.end_leavedate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (interview_address == null) {
			if (other.interview_address != null)
				return false;
		} else if (!interview_address.equals(other.interview_address))
			return false;
		if (interview_client == null) {
			if (other.interview_client != null)
				return false;
		} else if (!interview_client.equals(other.interview_client))
			return false;
		if (interview_time == null) {
			if (other.interview_time != null)
				return false;
		} else if (!interview_time.equals(other.interview_time))
			return false;
		if (manager_check == null) {
			if (other.manager_check != null)
				return false;
		} else if (!manager_check.equals(other.manager_check))
			return false;
		if (nopass_describe == null) {
			if (other.nopass_describe != null)
				return false;
		} else if (!nopass_describe.equals(other.nopass_describe))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (proof_file == null) {
			if (other.proof_file != null)
				return false;
		} else if (!proof_file.equals(other.proof_file))
			return false;
		if (type != other.type)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}






	@Override
	public String toString() {
		return "leaveform [id=" + id + ", username=" + username + ", type=" + type + ", begin_leavedate="
				+ begin_leavedate + ", end_leavedate=" + end_leavedate + ", interview_time=" + interview_time
				+ ", interview_client=" + interview_client + ", interview_address=" + interview_address
				+ ", manager_check=" + manager_check + ", pass=" + pass + ", nopass_describe=" + nopass_describe
				+ ", proof_file=" + proof_file + ", apply_date=" + apply_date + ", check_date=" + check_date + "]";
	}







	public static enum TYPE{
		事假,病假,公假,特休,生理假,產假,喪假,加班補休	
	}
	
}
