package com.erss.Services;

import java.util.List;

import com.erss.Models.Faculty;
import com.erss.Models.Message;

public interface FacultyService {

	public Message findOne(int  fcId);
	public Message find(Faculty fc);
	public Message insert(Faculty f);
	public Message delete(Faculty f);
	public Message update(Faculty f);
}
