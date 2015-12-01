package com.erss.Services;

import java.util.List;

import com.erss.Models.Faculty;
import com.erss.Models.Message;

public interface FacultyService {

	public Faculty findOne(int  fcId);
	public List<Faculty> find(Faculty fc);
	public boolean insert(Faculty f);
	public boolean delete(Faculty f);
	public boolean update(Faculty f);
}
