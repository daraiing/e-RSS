package com.erss.Services;

import java.util.List;

import com.erss.Models.Message;
import com.erss.Models.Student;

public interface StudentService {
	public Student findOne(String sid);
	public List<Student> find(Student st);
	public List<Student> findByAdvisor(String tid);
	public boolean insert(Student st);
	public boolean delete(Student st);
	public boolean update(Student st);

}
