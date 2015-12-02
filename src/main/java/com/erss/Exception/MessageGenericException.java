package com.erss.Exception;

public class MessageGenericException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public static final String ERR_404 = "404";
	public static final String ERR_500 = "500";
	
	private String errid;
	private String errmsg;
	public MessageGenericException(String errid,String errmsg) {
		this.errid = errid;
		this.errmsg = errmsg;
	}
	public String getErrid() {
		return errid;
	}
	public void setErrid(String errid) {
		this.errid = errid;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
	
}
