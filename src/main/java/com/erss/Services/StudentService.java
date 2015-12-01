package com.erss.Services;

import java.util.List;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Student;

public interface StudentService {
	public Student findOne(String sid);
	public List<Student> find(Student st);
	public List<Student> findByAdvisor(String tid);
	public boolean insert(Student st) throws MessageGenericException;
	public boolean delete(Student st) throws MessageGenericException;
	public boolean update(Student st) throws MessageGenericException;

}
