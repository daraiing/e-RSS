package com.erss.Controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.erss.Models.Message;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public Object home(RequestMappingHandlerMapping rmhm) {
		Map<String,String> data = new HashMap<String, String>();
		data.put("ws-name", "E-Student Registration Service System");
		data.put("ws-version", "developing..");
		data.put("ws-server", "tomcat7");
		data.put("ws-startdate", Calendar.getInstance().getTime().toString());
		return data;
	}
	
	@ExceptionHandler(Exception.class)
	public Message error(Exception ex,HttpServletResponse response){
		response.setStatus(response.SC_INTERNAL_SERVER_ERROR);
		ex.printStackTrace();
		return new Message("ERR_TEACHER_SERVICE", ex.getMessage());
	}
}
