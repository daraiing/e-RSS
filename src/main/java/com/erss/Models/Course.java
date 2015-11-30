package com.erss.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author darathorn.t
 *
 */

@Document(collection="")
public class Course {
	
	@Id
	private String id;
	
	private String cid;
	private String cname;
	private int ccredit;
	private String cdescription;
	private String tid;
	protected String getId() {
		return id;
	}
	protected void setId(String id) {
		this.id = id;
	}
	protected String getCid() {
		return cid;
	}
	protected void setCid(String cid) {
		this.cid = cid;
	}
	protected String getCname() {
		return cname;
	}
	protected void setCname(String cname) {
		this.cname = cname;
	}
	protected int getCcredit() {
		return ccredit;
	}
	protected void setCcredit(int ccredit) {
		this.ccredit = ccredit;
	}
	protected String getCdescription() {
		return cdescription;
	}
	protected void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}
	protected String getTid() {
		return tid;
	}
	protected void setTid(String tid) {
		this.tid = tid;
	}

	
}
