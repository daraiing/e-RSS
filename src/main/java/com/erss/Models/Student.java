package com.erss.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author darathorn.t
 *
 */

@Document(collection="")
public class Student {
	
	@Id
	private String id;
	
	private String sid;
	private String title;
	private String fname;
	private String lname;
	private String gender;
	private int  year;
	private String tid;
	private String fid;
	protected String getId() {
		return id;
	}
	protected void setId(String id) {
		this.id = id;
	}
	protected String getSid() {
		return sid;
	}
	protected void setSid(String sid) {
		this.sid = sid;
	}
	protected String getTitle() {
		return title;
	}
	protected void setTitle(String title) {
		this.title = title;
	}
	protected String getFname() {
		return fname;
	}
	protected void setFname(String fname) {
		this.fname = fname;
	}
	protected String getLname() {
		return lname;
	}
	protected void setLname(String lname) {
		this.lname = lname;
	}
	protected String getGender() {
		return gender;
	}
	protected void setGender(String gender) {
		this.gender = gender;
	}
	protected int getYear() {
		return year;
	}
	protected void setYear(int year) {
		this.year = year;
	}
	protected String getTid() {
		return tid;
	}
	protected void setTid(String tid) {
		this.tid = tid;
	}
	protected String getFid() {
		return fid;
	}
	protected void setFid(String fid) {
		this.fid = fid;
	}
	
	
	

}
