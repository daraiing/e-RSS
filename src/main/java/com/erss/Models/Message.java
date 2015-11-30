package com.erss.Models;

public class Message {
	private String msgType;
	private Object msgContent;
	public static final String MSG_SUCCESS = "success";
	public static final String MSG_ERROR = "error";
	
	public Message(String msgType) {
		super();
		this.msgType = msgType;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public Object getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(Object msgContent) {
		this.msgContent = msgContent;
	}
	
	
	
}
