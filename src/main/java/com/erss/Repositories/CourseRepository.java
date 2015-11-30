package com.erss.Repositories;

import java.util.List;

import com.erss.Models.Course;

/**
 * 
 * @author darathorn.t
 *
 */
public interface CourseRepository {
	
	public Course findOne(int cid);
	public List<Course> findAll(); 
	public boolean insert(Course c);
	public boolean delete(Course c);
	public boolean update(Course c);

}
