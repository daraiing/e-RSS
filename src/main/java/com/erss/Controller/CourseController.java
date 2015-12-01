package com.erss.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Course;
import com.erss.Models.Message;
import com.erss.Services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService courseService;

	@RequestMapping(method = RequestMethod.POST)
	public void insertCourse(@RequestBody Course c) throws MessageGenericException {
		courseService.insert(c);
	}

	@RequestMapping(value = "{cid}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("cid") String cid) throws MessageGenericException {
		courseService.delete(cid);
	}

	@RequestMapping(method = RequestMethod.PATCH)
	public Object updateCourse(@PathVariable("cid") String cid) {
		Message msg = courseService.update((Course) courseService.findOne(cid).getMsgContent());
		return msg;
		// return null;
	}

	@RequestMapping(value = "find", method = RequestMethod.GET)
	public Object findById(@RequestParam("cid") String cid) {
		Message msg = courseService.findOne(cid);
		return msg;
	}

}
