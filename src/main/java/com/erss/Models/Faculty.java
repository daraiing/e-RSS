package com.erss.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author darathorn.t
 *
 */

@Document(collection="")
public class Faculty {
	
	@Id
	private String id;
	
	private String fcId;
	private String fcName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFcId() {
		return fcId;
	}
	public void setFcId(String fcId) {
		this.fcId = fcId;
	}
	public String getFcName() {
		return fcName;
	}
	public void setFcName(String fcName) {
		this.fcName = fcName;
	}


	

}
