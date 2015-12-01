package com.erss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.erss.Models.Course;
import com.erss.Models.Message;
import com.erss.Services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value = "insert", method =  RequestMethod.POST)
	public Object insertCourse(@ModelAttribute Course c){
	Message msg = courseService.insert(c);
	return msg;
	}
	
	@RequestMapping(value="delete",method = RequestMethod.POST)
	public Object deleteCourse(@ModelAttribute Course c)
	{
		Message msg = courseService.delete(c);
		return msg;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Object updateCourse(@ModelAttribute Course c)
	{
		Message msg = courseService.update(c);
		return msg;
//		return null;
	}
	
	@RequestMapping(value="find",method = RequestMethod.GET)
	public Object findById(@RequestParam("cid") String cid)
	{
		Message msg = courseService.findOne(cid);
		return msg;
	}

}
