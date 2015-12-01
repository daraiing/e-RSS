package com.erss.Repositories;

import java.util.List;

import com.erss.Models.Teacher;

/**
 * 
 * @author darathorn.t
 *
 */
public interface TeacherRepository {
	
	public Teacher fineOne(String tid);
	public List<Teacher> find(Teacher t);
	public boolean insert(Teacher t);
	public boolean delete(Teacher t);
	public boolean update(Teacher t);
	public List<Teacher> findAll();
}
