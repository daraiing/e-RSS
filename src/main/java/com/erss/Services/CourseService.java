package com.erss.Services;

import java.util.List;

import com.erss.Models.Course;
import com.erss.Models.Message;

public interface CourseService {

	public Course findOne(String cid);
	public List<Course> find(Course c); 
	public boolean insert(Course c);
	public boolean delete(String cid);
	public boolean update(Course c);

}
