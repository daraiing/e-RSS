package com.erss.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.erss.Models.Course;
import com.erss.Models.Message;
import com.erss.Models.Student;
import com.erss.Services.CourseService;
import com.erss.Services.StudentService;
import com.erss.Util.Crypto;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/")
public class HomeController {
	@Autowired
	StudentService studentService;
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	/**
	 * for test everythings
	 */
	@RequestMapping(value = "test", method =  RequestMethod.POST)
	public Object testPage(@ModelAttribute Course c){
		
//		Message msg = new Message(Message.);
//		msg.setMsg_content(Crypto.SHA1("Hello"));
//		return msg;
	Message msg = courseService.insert(c);
	return msg;
	}
	
}
