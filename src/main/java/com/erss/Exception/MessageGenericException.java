package com.erss.Exception;

public class MessageGenericException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public static final int ERR_404 = 404;
	public static final int ERR_500 = 500;
	
	private String errId;
	private String errMsg;
	private int statusCode;
	
	
	public MessageGenericException(String errId, String errMsg, int statusCode) {
		super();
		this.errId = errId;
		this.errMsg = errMsg;
		this.statusCode = statusCode;
	}
	public String getErrId() {
		return errId;
	}
	public void setErrId(String errId) {
		this.errId = errId;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
	
}
