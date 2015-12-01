package com.erss.Services;

import java.util.List;

import com.erss.Models.Course;
import com.erss.Models.Message;

public interface CourseService {

	public Message findOne(String cid);
	public Message find(Course c); 
	public Message insert(Course c);
	public boolean delete(String cid);
	public Message update(Course c);

}
