package com.erss.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.erss.Exception.MessageGenericException;
import com.erss.Models.Course;
import com.erss.Models.Message;
import com.erss.Repositories.CourseRepository;
import com.erss.Util.Crypto;

public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Course findOne(String cid) {
		if(cid==null || cid.isEmpty())
		{
			throw new MessageGenericException("ERR_CO-SE", "Primary Key : The CourseId has incorrect input!", 400);
		}
		if(courseRepository.findOne(cid) == null)
		{
			throw new MessageGenericException("ERR_CO-SE", "Undefined Data : Doesn't Exist in the Database", 404);
		}
		return courseRepository.findOne(cid);
	}

	@Override
	public List<Course> find(Course c) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean update(Course c) {
		if(c.getCid() == null || c.getCid().isEmpty())
		{
			throw new MessageGenericException("ERR_CO-UPDATE", "Primary Key Lost: The CouurseId has incorrect input!", 400);
		}
		if (courseRepository.findOne(c.getCid()) == null) {
			throw new MessageGenericException("ERR_CO-UPDATE", "Undefined Data : Doesn't Exists in the Database", 404);
		}
		return courseRepository.update(c);
	}

	@Override
	public boolean delete(String cid) {
		
		if(cid==null || cid.isEmpty())
		{
			throw new MessageGenericException("ERR_CO-SE", "Primary Key : The CourseId has incorrect input!", 400);
		}
		if(courseRepository.findOne(cid) == null)
		{
			throw new MessageGenericException("ERR_CO-SE", "Undefined Data : Doesn't Exist in the Database", 404);
		}
		return courseRepository.delete(cid);
	}

	@Override
	public boolean insert(Course c) {
		if(c.getCid() == null || c.getCid().isEmpty())
		{
			throw new MessageGenericException("ERR_CO-UPDATE", "Primary Key Lost: The CouurseId has incorrect input!", 400);
		}
		if (courseRepository.findOne(c.getCid()) != null) {
			throw new MessageGenericException("ERR_CO-UPDATE", "Data Conflict : Already Exists in the Database", 409);
		}
		return courseRepository.insert(c);
	}

}
