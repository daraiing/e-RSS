package com.erss.Repositories;

import java.util.List;

import com.erss.Models.Faculty;

/**
 * 
 * @author darathorn.t
 *
 */
public interface FacultyRepository {

	public Faculty findOne(int  fcId);
	public List<Faculty>findAll();
	public boolean insert(Faculty f);
	public boolean delete(Faculty f);
	public boolean update(Faculty f);
}
