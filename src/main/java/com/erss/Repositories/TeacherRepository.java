package com.erss.Repositories;

import java.util.List;

import com.erss.Models.Teacher;

/**
 * 
 * @author darathorn.t
 *
 */
public interface TeacherRepository {
	
	public Teacher findOne(String tid);
	public List<Teacher> find(Teacher t);
	public boolean insert(Teacher t);
	public boolean delete(String tid);
	public boolean update(Teacher t);
}
