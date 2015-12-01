package com.erss.Services;

import java.util.List;

import com.erss.Models.Message;
import com.erss.Models.Student;

public interface StudentService {
	public Message findOne(String sid);
	public List<Student> find(Student st);
	public Message findByAdvisor(String tid);
	public Message insert(Student st);
	public Message delete(Student st);
	public Message update(Student st);

}
