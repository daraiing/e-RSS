package com.erss.Repositories;

import java.util.List;

import com.erss.Models.Course;

/**
 * 
 * @author darathorn.t
 *
 */
public interface CourseRepository {
	
	public Course findOne(String cid);
	public List<Course> find(Course c); 
	public boolean insert(Course c);
	public boolean delete(Course c);
	public boolean update(Course c);
	public List<Course> findAll();

}
