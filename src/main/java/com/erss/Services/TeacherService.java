package com.erss.Services;

import java.util.List;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Message;
import com.erss.Models.Teacher;

public interface TeacherService {
	
	public List<Teacher> find(Teacher t);
	public boolean insert(Teacher t) throws MessageGenericException;
	public boolean delete(Teacher t) throws MessageGenericException;
	public boolean update(Teacher t) throws MessageGenericException;

}
