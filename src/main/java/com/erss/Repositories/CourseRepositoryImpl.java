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
	public Course findOne(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Course c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Course cid) {
		// TODO Auto-generated method stub
		return false;
	}

}
