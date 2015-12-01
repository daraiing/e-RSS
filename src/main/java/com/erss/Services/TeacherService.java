package com.erss.Services;

import com.erss.Models.Message;
import com.erss.Models.Teacher;

public interface TeacherService {
	
	public Message find(Teacher t);
	public Message insert(Teacher t);
	public Message delete(Teacher t);
	public Message update(Teacher t);

}
