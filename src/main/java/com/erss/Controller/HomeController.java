package com.erss.Controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Object home(RequestMappingHandlerMapping rmhm) {
		Map<String,String> data = new HashMap<String, String>();
		data.put("ws-name", "E-Student Registration Service System");
		data.put("ws-version", "developing..");
		data.put("ws-server", "tomcat7");
		data.put("ws-startdate", Calendar.getInstance().getTime().toString());
		return data;
	}
}
