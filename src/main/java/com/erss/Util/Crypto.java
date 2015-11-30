package com.erss.Util;

import org.springframework.util.DigestUtils;

public class Crypto {
	private static final String SALT = "e-rss";
	
	public static String SHA1(String data){
		data = SALT+data; 
		return DigestUtils.md5DigestAsHex(data.getBytes());
	}
}
