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
	protected String getId() {
		return id;
	}
	protected void setId(String id) {
		this.id = id;
	}
	protected String getFcId() {
		return fcId;
	}
	protected void setFcId(String fcId) {
		this.fcId = fcId;
	}
	protected String getFcName() {
		return fcName;
	}
	protected void setFcName(String fcName) {
		this.fcName = fcName;
	}
	
	

}
