package com.erss.Services;

import java.util.List;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Course;
import com.erss.Models.Message;

public interface CourseService {

	public Course findOne(String cid);
	public List<Course> find(Course c); 
	public boolean insert(Course c) throws MessageGenericException;
	public boolean delete(String cid) throws MessageGenericException;
	public boolean update(Course c) throws MessageGenericException;

}
