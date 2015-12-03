package com.erss.Controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public Message insertCourse(@RequestBody Course c, HttpServletResponse response) throws MessageGenericException {
		if (courseService.insert(c)) {
			response.setStatus(response.SC_CREATED);
			return new Message("SUC_COURSE_INSERT", "Insert new course success!");
		} else {
			throw new MessageGenericException("ERR_COURSE_INSERT", "Failed to insert new course!",
					response.SC_BAD_REQUEST);
		}
	}

	@RequestMapping(value = "{cid}", method = RequestMethod.DELETE)
	public Message deleteCourse(@PathVariable("cid") String cid, HttpServletResponse response)
			throws MessageGenericException {
		if(courseService.delete(cid)){
			return new Message("SUC_COURSE_DELETE", "Delete course 'cid : "+cid+"' success!");
		}else{
			throw new MessageGenericException("ERR_COURSE_DELETE", "Failed to delete course 'cid : "+cid+"'", response.SC_BAD_REQUEST);
		}
		
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Message updateCourse(@RequestBody Course c, HttpServletResponse response) throws MessageGenericException {
		if (courseService.update(c)) {
			return new Message("SUC_COURSE_UPDATE", "Update course 'cid : " + c.getCid() + "' success!");
		} else {
			throw new MessageGenericException("ERR_COURSE_UPDATE", "Failed to update course 'cid : " + c.getCid() + "'",
					response.SC_BAD_REQUEST);
		}
	}

	// @RequestMapping(method = RequestMethod.PUT)
	// public boolean updatepCourse(@ModelAttribute Course c) throws
	// MessageGenericException {
	//// Course co = courseService.findOne(c.getCid());
	// return courseService.update(courseService.findOne(c.getCid()));
	// }

	@RequestMapping(value = "search/{cid}", method = RequestMethod.GET)
	public Course findById(@PathVariable("cid") String cid) {
		return courseService.findOne(cid);
	}

	@ExceptionHandler(MessageGenericException.class)
	public Message error(MessageGenericException ex, HttpServletResponse response) {
		if (ex != null) {
			response.setStatus(ex.getStatusCode());
			return new Message(ex.getErrId(), ex.getErrMsg());
		} else
			return new Message("ERR_COURSE_SERVICE", "Unknown error my exception!");
	}

	@ExceptionHandler(Exception.class)
	public Message error(Exception ex, HttpServletResponse response) {
		return new Message("ERR_COURSE_SERVICE", "Something wrong! please check detail in server log.");
	}

}
