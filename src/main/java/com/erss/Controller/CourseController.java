package com.erss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erss.Models.Course;
import com.erss.Models.Message;
import com.erss.Services.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value = "insert", method =  RequestMethod.POST)
	public @ResponseBody Object testPage(@ModelAttribute Course c){
	Message msg = courseService.insert(c);
	return msg;
	}

}
