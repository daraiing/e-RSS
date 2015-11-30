package com.erss.Models;
/**
 * 
 * @author darathorn.t
 *
 */

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="")
public class Historical {
	
	@Id
	private String id;
	
	private String sid;
	private String cid;
	private String semester;
	private float grade;
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
	protected String getCid() {
		return cid;
	}
	protected void setCid(String cid) {
		this.cid = cid;
	}
	protected String getSemester() {
		return semester;
	}
	protected void setSemester(String semester) {
		this.semester = semester;
	}
	protected float getGrade() {
		return grade;
	}
	protected void setGrade(float grade) {
		this.grade = grade;
	}
	
	

}
