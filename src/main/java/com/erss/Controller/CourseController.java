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
	public boolean insertCourse(@RequestBody Course c) throws MessageGenericException {
		return courseService.insert(c);
	}

	@RequestMapping(value = "{cid}", method = RequestMethod.DELETE)
	public boolean deleteCourse(@PathVariable("cid") String cid) throws MessageGenericException {
		return courseService.delete(cid);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public boolean updateCourse(@RequestBody Course c) throws MessageGenericException {
		return courseService.update(c);
	}

	@RequestMapping(value = "search/{cid}", method = RequestMethod.GET)
	public Course findById(@PathVariable("cid") String cid) {
		return courseService.findOne(cid);
	}

}
