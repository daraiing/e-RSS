package com.erss.Services;

import java.util.List;

import com.erss.Models.Message;
import com.erss.Models.Teacher;

public interface TeacherService {
	
	public List<Teacher> find(Teacher t);
	public boolean insert(Teacher t);
	public boolean delete(Teacher t);
	public boolean update(Teacher t);

}
