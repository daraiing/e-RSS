package com.erss.Repositories;

import java.util.List;

import com.erss.Models.Student;

/**
 * 
 * @author darathorn.t
 *
 */
public interface StudentRepository {
	
	public Student findOne(String sid);
	public List<Student> find(Student st);
	public List<Student> findByAdvisor(String tid);
	public boolean insert(Student st);
	public boolean delete(Student st);
	public boolean update(Student st);
}
