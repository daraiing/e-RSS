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
	public List<Student> findAll();
	public List<Student> findByAdvisor();
	public boolean insert(Student st);
	public boolean delete(Student st);
	public boolean update(Student st);

}
