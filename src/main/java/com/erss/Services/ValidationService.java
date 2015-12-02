package com.erss.Services;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Message;
import com.erss.Models.Student;
import com.erss.Models.Teacher;

public interface ValidationService {
	public Student validationStudent(String sid,String password) throws MessageGenericException;
	public Teacher validationTeacher(String tid,String password) throws MessageGenericException;
}
