package com.erss.Repositories;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.erss.Models.Course;

public class CourseRepositoryImpl implements CourseRepository {

	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public boolean insert(Course c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Course c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Course c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> find(Course c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course findOne(String cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
