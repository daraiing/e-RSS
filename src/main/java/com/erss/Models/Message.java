package com.erss.Models;

public class Message {
	private String code;
	private Object message;
	public static final String MSG_ERR404 = "404";
	public static final String MSG_ERR500 = "500";
	
	public Message(String code,String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}
}
