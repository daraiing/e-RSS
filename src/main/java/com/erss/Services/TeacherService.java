package com.erss.Services;

import java.util.List;

import com.erss.Models.Message;
import com.erss.Models.Teacher;

public interface TeacherService {
	
	public Message Message(String tid);
	public Message find(Teacher t);
	public Message insert(Teacher t);
	public Message delete(Teacher t);
	public Message update(Teacher t);

}